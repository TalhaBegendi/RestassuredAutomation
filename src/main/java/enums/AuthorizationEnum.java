package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthorizationEnum {
    VALUE("yourAuthTokens"),
    KEY_NAME("Authorization"),
    TYPE("Bearer");

    private final String authorization;
}
