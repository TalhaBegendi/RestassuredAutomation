package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeadersEnum {
    ACCEPT("Accept", "application/octet-stream"),
    CONTENT_TYPE("Content-Type", "application/json"),
    AUTHORIZATION("Authorization", "Bearer token");

    private final String key;
    private final String value;
}
