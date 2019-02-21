package jiraAPI;



import org.testng.annotations.Test;

import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateIssueInJira {
	
	
	@Test
	public void createIssue() {
		
		
		RestAssured.baseURI="http://localhost:9090";
		Response res=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethod.getJiraSessionID()).
		body("{\r\n" + 
				"    \r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \r\n" + 
				"            \"key\": \"RES\"\r\n" + 
				"        },\r\n" + 
				"        \r\n" + 
				"        \"summary\": \"Rest API Manual First Issue on 20/2/2019\",\r\n" + 
				"        \"description\": \"first defect creating using postman\",\r\n" + 
				"        \"issuetype\":{\r\n" + 
				"        	\"name\": \"Bug\"\r\n" + 
				"        	\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"}\r\n" + 
				"}").
		when().
		post("rest/api/2/issue").
		then().statusCode(201).
		extract().response();
		
		JsonPath js=ReusableMethod.rawToJson(res);
		String JiraID=js.get("id");
		System.out.println(JiraID);
		
		
	}
	
	

}
