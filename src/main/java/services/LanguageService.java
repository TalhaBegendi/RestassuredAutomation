package services;

import client.RestAssuredClient;
import config.APIConstants;
import enums.HeadersEnum;
import model.response.LanguageResponse;
import java.util.Map;
import static helpers.LanguageRequestHelper.createLanguageRequest;
import static utils.Helpers.*;
import static utils.Helpers.assertNotNull;

public class LanguageService extends RestAssuredClient {

    LanguageResponse languageResponse;

    public LanguageService(String baseUrl) {
        super(baseUrl);
    }

    public void postLanguage() {
        Map<String, Object> header = setHeaders(HeadersEnum.CONTENT_TYPE);
        response = postRequest(APIConstants.Endpoint.POST_LANGUAGE_CLIENTS_ENDPOINT,header,createLanguageRequest());
        languageResponse = response.as(LanguageResponse.class);
        assertStatusCode(response.getStatusCode(), 200);
        assertNotNull(languageResponse.getLink(), "Link is null");
        assertNotNull(languageResponse.getCode(), "Code is null");
    }

    public void convertToFile(String getResponse,String setResponse) {
        convertToUTF8(getResponse,setResponse);
        assertNotNull(dataStoreMap.getContext(setResponse), "UTF-8 conversion failed");
    }

    public void getLanguageFileDownload(String usingSetResponse) {
        Object fileValue=  dataStoreMap.getContext(""+usingSetResponse+"");
        Map<String, Object> header = setHeaders(HeadersEnum.ACCEPT);
        response = getRequest(APIConstants.Endpoint.GET_LANGUAGE_DOWNLOAD_ENDPOINT + fileValue,header);
        assertStatusCode(response.getStatusCode(), 200);
    }
}

