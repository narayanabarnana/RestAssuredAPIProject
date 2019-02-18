package twitterAPI;

import org.testng.annotations.Test;

import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@SuppressWarnings("unused")
public class GetLatestTweet {
	
	
	@Test
	public void getLatestTweet()
	{
		
		String ConsumerKey="1HxV3RV10qvboQ4hkGcdYoCkK";
		String ConsumerSecret="UvxP0uQS930tncArpncKw4YNSMIKDlrnxMF5GZvu36iVzHABhQ";
		String Token="421068780-kZgXQr3GImZoEUoUKZiKKXJajKXHxcKhZO77wlAP";
		String TokenSecret="xrSeD4EhBz5ubmLWKyzVb7t12CkpRQm3wVtKywkMFFcxz";
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response res=given().
		auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		queryParam("count", "1").
		when().
		get("/home_timeline.json").
		then().extract().response();
		
		
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
//		System.out.println(js.get("text"));
		
//		JsonPath js=ReusableMethod.rawToJson(res);
//		String latesttweet=js.get("text");
//		System.out.println(latesttweet);
		
		
	}

}
