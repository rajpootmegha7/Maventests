package api_tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

public class Test1API {

    @Test
    public void jsonBlobGetTest() throws IOException {
    	
    	RestAssured.baseURI = "https://jsonblob.com"; 
    	// Get the RequestSpecification of the request to be sent to the server. 
    	RequestSpecification httpRequest = RestAssured.given(); 
    	// specify the method type (GET) and the parameters if any. 
    	//In this case the request does not take any parameters 
    	Response response = httpRequest.request(Method.GET, "");
    	// Print the status and message body of the response received from the server 
    	System.out.println("Status received => " + response.getStatusLine()); 
    	System.out.println("Response=>" + response.prettyPrint());
    	int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, 
        "Correct status code returned");
       }
    
    
}
