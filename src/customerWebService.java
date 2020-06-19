import static io.restassured.RestAssured.given;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.annotations.DataProvider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.customerDetails;
import files.payload;
import files.reUsable;
import files.*;


public class customerWebService {

	customerDetails d=new customerDetails();
	
	@Test(enabled=false)
	public void Test1() {

		RestAssured.baseURI = "https://3a5c0f38-9b11-4659-abf4-49655273ec51.mock.pstmn.io";


		//CreateCustomer
		String createCustomerResponse = given().body(payload.createCustomerData("Harneet","Engineer")).when()
				.post("/v1/createCustomer").then().extract().response().asString();


		//UpdateCustomer
		String putCustomerResponse=given().queryParam("custId",reUsable.rawToJsonResponseKeyValue(reUsable.rawToJsonResponse(createCustomerResponse),"custId")).body(payload.putCustomerData()).when().put("/vi/updateCustomer").then().extract().response().asString();


		//GetCustomer
		String getCustomerDetails = given().queryParam("custId", reUsable.rawToJsonResponseKeyValue(reUsable.rawToJsonResponse(putCustomerResponse),"custId")).when().get("/v1/GetCustomer").then().extract()
				.response().asString();

		Assert.assertEquals(reUsable.rawToJsonResponseKeyValue(reUsable.rawToJsonResponse(getCustomerDetails),"address.locality"), "Pitampura");
	}


	//For getting details of courses
	@Test(enabled=false)
	public void Test2(){
		RestAssured.baseURI ="https://bef3e680-8429-4bd2-b390-3e9191c6fbe8.mock.pstmn.io";
		String getDetailsApiResponse=given().log().all().when().get("/v1/getDetails").then().log().all().extract().response().asString();

		//getResponseCoursesCount
		int getResponseCoursesCount=reUsable.getKeyObjectCount(reUsable.rawToJsonResponse(getDetailsApiResponse),"courses");
		System.out.println("Number of courses are :"+getResponseCoursesCount);

		//titleFirstCourse
		String titleFirstCourse=reUsable.rawToJsonResponseKeyValue(reUsable.rawToJsonResponse(getDetailsApiResponse), "courses[0].title");
		System.out.println("Title of first course is :"+titleFirstCourse);
		
		//getAllTitleAndPrice
		reUsable.iterateOverArray(reUsable.rawToJsonResponse(getDetailsApiResponse), "courses","title");
		reUsable.iterateOverArray(reUsable.rawToJsonResponse(getDetailsApiResponse), "courses","price");

		//numberOfCopiesSoldByRPA
		reUsable.getArrayNodeValue(reUsable.rawToJsonResponse(getDetailsApiResponse),"courses","title","RPA","price");

		//sumOfPriceMatchesPurchasePrice
		int sumOfPrice=reUsable.iterateOverArrayForPrice(reUsable.rawToJsonResponse(getDetailsApiResponse), "courses","price");
		String purchaseAmount=reUsable.rawToJsonResponseKeyValue(reUsable.rawToJsonResponse(getDetailsApiResponse),"dashboard.purchaseAmount");
		System.out.println("purchaseAmount is "+purchaseAmount);
		int a=Integer.valueOf(purchaseAmount);
		//Assert.assertEquals(sumOfPrice, Integer.valueOf(purchaseAmount));
		Assert.assertNotEquals(purchaseAmount, a);
	}
	
	//For working on dynamic JSON PAYLOAD files, as we passed Harneet we made the JSON as dynamic
	@Test(enabled=false)
	public void Test3(){
		RestAssured.baseURI="https://3a5c0f38-9b11-4659-abf4-49655273ec51.mock.pstmn.io";
		//CreateMortgageAccount
		String createMortgage=given().log().all().body(payload.createCustomerData("Harneet","Engineer")).when().get("/v1/createCustomer").then().log().all().extract().response().asString();
	}
	
	
	//For working on dynamic JSON PAYLOAD files using dataProvider
	@Test(enabled=false,dataProvider="customerNames",dataProviderClass=payload.class)
	public void Test4(String name,String designation){
		RestAssured.baseURI="https://3a5c0f38-9b11-4659-abf4-49655273ec51.mock.pstmn.io";
							 	
		//CreateMortgageAccount
		String createMortgage=given().body(payload.createCustomerData(name,designation)).log().all().when().get("/v1/createCustomer").then().log().all().extract().response().asString();
	}

	@Test(enabled=true)
	public void Test6() throws IOException{
		RestAssured.baseURI="https://3a5c0f38-9b11-4659-abf4-49655273ec51.mock.pstmn.io";
	 	
		//CreateMortgageAccount
		String createMortgage=given().body(readFile.readExternalJson("C:\\Users\\hkohli\\Desktop\\test.json")).log().all().when().get("/v1/createCustomer").then().log().all().extract().response().asString();
		
	}
	
	@Test(enabled=true)
	public void Test5() throws IOException{
		//https://corona-virus-stats.herokuapp.com/api/v1/cases/countries-search?limit=217&page=1
			//https://corona-virus-stats.herokuapp.com
				
				///api/v1/cases/countries-search
			//	given().param("limit","217").param("page","1").when().get("/api/v1/cases/countries-search").then().assertThat().statusCode(200).	
	/*	RestAssured.baseURI="https://bef3e680-8429-4bd2-b390-3e9191c6fbe8.mock.pstmn.io";
		String getResponse=given().log().all().when().get("/v1/getDetails").then().log().all().extract().response().asString();
		reUsable.iterateOverArray2(reUsable.rawToJsonResponse(getResponse), "data.rows");*/
				
				RestAssured.baseURI="https://corona-virus-stats.herokuapp.com";
		String getResponse=given().param("limit","217").param("page","1").when().get("/api/v1/cases/countries-search").then().log().all().extract().response().asString();
		reUsable.iterateOverArray2(reUsable.rawToJsonResponse(getResponse), "data.rows");
		
	}
	
	//Working with POJO class
	public void Test7(){
		
		RestAssured.baseURI="https://bef3e680-8429-4bd2-b390-3e9191c6fbe8.mock.pstmn.io";
		Response response=given().log().all().when().get("/v1/home?Mortgage=M000001").then().log().all().extract().response();
		
		
		
				
	}
	

}
