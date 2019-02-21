package basicsOfGoogleRestAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;;

public class XMLPostMessage {

	//public static void main(String[] args) {
	@Test
	public void Test() throws IOException{
		
		String postData=GenerateStringFromResource("xml path of the body");
		RestAssured.baseURI="https://maps.googleapis.com";
		
		Response res=given().
				queryParam("key", "AIzaSyCWg2j-SAAUKIy8rTVK_dPlw7z14kRL7Io").
				body(postData).	
		when().
		post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().contentType(ContentType.XML).and().
		extract().response();
		
		//convert the raw data into string
		String respon=res.asString();
		System.out.println(respon);
		
		//convert the response into xml format
		XmlPath x=new XmlPath(respon);
		//System.out.println(x.get("PlaceResponse.place_id"));
		
	}
	
	//convert the xml/json into string
	public static String GenerateStringFromResource(String path) throws IOException{
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
