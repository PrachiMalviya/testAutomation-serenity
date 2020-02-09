package steps;
import UI.pageObjects.herokuapp;
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

    @Given("perform basic auth using (.*) and (.*)")
    public void basicAuth(String userName, String password)
    {
        try {
            herokuapp obj = new herokuapp();
            obj.login();
        }
        catch(Exception e)
        {out.println(e);}
    }
}
