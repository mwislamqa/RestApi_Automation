package Runner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Steps {
	
	Response response;
	@When("I send a POST request with valid username and password")
	public void sendLoginRequest() {
	    response = RestAssured.given()
	        .contentType("application/json")
	        .body("{\"username\":\"admin\",\"password\":\"1234\"}")
	        .when()
	        .post("/login");
	}

	@Then("the response status code should be 200")
	public void verifyStatusCode() {
	    response.then().statusCode(200);
	}

}
