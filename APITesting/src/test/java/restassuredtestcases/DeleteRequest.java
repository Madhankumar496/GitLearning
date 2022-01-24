package restassuredtestcases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteRequest {
	
	
@Test
	
	public void testDeleteUser() {
		baseURI = "https://reqres.in/api";
		
		when()
		  .delete("/user/409")
		 .then()
		   .statusCode(204)
		   .log().all();
		  
		  
		
		
		
		
}

}
