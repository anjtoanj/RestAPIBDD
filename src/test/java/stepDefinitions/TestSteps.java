package stepDefinitions;

import java.util.Map;

import org.hamcrest.Matchers;

import groovyjarjarantlr4.v4.runtime.misc.FlexibleHashMap.Entry;
import hooks.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSteps {
	
	RequestSpecification request = null;
	Response response = null;
	
	@Given("set the endpoint")
	public void setTheEndPoint() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table/incident";		
	}	
	
	@Given("set the endpoint for change_request")
	public void setTheEndPointForChangeRequest() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table/change_request";		
	}
	
	@And("add the auth")
	public void addTheAuth() {
		RestAssured.authentication=RestAssured.basic("admin","vb-Ou7h^3AVM");		
	}
	
	@And("add the query parameters as {string} and {string}")
	public void addtheQueryParameters(String key, String value){
		request = RestAssured.given().log().all();
		request.queryParam(key, value).contentType(ContentType.JSON);
		
	}
	@When("post the request with short description as {string} and category as {string}")
	public void postRequestwithShorDescriptionAndCategory(String short_desc, String category){
		response= request.body("{\r\n"
				+ "    \"short_description\": \""+short_desc+"\",\r\n"
				+ "    \"description\": \""+category+"\"\r\n"
				+ "}").post();		
	}
	@And("add the query parameters")
	public void addTheQueryParameters(DataTable dataTable){
		request = RestAssured.given().log().all();
		Map<String,String> mapValue = dataTable.asMap();
        request.queryParams(mapValue).contentType(ContentType.JSON);		
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
	@Then("validate the response as {int}")
	public void ValidateResponseAsInt(int statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);		
	}
	@Then("validate the response for below")
	public void validateTheResponseForGivenSet(Map<String,String>responseFields){
		
		for(java.util.Map.Entry<String, String> eachEntry : responseFields.entrySet()){
	       response.then().body(eachEntry.getKey(),Matchers.equalTo(eachEntry.getValue()));
		}
		
	}
	@Given("change in {string} table")
	public void callTheTable(String change_request) {
		BaseTest baseTst = new BaseTest();
	
	}

}
