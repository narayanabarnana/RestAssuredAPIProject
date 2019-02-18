package jiraAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdatingCommentToJiraIssue {
	
	@Test
	public void updatingComment() {
		
		
		RestAssured.baseURI="http://localhost:9090";
		Response res=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethod.getJiraSessionID()).
		body("{\r\n" + 
				"    \"body\": \"I have updated the comment using Rest API Automation\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").
		when().
		put("rest/api/2/issue/10003/comment/10001").
		then().statusCode(200).
		extract().response();
		
		JsonPath js=ReusableMethod.rawToJson(res);
		String commentid=js.get("id");
		System.out.println(commentid);
		
		
		
	}

}
