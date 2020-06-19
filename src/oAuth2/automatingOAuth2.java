package oAuth2;
//RestAssured
import static io.restassured.RestAssured.given;


import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.*;

import org.openqa.selenium.By;
//Selenium Jars
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TestNG
import org.testng.annotations.Test;

import files.OAuth2Data;


public class automatingOAuth2 {

	@Test(enabled=true)
	public void Test1() throws Exception  {
		
		
		//Generate Code
		String code=OAuth2Data.returnCodeValue();
		RestAssured.baseURI="https://accounts.google.com";
		
		//Need to get token from this reponse
		String response=given().urlEncodingEnabled(false).
				queryParam("code", code).
				queryParam("scope", "https://www.googleapis.com/auth/userinfo.email","auth_url","https://accounts.google.com/o/oauth2/v2/auth",
				"client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com",
				"response_type","code",
				"redirect_uri","https://rahulshettyacademy.com/getCourse.php",
				"state","verifyfjdss").header("Content-Type","application/json").log().all().when().get("/o/oauth2/v2/auth").then().log().all().extract().asString();
		
	}
	

}
