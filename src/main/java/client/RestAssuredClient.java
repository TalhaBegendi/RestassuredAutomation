package client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import utils.DataStoreMap;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient {

    public String apiBaseUrl;
    private RequestSpecification requestSpecification;
    public static Response response;
    public static DataStoreMap dataStoreMap = new DataStoreMap();

    public RestAssuredClient(String apiBaseUrl) {this.apiBaseUrl = apiBaseUrl;}

    public Response postRequest(String path, Map<String, Object> headers, Object body) {
        setRequestSpecification(headers, body);
        requestSpecification.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response = requestSpecification.post(path);
        return response;
    }

    public Response getRequest(String path, Map<String, Object> headers) {
        setRequestSpecification(headers, null);
        requestSpecification.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        response = requestSpecification.get(path);
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    public void setRequestSpecification(Map<String, Object> headers, Object body) {
        requestSpecification = given().baseUri(apiBaseUrl);
        if (headers != null) {
            requestSpecification.headers(headers);
        }
        if (body != null) {
            requestSpecification.body(body);
        }
    }
}
