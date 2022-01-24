package restassuredtestcases;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GetRequestCucumberStyle {
	
	@Test
	
	public void getUserList()
	{
		
		baseURI = "https://reqres.in/api";
		
		given()
		     .get("/users?page=2")
		.then()
		     .statusCode(200)
		     .log().all();
		
	}
	
	
	
@Test
	
	public void getValidateUserList()
	{
		
		baseURI = "https://reqres.in/api";
		
		given()
		     .get("/users?page=2")
		.then()
		     .statusCode(200)
		     .body("data[2].id",equalTo(9))
		     .body("data[0].first_name", equalTo("Michael"))
		     .body("data.first_name",hasItem("Michael"))
		     .body("data.first_name",hasItems("Michael","Byron"))
		     .log().headers()
		     .log().body()
		     .log().status()
		     .log().everything()
		     .log().ifStatusCodeIsEqualTo(203)
		     .log().ifValidationFails(LogDetail.STATUS)
		     .log().all();
		
	}

@Test

public void getValidateUserNotFound() {
	baseURI = "https://reqres.in/api";
	
	given()
	     .get("/users/23")
	.then()
	      .statusCode(404)
	      .log().ifStatusCodeIsEqualTo(404)
		  .log().ifValidationFails(LogDetail.STATUS)
	      .log().all();	
	
}

@Test

public void getValidateListResource() {
	baseURI = "https://reqres.in/api";
	
	given()
	     .get("/unknown")
	.then()
	      .statusCode(200)
	      .log().ifStatusCodeIsEqualTo(200)
		  .log().ifValidationFails(LogDetail.STATUS)
	      .log().all();	
}

@Test

public void getValidateSingleResource() {
	baseURI = "https://reqres.in/api";
	
	given()
	     .get("/unknown/2")
	.then()
	      .statusCode(200)
	      .log().ifStatusCodeIsEqualTo(200)
	      .log().everything();
}
@Test

public void getValidateSingleResourceUserNotFound() {
	baseURI = "https://reqres.in/api";
	
	given()
	     .get("/unknown/23")
	.then()
	      .statusCode(404)
	      .log().ifStatusCodeIsEqualTo(404)
	      .log().all();	
}

}
