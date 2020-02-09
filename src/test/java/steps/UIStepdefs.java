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
public class UIStepdefs {
    String urlString;

    @Given("I goto URL (.*)")
    public void setUrlString(String URL)
    {
        try {
            urlString = URL;
        }
        catch(Exception e)
        {out.println(e);}
    }
}
