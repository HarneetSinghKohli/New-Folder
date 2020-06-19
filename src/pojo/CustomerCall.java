package pojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;


import pojo.customerDetails;

public class CustomerCall {

	@Test
	public void Test1(){
	RestAssured.baseURI="https://3a5c0f38-9b11-4659-abf4-49655273ec51.mock.pstmn.io/";
	
	customerDetails response =given().queryParam("custId", "001")              // If in header the response type is set as application/json then this is not needed
			.when()
			.get("v1/GetCustomer")
			.as(customerDetails.class);
	
	System.out.println("Customer Id is "+response.getCustId());
//	response.getCoursesDetails().getApiAutomationDetails().get(0).getPrice();
	
	
//	System.out.println("Customer Company name is "+a.getCourseName());
	}
	
}
