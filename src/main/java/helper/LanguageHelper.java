package helper;

import client.AbstractHelper;
import client.HttpClient;
import config.APIConstants;
import enums.HeadersEnum;
import io.restassured.response.Response;
import model.request.LanguageRequest;
import model.response.LanguageResponse;
import java.util.Map;

import static model.request.LanguageRequest.createLanguageRequest;
import static utils.DataStoreMap.*;
import static utils.Helpers.*;

public class LanguageHelper extends AbstractHelper {

    private Response response;

    public LanguageHelper(HttpClient httpclient) {super(httpclient);}

    public LanguageResponse postLanguage() {
        Map<String, Object> header = setHeaders(HeadersEnum.CONTENT_TYPE);
        LanguageRequest languageRequest = createLanguageRequest();
        response = httpclient.post(APIConstants.Endpoint.POST_LANGUAGE_CLIENTS_ENDPOINT,header,languageRequest);
        assertStatusCode(response, 200);
        return getResponseAs(response,LanguageResponse.class);
    }

    public void convertToFile(String getResponse,String setResponse) {
        convertToUTF8(response,getResponse,setResponse);
        assertNotNull(getContext(setResponse), "UTF-8 conversion failed");
    }

    public void getLanguageFileDownload(String usingSetResponse) {
        Object fileValue=  getContext(usingSetResponse);
        Map<String, Object> header = setHeaders(HeadersEnum.ACCEPT);
        Response response = httpclient.get( APIConstants.Endpoint.GET_LANGUAGE_DOWNLOAD_ENDPOINT + fileValue,header);
        assertStatusCode(response, 200);
    }
}