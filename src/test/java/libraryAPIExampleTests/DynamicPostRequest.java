package libraryAPIExampleTests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.Resources;
import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DynamicPostRequest {
	
	
	@Test(dataProvider="AddMultipleBooks")
	public void AddBook(String isbn, String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		header("Content-Type","application/json").
		body(Payload.Addbook(isbn,aisle)).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js=ReusableMethod.rawToJson(res);
		String id=js.get("ID");
		System.out.println(id);
		
	}
	
	@DataProvider(name="AddMultipleBooks")
	public Object[][] getBooksData() {
		
		return new Object[][] {  {"qazwsx","0997"} , {"qazedc","0879"} , {"qazrfv","0654"}   };
		
	}

}
