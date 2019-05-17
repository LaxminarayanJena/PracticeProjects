/******************************************************************************
$Id : Utils.java 3/3/2016 7:07:35 PM
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

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Generic utility functions.
 * 
 */
public class Utils {

	/**
	 * Converts passed object array to map
	 * 
	 * @param array
	 *            of object to be converted
	 * @return Map of objects
	 */
	public static Map<Object, Object> toMap(Object[] array) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (int i = 0; i < array.length; i = i + 2) {
			map.put(array[i], array[i + 1]);
		}
		return map;
	}

	/**
	 * Converts passed object to string
	 * 
	 * @param object
	 *            to be converted
	 * @return string format of object
	 */
	public static String toString(Object object) {
		return object.toString();
	}

	/**
	 * Converts given string to boolean value
	 * 
	 * @param value
	 *            string to be converted
	 * @return boolean value of string
	 */
	public static boolean string2Bool(String value) {
		boolean result = false;
		if (StringUtils.match(value, StringUtils.pattern(
				"(Pass|True|Yes|Y|true|yes|YES)", false, true))) {
			result = true;
		}
		if (StringUtils.match(value, StringUtils.pattern(
				"(Fail|False|No|N|false|no|NO)", false, true))) {
			result = false;
		}
		return result;
	}
	
/*  Public Function Array2Dictionary(ByRef Arr)
    Dim dict
    Set dict = CreateObject("Scripting.Dictionary")
    Dim i
    For i = LBound(Arr) to UBound(Arr)-1 Step 2
    Dim Nam, Val
    Nam = Arr(i)
    if VarType(Arr(i+1)) = vbObject then
                    set Val = Arr(i+1)
    else
                    Val = Arr(i+1)
    end if
       dict.add Nam, Val
    Next

    Set Array2Dictionary = dict
    End Function
*/
	public Map<String,String> arrayToMap(String[] arr)
	{   
		Map<String,String> dataMap=new HashMap();
		
		int len=arr.length;
		String key,val;
	    for(int i=0;i<=len-1;i+=2)
	    {
	    	key=arr[i];
	    	val=arr[i+1];
	    	dataMap.put(key, val);
	    }
		
		return dataMap;
	}
	
	
	

	/**
	 * Converts passed map to DataRow object
	 * 
	 * @param map
	 *            to be converted
	 * @return object of DataRow
	 */
	public static DataRow Map2DataRow(Map map) {
		return new DataRow(map);
	}
}
