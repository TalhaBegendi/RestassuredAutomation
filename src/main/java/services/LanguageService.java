package services;

import client.RestAssuredClient;
import config.APIConstants;
import enums.HeadersEnum;
import io.restassured.response.Response;
import model.response.LanguageResponse;
import java.util.Map;
import static helpers.LanguageRequestHelper.createLanguageRequest;
import static utils.DataStoreMap.*;
import static utils.Helpers.*;

public class LanguageService extends RestAssuredClient {

    LanguageResponse languageResponse;
    private Response response;

    public LanguageService(String baseUrl) {
        super(baseUrl);
    }

    public void postLanguage() {
        Map<String, Object> header = setHeaders(HeadersEnum.CONTENT_TYPE);
        response = postRequest(APIConstants.Endpoint.POST_LANGUAGE_CLIENTS_ENDPOINT,header,createLanguageRequest());
        languageResponse = response.as(LanguageResponse.class);
        assertStatusCode(response, 200);
        assertNotNull(languageResponse.getLink(), "Link is null");
        assertNotNull(languageResponse.getCode(), "Code is null");
    }

    public void convertToFile(String getResponse,String setResponse) {
        convertToUTF8(response,getResponse,setResponse);
        assertNotNull(getContext(setResponse), "UTF-8 conversion failed");
    }

    public void getLanguageFileDownload(String usingSetResponse) {
        Object fileValue=  getContext(""+usingSetResponse+"");
        Map<String, Object> header = setHeaders(HeadersEnum.ACCEPT);
        Response response = getRequest(APIConstants.Endpoint.GET_LANGUAGE_DOWNLOAD_ENDPOINT + fileValue,header);
        assertStatusCode(response, 200);
    }
}