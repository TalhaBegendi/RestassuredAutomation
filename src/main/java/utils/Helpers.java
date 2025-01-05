package utils;

import enums.HeadersEnum;
import lombok.experimental.UtilityClass;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import static client.RestAssuredClient.response;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.DataStoreMap.*;

@UtilityClass
public class Helpers {

    public void convertToUTF8(String getResponse, String setResponse) {
        try {
            String value = response.jsonPath().getString(getResponse);
            String encodedText = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
            setContext(setResponse, encodedText);
        } catch (Exception e) {
            System.err.println("Error during encoding to UTF-8: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertStatusCode(int statusCode, int expectedStatusCode) {
        assertThat(response.statusCode()).isEqualTo(expectedStatusCode);
    }

    public void assertNotNull(Object object, String message) {
        assertThat(object).as(message).isNotNull();
    }

    public Map<String, Object> setHeaders(HeadersEnum... headerTypes) {
        Map<String, Object> headers = new HashMap<>();
        for (HeadersEnum headerType : headerTypes) {
            headers.put(headerType.getKey(), headerType.getValue());
        }
        return headers;
    }
}
