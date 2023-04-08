package com.automationfwk.pom.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.pom.base.BasePage;

public class BookstoreGrid extends BasePage 
{

	public BookstoreGrid(WebDriver driver,EnvironmentConfigJsonModel config) 
	{
		super(driver,config);
	}
	
	private By columndata(int row, int col)
	{
		return By.xpath("((//div[contains(@class,'ReactTable')]//div[contains(@class,'rt-tr-group')])"
				+ "["+row+"]//div[@role='gridcell'])["+col+"]");
	}
	
	public String getColumnData(int row, int col)
	{
		return wait.until(d -> d.findElement(this.columndata(row,col))).getText();
	}
	
	@FindBy(xpath="//div[contains(@class,'ReactTable')]//div[contains(@class,'rt-resizable-header-content')]")
	private List<WebElement> gridHeaders;
	
	@FindBy(xpath="//div[contains(@class,'ReactTable')]//div[contains(@class,'rt-tr-group')]")
	private List<WebElement> gridRow;
	
	public int getGridColumnIndex(String colName)
	{
		wait.until(d -> gridHeaders.size()>0);
		
		int index=0;
		for(WebElement ele: gridHeaders)
		{
			index++;
			if(ele.getText().contains(colName)) return index;
		}
		return -1;
	}
	
	public int getGridRowCount()
	{
		wait.until(d -> gridRow.size()>0);
		return gridRow.size();
	}	
}
