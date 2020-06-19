import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.*;

public class basicsPost {

	

	@Test
	public void Test(){


		RestAssured.baseURI="https://c1b358d3-486c-4f91-922d-d70aa33c17e7.mock.pstmn.io";

		String postRequestBody=payload.aadMortgage();
		given().log().all().queryParam("Mortgage","M000001").header("Content-Type","application/json").body(postRequestBody).when().post("/v1/home/post").
		then().log().all().
		assertThat().
		statusCode(200).
		and().
		body("details.loanDetails.mortgageNumber",equalTo("M000001"));
	}
}
