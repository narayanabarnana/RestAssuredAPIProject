package jiraAPI;

import org.testng.annotations.Test;

import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateGroup {
	
	
	@Test
	public void createGroup()
	{
		
		RestAssured.baseURI="http://localhost:9090";
		Response res=given().
		header("Content-type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethod.getJiraSessionID()).
		body("{\r\n" + 
				"    \"name\": \"jira-administrators through Rest API\",\r\n" + 
				"    \"self\": \"http://localhost:9090/jira/rest/api/2/group?groupname=jira-administrators\",\r\n" + 
				"    \"users\": {\r\n" + 
				"        \"size\": 1,\r\n" + 
				"        \"items\": [\r\n" + 
				"            {\r\n" + 
				"                \"self\": \"http://www.example.com/jira/rest/api/2/user?username=fred\",\r\n" + 
				"                \"name\": \"fred\",\r\n" + 
				"                \"displayName\": \"Fred F. User\",\r\n" + 
				"                \"active\": false\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"max-results\": 50,\r\n" + 
				"        \"start-index\": 0,\r\n" + 
				"        \"end-index\": 0\r\n" + 
				"    },\r\n" + 
				"    \"expand\": \"users\"\r\n" + 
				"}").
			when().
			post("/rest/api/2/group").
			then().statusCode(201).
			extract().response();
		
		System.out.println(res);
		
	}

}
