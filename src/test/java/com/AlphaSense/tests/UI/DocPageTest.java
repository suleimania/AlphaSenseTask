package com.AlphaSense.tests.UI;
import com.AlphaSense.pages.DocPage;
import org.testng.annotations.Test;

public class DocPageTest extends DocPage {

    @Test
    public void searchBox(){

        extentLogger = report.createTest("AlphaSense");

        extentLogger.info("Opening mentioned page");
        goToDocPage();

        extentLogger.info("Searching for Additional Keyword \"AlphaSense\"");
        searchForKeyword("AlphaSense");

        extentLogger.info("Scrolling to the last found result and clicking on it");
        scrollToLastAndClick();

        extentLogger.info("Verifying that chosen statement is highlighted in the document viewer");
        isHighlighted();

        extentLogger.pass("Test PASSED");

    }
}
