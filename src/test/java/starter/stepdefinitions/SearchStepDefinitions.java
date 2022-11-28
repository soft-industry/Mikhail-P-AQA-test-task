package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import starter.apis.ErrorDetailDto;
import starter.apis.FruitDto;
import starter.endpoints.Endpoints;
import org.assertj.core.api.SoftAssertions;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SearchStepDefinitions {

    private final EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String baseURL = EnvironmentSpecificConfiguration.from(variables).getProperty("env.dev.baseUrl");
    public Response response;


    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String endpoint) {
        response = SerenityRest.given().get(baseURL + Endpoints.valueOfLabel(endpoint).getEndpoint());

    }

    @Then("he sees the results displayed for {string}")
    public void heSeesTheResultsDisplayedForApple(String fruit) {
        List<FruitDto> fruitResponse = Arrays.asList(response.getBody().as(FruitDto[].class));
        FruitDto wrongFruit = fruitResponse
                .stream()
                .filter(mango -> !mango.getTitle().toLowerCase(Locale.ROOT).contains(fruit))
                .findAny()
                .orElse(null);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response)
                .as("The response shouldn't be empty")
                .isNotNull();
        softly.assertThat(response.statusCode())
                .as(String.format("The response code should be 200 but was %s", response.statusCode()))
                .isEqualTo(200);
        softly.assertThat(wrongFruit)
                .as(String.format("The response should contains only \"%s\" fruit but has %s",
                        fruit,
                        wrongFruit)
                )
                .isNull();
        softly.assertAll();
    }

    @Then("he sees the results displayed for mango")
    public void heSeesTheResultsDisplayedForMango() {

        List<FruitDto> mangoResponse = Arrays.asList(response.getBody().as(FruitDto[].class));
        FruitDto wrongMango = mangoResponse
                .stream()
                .filter(mango -> !mango.getTitle().toLowerCase(Locale.ROOT).contains("mango"))
                .findAny()
                .orElse(null);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(wrongMango).isNull();
        softly.assertAll();
    }

    @Then("he does not see the results")
    public void he_Doesn_Not_See_The_Results() {
        ErrorDetailDto error = response.as(ErrorDetailDto.class);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(error.getDetail().isError()).isEqualTo(true);
        softly.assertThat(error.getDetail().getRequestedItem()).isEqualTo("car");
        softly.assertThat(error.getDetail().getServedBy()).isEqualTo("https://waarkoop.com");
        softly.assertAll();
    }
}
