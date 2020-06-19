package Jira;


//RestAssured
import static io.restassured.RestAssured.given;


import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.*;



//TestNG
import org.testng.annotations.Test;

//Classes
import files.jiraPayload;
import files.reUsable;



public class JiraTest {

	SessionFilter session=new SessionFilter();

	@Test(enabled=false)
	public void Test1(){
		RestAssured.baseURI="http://localhost:8081/";


		//login
		String loginResponse=given().header("Content-Type","application/json").body(jiraPayload.loginData()).log().all().
				filter(session).																										// This session will remember the response of the hit request and used before when()
				when().post("rest/auth/1/session").then().log().all().extract().response().asString();

		//Add comment
		String addCommentresponse=given().pathParam("issueId", "10301").body(jiraPayload.addComment()).header("Content-Type","application/json").log().all().
				filter(session).
				when().post("rest/api/2/issue/{issueId}/comment").then().log().all().extract().response().asString();
		
		System.out.println("Response is "+addCommentresponse);
	/*	
		//Delete Issue
		String deleteCommentResponse=given().pathParam("issueId", "10300").header("Content-type","application/json").log().all().
				filter(session).
				when().delete("rest/api/2/issue/{issueId}").then().log().all().extract().response().asString();
		System.out.println("Response of Delte request is :"+deleteCommentResponse);
	*/	
	}
	
	
	@Test(enabled=false)
	public void Test2(){
		RestAssured.baseURI="http://localhost:8081/";
		String loginResponse=given().header("Content-Type","application/json").body(jiraPayload.loginData()).log().all().
				filter(session).																										// This session will remember the response of the hit request and used before when()
				when().post("rest/auth/1/session").then().log().all().extract().response().asString();

		
		//Add Attachment
		
		File file=new File("C:\\D\\Workspace\\eclipse\\Fixture_53_new\\RestProject\\src\\files\\Jira.txt");
		String addAttachment=given().pathParam("issueId","10301").header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data").multiPart("File",file).
				log().all().
				filter(session).
				when().post("rest/api/2/issue/{issueId}/attachments").then().log().all().extract().response().asString();
		
	}
	
	@Test(enabled=true)
	public void Test3(){
		RestAssured.baseURI="http://localhost:8081/";
		String loginResponse=given().relaxedHTTPSValidation().header("Content-Type","application/json").body(jiraPayload.loginData()).log().all().
				filter(session).																										// This session will remember the response of the hit request and used before when()
				when().post("rest/auth/1/session").then().log().all().extract().response().asString();
		
		//Add comment
		String addCommentresponse=given().pathParam("issueId", "10301").body(jiraPayload.addComment()).header("Content-Type","application/json").log().all().
				filter(session).
				when().post("rest/api/2/issue/{issueId}/comment").then().log().all().extract().response().asString();
		
		String getCommentId=reUsable.rawToJsonResponseKeyValue(reUsable.rawToJsonResponse(addCommentresponse), "id");
		
		//GetIssueDetails
		//We are using path paramater to find the details of a particular issue and then used query parameter to drill down the result and find only the specific result
		String getIssueDetailsResponse=given().pathParam("issueId", "10301").queryParam("fields", "comment").header("Content-Type","application/json").log().all().
				filter(session).
				when().get("/rest/api/2/issue/{issueId}").then().log().all().extract().response().asString();
			reUsable.iterateOverArray(reUsable.rawToJsonResponse(getIssueDetailsResponse),"fields.comment.comments","body");	
				
		//DeleteIssue
		String deleteCommentResponse=given().pathParam("issueId", "10301").pathParam("id",getCommentId).filter(session).
				when().delete("/rest/api/2/issue/{issueId}/comment/{id}").
				then().log().all().extract().response().asString();
				
				
	}
	
/*	
	//Create Issue 
	String createIssueResponse=given().body(jiraPayload.createIssue()).header("Content-Type","application/json").log().all().
			filter(session).
			when().post("rest/api/2/issue").then().log().all().extract().response().asString();
	
*/

}
