package Steps;

import config.APIConstants;
import services.LanguageService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LanguageSteps {

    LanguageService languageService = new LanguageService(APIConstants.BASE_URL);

    @When("Post language after get field from response")
    public void postLanguage() {
        languageService.postLanguage();
    }

    @And("Convert language file to UTF-8 using get response {string} and set response {string}")
    public void convertToFile(String getResponse, String setResponse) {
        languageService.convertToFile(getResponse, setResponse);
    }

    @And("Get language file download before variable set response {string}")
    public void getLanguageFileDownload(String usingSetResponse) {
        languageService.getLanguageFileDownload(usingSetResponse);
    }
}
