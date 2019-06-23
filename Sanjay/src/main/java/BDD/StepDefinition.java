package BDD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends CustomListener{

	@Given("^Navigate to dashboard page of \"([^\"]*)\" site and user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void navigate_to_dashboard_page_of_site_and_user_enters_and(String arg1, String arg2, String arg3)
			throws Throwable {

		System.out.println("Given navigation");

	}

	@When("^user gives input data from sheet name \"([^\"]*)\" present at workbook location \"([^\"]*)\"$")
	public void user_gives_input_data_from_sheet_name_present_at_workbook_location(String sheet_Name,
			String workbook_Location) throws Throwable {
		System.out.println("Inpot Data");
	}

	@Then("^create new individual entity$")
	public void create_new_individual_entity() throws Throwable {
		System.out.println("Create new individual");
	}

}
