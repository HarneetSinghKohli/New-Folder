import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class basics {

	@Test
	public void test1(){
		
		RestAssured.baseURI="https://bef3e680-8429-4bd2-b390-3e9191c6fbe8.mock.pstmn.io/";
		
		given().param("Mortgage","M000001").when().get("v1/home").then().assertThat().statusCode(200).
		and().
		//assertThat().contentType(ContentType.JSON).  //ASSERTION ON HEADER
		assertThat().header("Content-Type","application/json").
		and().
		body("applicationGeneralDetails.branch",equalTo("HOF")).
		and().
		body("propertyDetails.propertyUsageDescription",equalTo("Wholly Owner/Depend. Occupied")).
		and().
		assertThat().header("Server","JBoss-EAP/7");
	}
}
