package twitterAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateTweet {
	
	@Test
	public void createTweet()
	{
		//THese are dummy keys
		String ConsumerKey="dfdgadgadggdg";
		String ConsumerSecret="dsfasdfasfafadg";
		String Token="dfadgadfgdfgadgdfgdfg";
		String TokenSecret="sdfasdfasdfasdffaf";
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response res=given().
		auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		queryParam("status", "I am tweeting from Rest API Automation using Java").
		when().
		post("/update.json").
		then().extract().response();
		
		
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
//		System.out.println(js.get("id"));
		
//		JsonPath js=ReusableMethod.rawToJson(res);
//		String latesttweet=js.get("text");
//		System.out.println(latesttweet);
		
		
	}

}
