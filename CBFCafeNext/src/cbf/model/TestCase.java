/******************************************************************************
$Id : TestCase.java 3/3/2016 7:07:24 PM
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

package cbf.model;

import java.util.List;
import java.util.Map;

/**
 * 
 * Defines testcase object structure as acceptable by engine
 * 
 */
public interface TestCase {
	/**
	 * Returns TestCase name
	 * 
	 * @return name
	 */
	public String name();

	/**
	 * Returns count of iterations
	 * 
	 * @return iteration count
	 */
	public int iterationCount();

	/**
	 * Returns TestIteration object
	 * 
	 * @param iterationIx
	 *            index of iteration
	 * @return TestIteration object
	 */
	public TestIteration iteration(int iterationIx);

	/**
	 * Returns Map of references to Master table
	 * 
	 * @return MasterRefernces map
	 */
	public Map masterReferences();

	/**
	 * Returns map of Variables
	 * 
	 * @return Variables map
	 */
	public List<Map> variables();
}
