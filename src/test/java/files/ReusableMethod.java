package files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethod {
	
	public static XmlPath rawToXML(Response r)
	{
	
		
		String respon=r.asString();
		XmlPath x=new XmlPath(respon);
		return x;
		
	}

	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
	
	public static String getJiraSessionID() {
		
		
		RestAssured.baseURI="http://localhost:9090";
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
		
		return sessionid;
		
	}


}
