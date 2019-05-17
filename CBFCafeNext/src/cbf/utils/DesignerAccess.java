/******************************************************************************
$Id : DesignerAccess.java 3/3/2016 7:07:32 PM
Copyright 2016-2017 IGATE GROUP OF COMPANIES. All rights reserved
(Subject to Limited Distribution and Restricted Disclosure Only.)
THIS SOURCE FILE MAY CONTAIN INFORMATION WHICH IS THE PROPRIETARY
INFORMATION OF IGATE GROUP OF COMPANIES AND IS INTENDED FOR USE
ONLY BY THE ENTITY WHO IS ENTITLED TO AND MAY CONTAIN
INFORMATION THAT IS PRIVILEGED, CONFIDENTIAL, OR EXEMPT FROM
DISCLOSURE UNDER APPLICABLE LAW.
YOUR ACCESS TO THIS SOURCE FILE IS GOVERNED BY THE TERMS AND
CONDITIONS OF AN AGREEMENT BETWEEN YOU AND IGATE GROUP OF COMPANIES.
The USE, DISCLOSURE REPRODUCTION OR TRANSFER OF THIS PROGRAM IS
RESTRICTED AS SET FORTH THEREIN.
 ******************************************************************************/

package cbf.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.json.simple.JSONObject;

/**
 * 
 * Utility to handle MongoDB connection
 * 
 */
public class DesignerAccess {

	/**
	 * Makes connection to Designer and returns its response
	 * 
	 * @param params
	 *            Map containing parameters for Designer request
	 */
	public DesignerAccess(Map params) {
		this.parameters = params;
	}

	public JSONObject connect() {

		Map<String, String> args = new HashMap<String, String>();
		args.put("folderpath", (String) parameters.get("folderPath"));
		args.put("tcName", (String) parameters.get("testName"));
		HashMap[] argArray = { (HashMap<String, String>) args };
		HashMap<String, Object> params = new HashMap<String, Object>();
		// TODO: Further cleanup w.r.t testset requirements
		params.put("component", "Service");
		params.put("object", "TestCase");
		params.put("method", "get");

		params.put("versionNumber",(String) parameters.get("version"));

		params.put("arguments", argArray);
		sendRequest(params);
		String response = getResponse(params);
		logger.trace(response);
		if (response != null) {
			response = response.replaceAll("=>", ":").replaceAll("nil", "null");
			return JsonUtils.parseStringToJson(response);
		}
		return null;
	}

	private String getResponse(Map params) {
		String line = null;

		try {
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			SSLConnectionSocketFactory SSLConn = new SSLConnectionSocketFactory(
					builder.build(), new NoopHostnameVerifier());
			CloseableHttpClient httpclient = HttpClients.custom()
					.setSSLSocketFactory(SSLConn).build();
			logger.trace("Executing request " + httpPost.getRequestLine());
			CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				logger.handleError("Error in getting the response status of designer "
						+ httpResponse.getStatusLine());
			}

			InputStream rstream = httpResponse.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					rstream));
			line = br.readLine();
		} catch (Exception e) {
			logger.handleError("Error reading response from designer ", params,
					e);
		}
		return line;
	}

	private void sendRequest(Map params) {
		try {
			httpPost = new HttpPost((String) parameters.get("url") + "/"
					+ (String) parameters.get("projectname"));
			String basicAuth = "Basic "
					+ new String(new Base64().encode(((String) parameters
							.get("username") + ":" + (String) parameters
							.get("password")).getBytes()));
			httpPost.addHeader("Authorization", basicAuth);
			httpPost.addHeader("Content-Type", "application/json");
			StringEntity messageEntity = new StringEntity(
					JsonUtils.ObjectToJsonString(params), ContentType.create(
							"text/plain", "UTF-8"));
			httpPost.setEntity(messageEntity);
		} catch (Exception e) {
			logger.handleError("Error in sending request to designer "
					+ parameters, e);

		}
	}

	/**
	 * Returns DesignerAccess format string
	 */
	public String toString() {
		return StringUtils.mapString(this, parameters.get("folderPath"),
				"username: " + parameters.get("username") + " password: "
						+ parameters.get("password"));
	}

	private LogUtils logger = new LogUtils(this);
	private Map parameters;
	HttpPost httpPost;
}
