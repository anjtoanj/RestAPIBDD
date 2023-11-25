package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSteps {
	RequestSpecification request = null;
	Response response = null;
	@Given("set the endpoint")
	public void setTheEndPoint() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table/incident";
		
	}
	@And("add the auth")
	public void addTheAuth() {
		RestAssured.authentication=RestAssured.basic("admin","vb-Ou7h^3AVM");
		
	}
	@When("send the request")
	public void sendTheRequest() {
		request = RestAssured.given().log().all();
		response = request.get();
		
	}
	@Then("validate the response")	
	public void validateTheResponse() {
		response.then().log().all().assertThat().statusCode(200);
	}	

}
