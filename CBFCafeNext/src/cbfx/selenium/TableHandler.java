/******************************************************************************
$Id : TableHandler.java 3/3/2016 7:07:40 PM
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

package cbfx.selenium;

import static cbf.engine.TestResultLogger.failed;
import static cbf.engine.TestResultLogger.passed;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cbf.utils.LogUtils;
import cbf.utils.SleepUtils;
import cbf.utils.StringUtils;

public class TableHandler {


	/**
	 * For getting WebElement of an element
	 * 
	 * @param elementName
	 *            Element name for table locator - uiMap
	 * @return WebElement - WebElement for element Name
	 */

	public TableHandler(WebUIDriver driver) {
		this.driver=driver;
	}

	public WebElement getWebElement(String elementName) {
		WebElement tableElement = null;
		try {

			tableElement = driver.getControl(elementName);

		} catch (Exception e) {
			logger.handleError("Failed to get WebElement ", elementName);
		}
		return tableElement;
	}

	/**
	 * For getting total number of columns in table
	 * 
	 * @param elementName
	 *            Element name for table locator - uiMap
	 * @return int - Number of columns
	 */

	public int getColumnCount(String elementName) {
		int col_count = 0;

		try {
			col_count = getWebElement(elementName).findElements(
					By.tagName("td")).size();
		} catch (Exception e) {
			logger.handleError("Failed to get row count for ", elementName);
		}
		return col_count;
	}

	/**
	 * For getting total number of rows in table
	 * 
	 * @param elementName
	 *            Element name for table locator - uiMap
	 * @return int - Number of rows
	 */
	public int getRowCount(String elementName) {
		int row_count = 0;
		try {
			row_count = getWebElement(elementName).findElements(
					By.tagName("tr")).size();

		} catch (Exception e) {
			logger.handleError("Failed to get row count for ", elementName);
		}
		return row_count;
	}

	/**
	 * For getting total number of columns for particular row in table
	 * 
	 * @param elementName
	 *            Element name of table
	 * @return int - Number of columns
	 */

	public int getColumnCountOfRow(String elementName) {
		WebElement tableElement = getWebElement(elementName);

		List<WebElement> td_collection = tableElement.findElement(
				By.tagName("tr")).findElements(By.tagName("td"));
		try {
			if (td_collection.size() == 0) {
				td_collection = tableElement.findElement(By.tagName("tr"))
						.findElements(By.tagName("th"));
			}
		} catch (Exception e) {
			logger.handleError("Failed to get column count for ", tableElement);
		}
		return td_collection.size();
	}

	/**
	 * For getting an object of the table - name matches with given text
	 * 
	 * @param textTosearch
	 *            Name of the table you want to search
	 * @return WebElement - Object of table
	 */
	public WebElement getTableObjectByText(String textTosearch) {
		List<WebElement> tablecollection = webDr.findElements(By
				.tagName("table"));
		int FinalIndex = 0;
		try {
			for (int i = 0; i < tablecollection.size(); i++) {
				if (tablecollection.get(i).getText().contains(textTosearch)) {
					FinalIndex = i;
					break;
				}
				if (i == tablecollection.size() - 1) {
					failed("FAIL", "The table does not exist",
							"The table with the given text,'" + textTosearch
							+ "' is not present");
				}
			}
		} catch (Exception e) {
			logger.handleError("Failed to get text ", textTosearch, "for ",
					textTosearch, " ", e);
		}
		return tablecollection.get(FinalIndex);
	}

	/**
	 * For getting data of particular cell
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param col
	 *            Column number
	 * @return String - Data of that particular cell
	 */

	public String getCellData(String elementName, int row, int col) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));
		int row_num = 0;
		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {

				if (row_num == row) {
					List<WebElement> td_collection = trElement.findElements(By
							.tagName("td"));

					if (td_collection.size() == 0) {
						td_collection = trElement
								.findElements(By.tagName("th"));
					}
					Data = td_collection.get(col).getText();

					break;
				}

				row_num++;
			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		return Data;
	}
	/**
	 * For getting data of particular cell Color
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param col
	 *            Column number
	 * @return String - Data of that particular cell Color
	 */
	public String getCellDataofcolor(String elementName, int row, int col) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));
		int row_num = 0;
		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {

				if (row_num == row) {
					List<WebElement> td_collection = trElement.findElements(By
							.tagName("td"));

					if (td_collection.size() == 0) {
						td_collection = trElement
								.findElements(By.tagName("th"));
					}
					Data = td_collection.get(col).getCssValue("color");

					break;
				}

				row_num++;
			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		return Data;
	}
	/**
	 * Verifying data of particular Column of all row values
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param col
	 *            Column number
	 * @return String - Data of that particular Column of all row values
	 */
	public String getCellDataOfCol(String elementName, String SearchString, int col) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));
		boolean sflag = false;
		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {

				List<WebElement> td_collection = trElement.findElements(By 
						.tagName("td"));

				if (td_collection.size() == 0) {
					td_collection = trElement
							.findElements(By.tagName("th"));
				}
				Data = td_collection.get(col).getText();
				if(Data.equalsIgnoreCase(SearchString));
				{
					passed("Passed", "The table  exist",
							"The table with the given text,'" + SearchString
							+ "' is  presented");
					sflag=true;
					break;
				}  

			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		if(!sflag) {
			failed("failed", "The table  exist",
					"The table with the given text,'" + SearchString
					+ "' is not presented");
		}
		return Data;
	}
	/**
	 * Verifying data not presented in table
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param col
	 *            Column number
	 * @return String - Data of that particular Column of all row values
	 */

	public String VerifyTextNotPresentInTable(String elementName, String SearchString, int col) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));
		boolean sflag = false;
		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {

				List<WebElement> td_collection = trElement.findElements(By 
						.tagName("td"));

				if (td_collection.size() == 0) {
					td_collection = trElement
							.findElements(By.tagName("th"));
				}
				Data = td_collection.get(col).getText();
				if(!Data.equalsIgnoreCase(SearchString));
				{
					passed("Passed", "The table  exist",
							"The table with the given text,'" + SearchString
							+ "' is not presented");
					sflag=true;
					break;
				}  

			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		if(!sflag) {
			failed("failed", "The table  exist",
					"The table with the given text,'" + SearchString
					+ "' is  presented");
		}
		return Data;
	}
	/**
	 * Get the Cell Data of Related Column in Table
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param col
	 *            Column number
	 * @return String - Get the Cell data of Related Column in Table
	 */

	public String getCellDataOfRelatedColumn(String elementName, String SearchString, int col, int RelatedCol) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));

		String RelatedCellData = null;
		try {
			for (WebElement trElement : tr_Collection) {

				List<WebElement> td_collection = trElement.findElements(By 
						.tagName("td"));

				if (td_collection.size() == 0) {
					td_collection = trElement
							.findElements(By.tagName("th"));
				}
				String Data = td_collection.get(col).getText();
				if(Data.equalsIgnoreCase(SearchString));
				{
					RelatedCellData = td_collection.get(RelatedCol).getText();
					passed("Passed", "The table  exist",
							"The table with the given text,'" + SearchString
							+ "' is  presented");
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		return RelatedCellData;
	}
	/**
	 * Get the Cell Data Column in Table
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param col
	 *            Column number
	 * @return String - Get the Cell Data Column in Table
	 */
	public String getCellDataOfColumn(String elementName,  int col) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));

		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {

				List<WebElement> td_collection = trElement.findElements(By 
						.tagName("td"));

				if (td_collection.size() == 0) {
					td_collection = trElement
							.findElements(By.tagName("th"));
				}
				Data = td_collection.get(col).getText();

			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		return Data;
	}

	/**
	 * For getting data of particular cell
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param row
	 *            Row number
	 * @param colName
	 *            Column name
	 * @return String - Data of that particular cell
	 */

	public String getCellData(String elementName, int row, String colName) {
		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));
		int row_num = 0;
		int col_num = 0;
		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {
				if (row_num == 0) {
					List<WebElement> td_col = trElement.findElements(By
							.tagName("td"));
					if (td_col.size() == 0) {
						td_col = trElement.findElements(By.tagName("th"));
					}
					for (int i = 0; i < td_col.size(); i++) {
						if (td_col.get(i).getText().contains(colName)) {
							col_num = i;
							break;
						}
					}
				}

				if (row_num == row) {
					List<WebElement> td_collection = trElement.findElements(By
							.tagName("td"));
					Data = td_collection.get(col_num).getText();
					break;
				}

				row_num++;
			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}
		return Data;

	}

	/**
	 * For getting data of particular cell
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param rowName
	 *            Row name
	 * @param colName
	 *            Column name
	 * @return String - Data of that particular cell
	 */
	public String getCellData(String elementName, String rowName, String colName) {

		WebElement tableElement = getWebElement(elementName);
		List<WebElement> tr_Collection = tableElement.findElements(By
				.tagName("tr"));
		int row_num = 0;
		int col_num = 0;

		String Data = null;
		try {
			for (WebElement trElement : tr_Collection) {
				if (row_num == 0) {
					List<WebElement> td_col = trElement.findElements(By
							.tagName("td"));

					for (int i = 0; i < td_col.size(); i++) {
						if (td_col.get(i).getText().contains(colName)) {
							col_num = i;
							break;
						}
					}
				}
				List<WebElement> td_col = trElement.findElements(By
						.tagName("td"));
				if (td_col.get(0).getText().contains(rowName)) {
					Data = td_col.get(col_num).getText();
					break;
				}
				row_num++;
			}
		} catch (Exception e) {
			logger.handleError("Failed to get cell data for ", tableElement,
					" ", e);
		}

		return Data;

	}
	/**
	 * For getting data of Relative Cell 
	 * 
	 * @param tableElement
	 *            Element of the table
	 * @param rowName
	 *            Row name
	 * @param colName
	 *            Column name
	 * @return String - getting data of Relative Cell
	 */
	public String getRelativeCellData(String elementName, String searchName,
			int columnNumber) {
		int row_count = 0;
		String cellData = null;

		WebElement tableElement = getWebElement(elementName);
		List<WebElement> allRows = tableElement.findElements(By.tagName("tr"));
		try {
			for (WebElement row : allRows) {
				int col_count = 0;
				List<WebElement> cells = row.findElements(By.tagName("td"));

				row.findElement(By.tagName("td")).click();
				for (WebElement cell : cells) {
					if (cell.getText().equals(searchName)) {
						cellData = getCellData(elementName, row_count,
								columnNumber);
						break;
					}

					col_count++;
				}
				row_count++;
			}

		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);

		}
		return cellData;
	}

	/*
	 * For Searching relative cell based on some value
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return int - Number of rows
	 */
	public String findRelativeCellAndClick(String elementName,
			String searchName, int columnNumber, String text) {
		int row_count = 0;
		String cellData = null;

		WebElement tableElement = getWebElement(elementName);
		List<WebElement> allRows = tableElement.findElements(By.tagName("tr"));
		try {
			for (WebElement row : allRows) {
				int col_count = 0;
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					if (cell.getText().equals(searchName)) {
						cellData = getCellData(elementName, row_count,
								columnNumber);
						if (cellData.equals(text)) {
							clickCell(cell);
						}
						break;
					}

					col_count++;
				}

				row_count++;
				if (cellData != null) {
					break;
				}

			}

		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);

		}
		return cellData;
	}
	/**
	 * For web Element in Table 
	 * 
	 * @param tableElement
	 *            Element of the table
	 */
	public void clickCell(WebElement element) {

		element.click();

	}

	/*
	 * For Searching relative cell based on some value click select cellvalue
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickSelectedCell(String elementName,
			String searchName, int columnNumber, String text, String targettext) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {

				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								for (WebElement tCell : cells1) {
									if (tCell.getText().equals(targettext)) {
										clickCell(tCell);
										passed("click on element" + " " + elementName,
												" " + "element" + " " + elementName + " " + "should be clicked",
												"element" + " " + elementName + " " + "clicked successfully");

										sTest = true;
										break;
									}
								}
							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	/*
	 * For Searching relative cell based on some value click select cellvalue in Subtext
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickSelectedCellInSubtext(String elementName,
			String searchName, int columnNumber, String text, String targettext,String subtext) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {

				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								for (WebElement tCell : cells1) {
									if (tCell.getText().equals(targettext)) {
										//clickCell(tCell);
										List<WebElement> hLinks=tCell.findElements(By.tagName("a"));
										for (WebElement hLink : hLinks) {
											if (hLink.getText().equals(subtext)) {
												clickCell(hLink);
												passed("click on element" + " " + elementName,
														" " + "element" + " " + elementName + " " + "should be clicked",
														"element" + " " + elementName + " " + "clicked successfully");

												sTest = true;
												break;
											}
										}
										break;
									}
								}
							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	/*
	 * For Searching relative cell and click selected column
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickSelectedcolumn(String elementName,
			String searchName, int columnNumber, String text, int RelatedColum) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {

				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								String  value=cells1.get(RelatedColum).getText();
								//if (cellData.equals(text)) {
								List<WebElement> cells2 =row.findElements(By.tagName("td"));
								for (WebElement tCell : cells2) {
									if (tCell.getText().equals(value)) {
										List<WebElement> hLinks=tCell.findElements(By.tagName("a"));
										for (WebElement hLink : hLinks) {
											if (hLink.getText().equals(value)) {
												clickCell(hLink);
												passed("click on element" + " " + elementName,
														" " + "element" + " " + elementName + " " + "should be clicked",
														"element" + " " + elementName + " " + "clicked successfully");

												sTest = true;
												break;
											}
										}
										break;
									}
								}
								//}   

							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}

	/*
	 * For Searching relative cell and click selected cell in sub text
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickSelectedCellAndSubtext(String elementName,
			String searchName, int columnNumber, String text, String targettext,String subtext) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {

				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								for (WebElement tCell : cells1) {
									if (tCell.getText().equals(targettext)) {
										clickCell(tCell);
										List<WebElement> hLinks=tCell.findElements(By.tagName("a"));
										for (WebElement hLink : hLinks) {
											if (hLink.getText().equals(subtext)) {
												clickCell(hLink);
												passed("click on element" + " " + elementName,
														" " + "element" + " " + elementName + " " + "should be clicked",
														"element" + " " + elementName + " " + "clicked successfully");

												sTest = true;
												break;
											}
										}
										break;
									}
								}
							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	/*
	 * For Searching relative cell and click first cell in the table
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickfirstCell(String elementName,
			String searchName, int columnNumber, String text) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {

				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								for (WebElement tCell : cells1) {
									clickCell(tCell);
									passed("click on element" + " " + elementName,
											" " + "element" + " " + elementName + " " + "should be clicked",
											"element" + " " + elementName + " " + "clicked successfully");

									sTest = true;
									break;
								}
							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	

	/*
	 * For Searching relative cell and click Selected cell
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickSelectedCell(String elementName,
			String searchName, int columnNumber, int CellNumber, String text) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {
				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								int colnum=0;
								for (WebElement tCell : cells1) {
									colnum=colnum+1;
									if(colnum==CellNumber) {
										clickCell(tCell);
										passed("click on element" + " " + elementName,
												" " + "element" + " " + elementName + " " + "should be clicked",
												"element" + " " + elementName + " " + "clicked successfully");
										sTest = true;
										break;
									}
								}
							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	/*
	 * For Searching relative cell and click Selected cell in Link
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellAndClickSelectedCellInlink(String elementName,
			String searchName, int columnNumber, int CellNumber, String text) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {
				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().equals(searchName)) {
							cellData = getCellData(elementName, row_count, columnNumber);
							if (cellData.equals(text)) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								int colnum=0;
								for (WebElement tCell : cells1) {
									if(colnum==CellNumber) {
										List<WebElement> hLinks=tCell.findElements(By.tagName("a"));
										for (WebElement hLink : hLinks) {
											clickCell(hLink);
											passed("click on element" + " " + elementName,
													" " + "element" + " " + elementName + " " + "should be clicked",
													"element" + " " + elementName + " " + "clicked successfully");
											sTest = true;
											break;
										}
									}
									colnum=colnum+1;
								}
							}
							break;
						}

						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	/*
	 * For Searching relative cell With Multipul text and Click first Cell
	 * 
	 * @param elementName Element name for table locator - uiMap
	 * 
	 * @return Cell data
	 */
	public String findRelativeCellWithMultipulTextAndClickfirstCell(String elementName,
			String searchName, int columnNumber) {
		int row_count = 0;
		String cellData = null;
		boolean sTest = false;

		WebElement tableElement =getWebElement(elementName);
		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

		try {

			for (WebElement table : allTables) {

				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					int col_count = 0;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if(searchName.contains("|")) {
							if (cell.getText().equals("Active") || cell.getText().equals("Reinstated")) {
								List<WebElement> cells1 =row.findElements(By.tagName("td"));
								for (WebElement tCell : cells1) {
									clickCell(tCell);
									passed("click on element" + " " + elementName,
											" " + "element" + " " + elementName + " " + "should be clicked",
											"element" + " " + elementName + " " + "clicked successfully");

									sTest = true;
									break;
								}
								break;
							}
						}
						col_count++;
					}

					row_count++;
					if (sTest) {
						break;
					}
					if (cellData != null) {
						break;
					}

				}
				if (sTest) {
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("getRelativeCellData ", elementName);
			failed("click on element" + " " + elementName,
					" " + "element" + " " + elementName + " " + "should be clicked",
					"element" + " " + elementName + " " + "clicked successfully");

		}
		return cellData;
	}
	

