package client;

import io.restassured.response.Response;

import java.util.Map;

public interface HttpClient {
    Response post(String path, Map<String, Object> headers, Object body);

    Response get(String path, Map<String, Object> headers);

    Response put(String path, Map<String, Object> headers, Object body);

    Response delete(String path, Map<String, Object> headers);
}
