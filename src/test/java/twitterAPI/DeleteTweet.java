package twitterAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteTweet {
	
	
	//THese are dummy keys
	String ConsumerKey="dfdgadgadggdg";
	String ConsumerSecret="dsfasdfasfafadg";
	String Token="dfadgadfgdfgadgdfgdfg";
	String TokenSecret="sdfasdfasdfasdffaf";
	String id="1095904675121967105";
	
	@Test
	public void deleteTweet() {
		
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
			.when().post("/destroy/"+id+".json").then().extract().response();
		
		String response =res.asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		//System.out.println(js.get("text"));
		System.out.println("Tweet which got deleted with automation is below");
		System.out.println(js.get("text").toString());
		System.out.println(js.get("truncated").toString());
		
		
	}

}