/**
       * Verifying data of particular Column of all row values
       * 
        * @param tableElement
       *            Element of the table
       * @param row
       *            Row number
       * @param col
       *            Column number
       * @return String - Data of that particular Column of all row values
       */
       public String verfiygetCellDataOfColumn(String elementName, String SearchString, int col) {
              WebElement tableElement = getWebElement(elementName);
              List<WebElement> tr_Collection = tableElement.findElements(By
                           .tagName("tr"));
              boolean sflag = false;
              String Data = null;
              try {
                     for (WebElement trElement : tr_Collection) {

                           List<WebElement> td_collection = trElement.findElements(By 
                                         .tagName("td"));

                           if (td_collection.size() == 0) {
                                  td_collection = trElement
                                                .findElements(By.tagName("th"));
                           }
                           Data = td_collection.get(col).getText();
                           if(Data.contains(SearchString));
                           {
                                  passed("Passed", "The table  exist",
                                                "The table with the given text,'" + SearchString
                                                + "' is  presented");
                                  sflag=true;
                                  break;
                           }  

                     }
              } catch (Exception e) {
                     logger.handleError("Failed to get cell data for ", tableElement,
                                  " ", e);
              }
              if(!sflag) {
                     failed("failed", "The table  exist",
                                  "The table with the given text,'" + SearchString
                                  + "' is not presented");
              }
              return Data;
       }
       
       /**
        * Verifying data of particular Column of all row values
        * 
         * @param tableElement
        *            Element of the table
        * @param row
        *            Row number
        * @param col
        *            Column number
        * @return String - Data of that particular Column of all row values
        */
        public boolean verfiyDataPresenceInColumn(String elementName, String SearchString, int col) {
               WebElement tableElement = getWebElement(elementName);
               List<WebElement> tr_Collection = tableElement.findElements(By
                            .tagName("tr"));
               boolean sflag = false;
               String Data = null;
               try {
                      for (WebElement trElement : tr_Collection) {

                            List<WebElement> td_collection = trElement.findElements(By 
                                          .tagName("td"));

                            if (td_collection.size() == 0) {
                                   td_collection = trElement
                                                 .findElements(By.tagName("th"));
                            }
                            Data = td_collection.get(col).getText();
                            if(Data.equalsIgnoreCase(SearchString));
                            {
                                   passed("Passed", "The table  exist",
                                                 "The table with the given text,'" + SearchString
                                                 + "' is  presented");
                                   sflag=true;
                                   break;
                            }  

                      }
               } catch (Exception e) {
                      logger.handleError("Failed to get cell data for ", tableElement,
                                   " ", e);
               }
               if(!sflag) {
                      failed("failed", "The table  exist",
                                   "The table with the given text,'" + SearchString
                                   + "' is not presented");
               }
               return sflag;
        }
    	/*
    	 * For Searching relative cell based on some value click select cellvalue
    	 * 
    	 * @param elementName Element name for table locator - uiMap
    	 * 
    	 * @return Cell data
    	 */
    	public String VerfiyRelativeCellData(String elementName,
    			String searchName, int columnNumber, String text, String targettext) {
    		int row_count = 0;
    		String cellData = null;
    		boolean sTest = false;

    		WebElement tableElement =getWebElement(elementName);
    		List<WebElement> allTables = tableElement.findElements(By.tagName("table"));

    		try {

    			for (WebElement table : allTables) {

    				List<WebElement> allRows = table.findElements(By.tagName("tr"));

    				for (WebElement row : allRows) {
    					int col_count = 0;
    					List<WebElement> cells = row.findElements(By.tagName("td"));
    					for (WebElement cell : cells) {
    						if (cell.getText().equals(searchName)) {
    							cellData = getCellData(elementName, row_count, columnNumber);
    							if (cellData.equals(text)) {
    								List<WebElement> cells1 =row.findElements(By.tagName("td"));
    								for (WebElement tCell : cells1) {
    									if (tCell.getText().contains(targettext)) {
    										clickCell(tCell);
    										passed("click on element" + " " + elementName,
    												" " + "element" + " " + elementName + " " + "should be clicked",
    												"element" + " " + elementName + " " + "clicked successfully");

    										sTest = true;
    										break;
    									}
    								}
    							}
    							break;
    						}

    						col_count++;
    					}

    					row_count++;
    					if (sTest) {
    						break;
    					}
    					if (cellData != null) {
    						break;
    					}

    				}
    				if (sTest) {
    					break;
    				}
    			}
    		} catch (Exception e) {
    			logger.handleError("getRelativeCellData ", elementName);
    			failed("click on element" + " " + elementName,
    					" " + "element" + " " + elementName + " " + "should be clicked",
    					"element" + " " + elementName + " " + "clicked successfully");

    		}
    		return cellData;
    	}



	/**
	 * Overriding toString() method to return TableHandler format string
	 */
	public String toString() {
		return StringUtils.mapString(this);
	}

	private LogUtils logger = new LogUtils(this);
	private WebDriver webDr;
	private ObjectMap objMap;
	private WebUIDriver driver;
}
