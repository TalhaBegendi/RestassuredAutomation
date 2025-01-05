package client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient {

    private final String apiBaseUrl;
    private RequestSpecification requestSpecification;

    public RestAssuredClient(String apiBaseUrl) {this.apiBaseUrl = apiBaseUrl;}

    public Response postRequest(String path, Map<String, Object> headers, Object body) {
        setRequestSpecification(headers, body);
        return requestSpecification.post(path);
    }

    public Response getRequest(String path, Map<String, Object> headers) {
        setRequestSpecification(headers, null);
        return requestSpecification.get(path);
    }

    public void setRequestSpecification(Map<String, Object> headers, Object body) {
        requestSpecification = given().baseUri(apiBaseUrl).filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        if (headers != null) {
            requestSpecification.headers(headers);
        }
        if (body != null) {
            requestSpecification.body(body);
        }
    }
}
