package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchUsers {
	
	public static String baseurl = "https://jsonplaceholder.typicode.com/";
	public List<Integer> postId = new ArrayList<Integer>();
	public List<String> emailComments = new ArrayList<String>();
	public static Response response;
	public static String jsonString;
	public static int userId ;	
					 
	public RequestSpecification request;
	
	@Given("Get API Response {string}")
	public void searchUserResponse(String strValue) {	
		RestAssured.baseURI = baseurl;
		request = RestAssured.given();
		
		response = request.get(strValue);
				
		jsonString = response.asString();
		//System.out.println(jsonString);						
	}

	@When("Search samantha user and get user id for the response")
	public void getUserId() {
	    List<String> listUsers = response.jsonPath().getList("username");
	    List<Integer> listid = response.jsonPath().getList("id");
	    
	    System.out.println(listid);	        
	    
	    for(int i=0; i<listUsers.size();i++) {
	    	if(listUsers.get(i).equals("Samantha")) {	    			
	    		userId = listid.get(i);
	    	}
	    }
	    System.out.println(userId);
	}

	@Then("Verify the status code")
	public void verifyStatuscode() {
		Assert.assertEquals(200, response.statusCode());
	}
			
	@When("Get the user id and search in the Posts Response")
	public void verifygetuserPosts() {
		List<Integer> listUsers = response.jsonPath().getList("userId");
	    List<Integer> listid = response.jsonPath().getList("id");
	    
	    for(int i=0; i<listUsers.size();i++) {
	    	if(listUsers.get(i).equals(userId)) {
	    		postId.add(listid.get(i));
	    	}
	    }
	    
	    System.out.println(postId);
	}
		
	@When("Get the post id and search in the comments Response")
	public void verifygetUserComments() {
		List<Integer> listUsers = response.jsonPath().getList("postId");
	    List<String> listid = response.jsonPath().getList("email");
	    
	    for(int k=0;k<postId.size();k++) {
		    for(int i=0; i<listUsers.size();i++) {
		    	if(listUsers.get(i).equals(postId.get(k))) {
		    		emailComments.add(listid.get(i));		    		
		    	}
		    }
	    }
	    	    
	}

	@Then("Verify the status code and email format in comments section")
	public void verifyCommentsEmail() {
		String strEmail = "";
		try {
			Assert.assertEquals(200, response.statusCode());
									
			for(int i=0;i< emailComments.size();i++) {
				strEmail = emailComments.get(i);
				System.out.println(strEmail);
				
				String[] arrEmail = strEmail.split("@");
							
				if(arrEmail.length > 0) {
					Assert.assertTrue("@ is available in the email", true);
					
					if(arrEmail[0].length() > 0) {
						Assert.assertTrue("User id is available in the email:- " + arrEmail[0], true);
					}else {
						Assert.fail("User id is not available the email:-" + arrEmail[0]);
					}
															
					String[] emailDomain = arrEmail[1].split(Pattern.quote("."));
													
					if(emailDomain[0].length() > 0) {
						Assert.assertTrue("Domain is available in the email:-" + emailDomain[0], true);
					}else {
						Assert.fail("Domain is not available the email:-" + emailDomain[0]);
					}
					
					if(emailDomain[1].length() > 0) {
						Assert.assertTrue("After dot text is available in the email:-" + emailDomain[1], true);
					}else {
						Assert.fail("After dot text is not available the email:-" + emailDomain[1]);
					}				
					
				}else {
					Assert.fail(strEmail + " - @ is not available in the email");
				}
			}
		}catch(Exception e) {
			Assert.fail("Email id is not in proper format:-" + strEmail);
		}		
	}
}
