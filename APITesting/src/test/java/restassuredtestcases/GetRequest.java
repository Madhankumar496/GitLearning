package restassuredtestcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

	@Test
	
	void testGetUserList()
	{
		
	Response rsp = RestAssured.get("https://reqres.in/api/users?page=2");
	
	System.out.println(rsp.getStatusCode());
	Assert.assertEquals(rsp.getStatusCode(), 200);
	//response body
	System.out.println("response body is" +rsp.getBody().asString());
	System.out.println("response body is" +rsp.body().asString());
		
	///response time
	System.out.println("response time is" +rsp.getTime());
	
	//get header
	
	System.out.println("The content tyep headeris " + rsp.header("content-type"));
	System.out.println(rsp.getHeaders());
	}
	
@Test
	
	void testGetSingleUserList()
	{
		
	Response rsp = RestAssured.get("https://reqres.in/api/users/2");
	
	System.out.println(rsp.getStatusCode());
	Assert.assertEquals(rsp.getStatusCode(), 200);
	//response body
	System.out.println("response body is" +rsp.getBody().asString());
	System.out.println("response body is" +rsp.body().asString());
		
	///response time
	System.out.println("response time is" +rsp.getTime());
	
	//get header
	
	System.out.println("The content tyep headeris " + rsp.header("content-type"));
	System.out.println(rsp.getHeaders());
	}
	
	
	
	
}
