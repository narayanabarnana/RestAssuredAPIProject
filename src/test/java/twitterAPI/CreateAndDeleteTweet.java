package twitterAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateAndDeleteTweet {
	
	String ConsumerKey="1HxV3RV10qvboQ4hkGcdYoCkK";
	String ConsumerSecret="UvxP0uQS930tncArpncKw4YNSMIKDlrnxMF5GZvu36iVzHABhQ";
	String Token="421068780-kZgXQr3GImZoEUoUKZiKKXJajKXHxcKhZO77wlAP";
	String TokenSecret="xrSeD4EhBz5ubmLWKyzVb7t12CkpRQm3wVtKywkMFFcxz";
	String id;
	
	@Test
	public void createTweet()
	{
		
		
		
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
		id=js.get("id").toString();
		System.out.println("Created Tweet ID is " + id);
		
//		JsonPath js=ReusableMethod.rawToJson(res);
		String latesttweet=js.get("text").toString();
		System.out.println("Created Tweet Message is " +latesttweet);
		
		
	}
	
	@Test
	public void E2E() {
		
		
		createTweet();
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
