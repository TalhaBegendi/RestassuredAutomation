package utils;

import enums.HeadersEnum;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import static client.RestAssuredClient.dataStoreMap;
import static client.RestAssuredClient.response;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Helpers  {

    public static void convertToUTF8(String getResponse, String setResponse) {
        try {
            String value = response.jsonPath().getString(getResponse);
            String encodedText = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
            dataStoreMap.setContext(setResponse, encodedText);
        } catch (Exception e) {
            System.err.println("Error during encoding to UTF-8: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void assertStatusCode(int statusCode, int expectedStatusCode) {
        assertThat(response.statusCode()).isEqualTo(expectedStatusCode);
    }

    public static void assertNotNull(Object object, String message) {
        assertThat(object).as(message).isNotNull();
    }

    public static  Map<String, Object> setHeaders(HeadersEnum... headerTypes) {
        Map<String, Object> headers = new HashMap<>();
        for (HeadersEnum headerType : headerTypes) {
            headers.put(headerType.getKey(), headerType.getValue());
        }
        return headers;
    }
}
