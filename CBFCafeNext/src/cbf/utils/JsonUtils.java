/******************************************************************************
$Id : JsonUtils.java 3/3/2016 7:07:33 PM
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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

/**
 * 
 * Utility to handle all the JSON related things
 * 
 */
public class JsonUtils {

	/**
	 * Converts object to string in JSON format
	 * 
	 * @param obj to be converted
	 *            
	 * @return converted String
	 */
	public static String ObjectToJsonString(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	/**
	 * Parses string and converts it to JSONObject
	 * 
	 * @param str to be parsed
	 *            
	 * @return parsed JSONObject
	 */
	public static JSONObject parseStringToJson(String str) {

		JSONParser jsonParser = new JSONParser();

		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) jsonParser.parse(str);
		} catch (ParseException e) {
			logger.handleError("Error in parsing response ", e);
		}
		return jsonObject;
	}

	private JsonUtils() {

	}

	private static LogUtils logger = new LogUtils();

}
