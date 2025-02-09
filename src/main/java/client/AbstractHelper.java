package client;

import enums.HeadersEnum;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public abstract class AbstractHelper {

    protected HttpClient httpclient;

    public Map<String, Object> setHeaders(HeadersEnum... headerTypes) {
        Map<String, Object> headers = new HashMap<>();
        for (HeadersEnum headerType : headerTypes) {
            headers.put(headerType.getKey(), headerType.getValue());
        }
        return headers;
    }

    public <T> T getResponseAs(Response response, Class<T> responseType) {
        return response.as(responseType);
    }
}
