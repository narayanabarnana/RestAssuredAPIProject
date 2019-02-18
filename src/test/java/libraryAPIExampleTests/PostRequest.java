package libraryAPIExampleTests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.Resources;
import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRequest {
	
	
	@Test
	public void AddBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		header("Content-Type","application/json").
		body("{\r\n\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\"bczddeerfdf\",\r\n\"aisle\":\"227\",\r\n\"author\":\"John foe\"\r\n}\r\n ").
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js=ReusableMethod.rawToJson(res);
		String id=js.get("ID");
		System.out.println(id);
		
	}
	
	

}
