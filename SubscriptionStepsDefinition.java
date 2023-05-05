package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SubscriptionStepsDefinition {
    WebDriver driver;
    HomePage homePage;

    public SubscriptionStepsDefinition() {
        this.driver = Hooks.driver;
        this.homePage = new HomePage(driver);
    }

    @Given("^Home screen should be showed$")
    public void home_screen_should_be_showed() {
        this.homePage.Open();

    }

    @When("^The user input email \"([^\"]*)\"$")
    public void the_user_input_email_something(String email) throws InterruptedException {
        this.homePage.scrollDownToElement(this.homePage.txtEmail);
        this.homePage.txtEmail.sendKeys(email);
        this.homePage.btnSubscription.click();

    }

    @Then("^The message \"([^\"]*)\" will be showed$")
    public void the_message_something_will_be_showed(String strArg1) {
        assertThat(this.homePage.getErrorMessageWhenInputInvalidEmail(), equalTo(strArg1));
    }
    @And("^the email field have color border is red$")
    public void the_email_field_have_color_border_is_red(){
        assertThat(this.homePage.checkBorderColorEmailField(), equalTo("rgba(255, 0, 0, 1)"));

    }


    @Then("^The alert \"([^\"]*)\" will be showed$")
    public void the_alert_something_will_be_showed(String errorMsg) throws InterruptedException {
        // String[] result = errorMsg.split("Đồng ý");

        assertThat(this.homePage.getErrorMessageWhenInputExistEmail().replaceAll("\nĐỒNG Ý", ""), equalTo(errorMsg));
    }

    @Then("^The popup \"([^\"]*)\" will be showed$")
    public void the_popup_something_will_be_showed(String contentPopup) {
        assertThat(this.homePage.getContentPopupAfterInputValidEmail(), equalTo(contentPopup));

    }

    @And("^the gender dropbox show the default value is \"([^\"]*)\"$")
    public void the_gender_dropbox_show_the_default_value_is_something(String strArg1) {
        assertThat(this.homePage.defaultGender.getText(), equalTo(strArg1));
    }

    @And("^the news dropbox  show the default value is \"([^\"]*)\"$")
    public void the_news_dropbox_show_the_default_value_is_something(String strArg1) {
        assertThat(this.homePage.defaultNews.getText(), equalTo(strArg1));
    }

    @And("^the name textbox is required$")
    public void the_name_textbox_is_required() {
        assertThat(this.homePage.checkNameFieldIsRequired(), equalTo(true));

    }

    @Then("^The error message \"([^\"]*)\" will be showed$")
    public void the_error_message_something_will_be_showed(String strArg1) {
        assertThat(this.homePage.getErrorMessageWhenEmptyName(), equalTo(strArg1));
    }

    @And("^The user attempt to subscribe with no data at the name textbox$")
    public void the_user_attempt_to_subscribe_with_no_data_at_the_name_textbox() {
        this.homePage.txbname.clear();
        this.homePage.btnAgree.click();
    }

    @And("^user will see the name field have color border is red and background color is yellow$")
    public void user_will_see_the_name_field_have_color_border_is_red_and_background_color_is_yellow() {
        assertThat(this.homePage.checkBorderColorNameField(), equalTo("rgba(209, 183, 183, 1)"));
        assertThat(this.homePage.checkBackgroundColorNameField(), equalTo("rgba(255, 255, 0, 1)"));
    }

    @And("^User press on Escape on the popup$")
    public void user_press_on_escape_on_the_popup() {
        this.homePage.Exit();
    }

    @Then("^The Information form should be hidden$")
    public void the_information_form_should_be_hidden() {
        assertThat(this.homePage.checkInformationFormExist(), equalTo(false));
    }

    @Then("^the user will see the success popup \"([^\"]*)\"$")
    public void the_user_will_see_the_success_popup_something(String strArg1) {
        assertThat(this.homePage.getContentPopupSuccess(), equalTo(strArg1));
    }

    @And("^The user fills in the information with full name \"([^\"]*)\", gender is \"([^\"]*)\" and news is \"([^\"]*)\"$")
    public void the_user_fills_in_the_information_with_full_name_something_gender_is_something_and_news_is_something(String name, String optionGender, String optionNews) throws InterruptedException {
        this.homePage.txbname.clear();
        this.homePage.txbname.sendKeys(name);
        this.homePage.dpxGender.click();
        this.homePage.selectOptionGender(optionGender);
        this.homePage.dpxNews.click();
        this.homePage.selectOptionNews(optionNews);
        this.homePage.btnAgree.click();


    }

}
