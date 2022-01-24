package restassuredtestcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class PostRequest {

	
	@Test
	
	public void testPostCreateUser() {
		baseURI = "https://reqres.in/api";
		
		JSONObject reqData = new JSONObject();
		
		reqData.put("name","John");
		reqData.put("job","Teacher");
		
		System.out.println(reqData.toJSONString());
		
		given()
//		.header("content-type" , "application/json")
		.header("Connection", "Keep-alive")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		      .body(reqData.toJSONString())
		.when()
		      .post("/users")
		.then()
		    .statusCode(201)
		    .log().all();
		
	}
	
	@Test
	public void testPostRequest() {
	baseURI = "https://reqres.in/api";



	JSONObject json = new JSONObject();
	json.put("email", "eve.holt@reqres.in");
	json.put("password", "pistol");

	System.out.println(json.toJSONString());


	given()
	.body(json.toJSONString())

	.header("Connection", "Keep-alive")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)

	.when()
	.post("/register")
	.then()
	.statusCode(200)
	.log().ifStatusCodeIsEqualTo(200)
	.log().all();
	}




@Test

public void testPostRegisterUnsuccessful() {
	baseURI = "https://reqres.in/api";

System.out.println("==================Post register unsucessful");	
	
	JSONObject reqData = new JSONObject();
	
	reqData.put("email","sydney@fife");
	
	
	System.out.println(reqData.toJSONString());
	
	given()
//	.header("content-type" , "application/json")
	.header("Connection", "Keep-alive")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	      .body(reqData.toJSONString())
	.when()
	      .post("/register")
	.then()
	    .statusCode(400)
	    .log().ifStatusCodeIsEqualTo(200)
		.log().ifValidationFails(LogDetail.STATUS)
	    .log().everything();
	
}



@Test

public void testPostloginUnSuccessful() {
	baseURI = "https://reqres.in";
	
	JSONObject reqData = new JSONObject();
	
	reqData.put("email","peter@klaven");
	
	
	System.out.println(reqData.toJSONString());
	
	given()
	      .body(reqData.toJSONString())
	.when()
	      .post("/api/login")
	.then()
	    .statusCode(400)
	    .log().ifStatusCodeIsEqualTo(400)
		.log().ifValidationFails(LogDetail.STATUS)
	    .log().everything();
	
}

















@Test(enabled =false)

public void testPostloginSuccessful() {
	baseURI = "https://reqres.in/api";
	
	System.out.println("login succesfull");
	
	JSONObject reqData = new JSONObject();
	
	reqData.put("email","abc@gmail.com");
	reqData.put("password","cityslicka");
	
	System.out.println( reqData.toJSONString());
	
	given()
	       .header("Connection", "Keep-alive")
	       .contentType(ContentType.JSON)
           .accept(ContentType.JSON)
	      .body( reqData.toJSONString())
	.when()
	      .post("/Login")
	.then()
	    .statusCode(200)
//	    .log().headers()
//	    .log().body()
	    .log().ifStatusCodeIsEqualTo(200)
		.log().ifValidationFails(LogDetail.STATUS)
	    .log().everything();
	
}

}
