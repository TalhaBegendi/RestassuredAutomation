package client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpClientImp implements HttpClient {

    private RequestSpecification requestSpecification;
    private final String baseUrl;

    @Override
    public Response post(String path, Map<String, Object> headers, Object body) {
        setRequestSpecification(headers, body);
        return requestSpecification.post(path);
    }

    @Override
    public Response get(String path, Map<String, Object> headers) {
        setRequestSpecification(headers, null);
        return requestSpecification.get(path);
    }

    @Override
    public Response put(String path, Map<String, Object> headers, Object body) {
        setRequestSpecification(headers, body);
        return requestSpecification.post(path);
    }

    @Override
    public Response delete(String path, Map<String, Object> headers) {
        setRequestSpecification(headers, null);
        return requestSpecification.get(path);
    }

    public void setRequestSpecification(Map<String, Object> headers, Object body) {
        requestSpecification = given().baseUri(baseUrl).filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        if (headers != null) {
            requestSpecification.headers(headers);
        }
        if (body != null) {
            requestSpecification.body(body);
        }
    }
}
