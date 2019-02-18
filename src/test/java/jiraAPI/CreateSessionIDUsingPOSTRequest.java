package jiraAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateSessionIDUsingPOSTRequest {
	
	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\1024812\\Desktop\\Selenium\\RestAPIJavaProject\\src\\files\\env.properties");
		prop.load(fis);
		
		//prop.get("HOST");
	}
	
	
	
	@Test
	public void createSessionID() {
		
		
		//Creating a session to authenticate
		RestAssured.baseURI=prop.getProperty("JiraHost");
		Response resp=given().
		header("Content-Type", "application/json").
		body("{ \"username\": \"narayana.10209\", \"password\": \"Automation@009\" }").
		when().
		post("/rest/auth/1/session").
		then().statusCode(200).
		extract().response();
		
		JsonPath js=ReusableMethod.rawToJson(resp);
		String sessionid=js.get("session.value");
		System.out.println(sessionid);
		
		//Create an issue
		
	}
	
	

}
