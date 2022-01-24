package com.AlphaSense.pages;

import com.AlphaSense.tests.UI.TestBase;
import com.AlphaSense.utilities.BrowserUtils;
import com.AlphaSense.utilities.ConfigurationReader;
import com.AlphaSense.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class DocPage extends TestBase {

    public DocPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(css = ".CodeMirror.cm-s-default.CodeMirror-empty")
    public WebElement codeMirrorLocator;

    @FindBy(id = "searchInDocument")
    public WebElement searchInDocumentLocator;

    @FindBy(css = ".snippetItem__content")
    public List<WebElement> snippetItemLocators;

    @FindBy(xpath = "//span[@id='fse6357_7' and text()='https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg']")
    public WebElement lastItemColorLocator;

    @FindBy(xpath ="//span[@id='fse6357_7' and text()='https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg']")
    public WebElement lastItemBackgroundColorLocator;

    @FindBy (xpath = "//span[@class='hl' and text()='https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg']")
    public WebElement lastItemClickLocator;


    public void goToDocPage(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

    public void searchForKeyword(String str){


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].CodeMirror.setValue(\"" + str + "\");", codeMirrorLocator);

        Actions actions = new Actions(driver);
        actions.sendKeys(searchInDocumentLocator, Keys.ENTER).build().perform();
    }

    public void scrollToLastAndClick(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int lastIndex = snippetItemLocators.size();
        js.executeScript("arguments[0].scrollIntoView();", snippetItemLocators.get(lastIndex-1));

        lastItemClickLocator.click();
        BrowserUtils.waitFor(2);
    }

    public void isHighlighted(){
        driver.switchTo().frame("content-1");

        String color = lastItemColorLocator.getCssValue("color");
        String backColor =  lastItemBackgroundColorLocator.getCssValue("background-color");

        Assert.assertFalse( color.equalsIgnoreCase(backColor) );
    }
}
