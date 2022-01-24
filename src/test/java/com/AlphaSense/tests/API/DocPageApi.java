package com.AlphaSense.tests.API;

import com.AlphaSense.Pojos.SearchBox;
import com.AlphaSense.utilities.ConfigurationReader;
import com.aventstack.extentreports.ExtentReports;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class DocPageApi {

    public static Map<String, Object> parameters(String str){

        Map<String, Object> params = new HashMap<>();

        params.put("keyword", str);
        params.put("slop", 15);
        params.put("positiveOnly", "false");
        params.put("negativeOnly", "false");
        params.put("released", 1633003200000l);

        return params;
    }

        @BeforeTest
        public static void setup() {

        RestAssured.baseURI = ConfigurationReader.get("uri");
    }

    @Test
    public void apiTestGET() {

                 given()
                .accept(ContentType.JSON)
                .and()
                .queryParams(parameters("AlphaSense"))
                .when()
                .get(baseURI)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .contentType(ContentType.JSON);

    }

    //TestCase with deserilization with POJO.
    @Test
    public void contentTest() {

        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .queryParams(parameters("AlphaSense"))
                .when()
                .get(baseURI).prettyPeek();

        SearchBox alphaSense = response.body().as(SearchBox.class);
        String expectedContent = "TITLE HIT";
        String actualContent = alphaSense.getSearchResults().getStatements().get(0).getContent();
        Assert.assertEquals(expectedContent,actualContent);

    }

    // Failed TestCase with deserilization (Json to Java Collection).
    @Test
    public void countSearchKeyword() {

        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .queryParams(parameters("AlphaSense"))
                .when()
                .get(baseURI).prettyPeek();

        Map<String, Object> regionMap = response.body().as(Map.class);

        Map<Map<String,Object>,Object> itemsList = (Map<Map<String, Object>, Object>) regionMap.get("searchResults");

       double count = (double) itemsList.get("originalStatementCount");
       int expectedCount = 18;
       int actualCount = (int) count;
       Assert.assertEquals(expectedCount,actualCount);

       }
}
