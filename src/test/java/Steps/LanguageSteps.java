package Steps;

import client.HttpClientImp;
import config.APIConstants;
import helper.LanguageHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import model.response.LanguageResponse;
import static utils.Helpers.assertNotNull;


public class LanguageSteps {

    LanguageHelper languageHelper = new LanguageHelper(new HttpClientImp(APIConstants.BASE_URL));

    @When("Post language after get field from response")
    public void postLanguage() {
        LanguageResponse languageResponse = languageHelper.postLanguage();
        assertNotNull(languageResponse.getLink(), "Link is null");
        assertNotNull(languageResponse.getCode(), "Code is null");
    }

    @And("Convert language file to UTF-8 using get response {string} and set response {string}")
    public void convertToFile(String getResponse, String setResponse) {
        languageHelper.convertToFile(getResponse, setResponse);
    }

    @And("Get language file download before variable set response {string}")
    public void getLanguageFileDownload(String usingSetResponse) {
        languageHelper.getLanguageFileDownload(usingSetResponse);
    }
}
