package hackathon.doit.steps;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DoitStepDefs {

	int status;

	@When("^I get \"([^\"]*)\"$")
	public void I_get(String path) throws Throwable {
		status = DoitRestUtil.getStatus(path);
	}

	@Then("^the status should be (\\d+)$")
	public void the_status_should_be(int status) throws Throwable {
		assertThat(status, is(status));
	}

}