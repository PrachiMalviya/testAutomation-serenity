package steps;
import io.restassured.response.ValidatableResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;

import static java.lang.System.out;

public class APIStepdefs {
    Response response;
    RequestSpecification request = RestAssured.given();
    ValidatableResponse json;
    String urlString;
    @Given("I set the URL (.*)")
    public void setUrlString(String URL)
    {
        try {
            urlString = URL;
        }
        catch(Exception e)
        {out.println(e);}
    }
    @When("I make a get call")
    public void getCall() {
        try {
            response = request.when().get(urlString);
            System.out.println("response: " + response.prettyPrint());
        }
        catch(Exception e)
        {out.println(e);}
    }
    @Then("the status code is (\\d+)")
    public void verifyStatusCode(int status)
    {
        try {
            json = response.then().statusCode(status);
        }
        catch(Exception e)
        {out.println(e);}
    }
    @And("response includes the following")
    public void responseContains(Map<String,String> responseFields)
    {
        try {
            for (Map.Entry<String, String> field : responseFields.entrySet()) {
                if (StringUtils.isNumeric(field.getValue())) {
                    json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
                } else {
                    json.body(field.getKey(), equalTo(field.getValue()));
                }
            }
        }
        catch(Exception e)
        {out.println(e);}
    }
}
