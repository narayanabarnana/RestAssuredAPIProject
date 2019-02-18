package libraryAPIExampleTests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HandlingStaticJsonInputData {
	
	
	
	@Test
	public void AddBook() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		header("Content-Type","application/json").
		body(GenerateStringFromResource("C:\\Users\\1024812\\Desktop\\Rest API Software and Notes\\AddBookStaticPayload.json")).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js=ReusableMethod.rawToJson(res);
		String id=js.get("ID");
		System.out.println(id);
		
	}
	
	//convert the xml/json into string
		public static String GenerateStringFromResource(String path) throws IOException{
			
			return new String(Files.readAllBytes(Paths.get(path)));
		}

}
