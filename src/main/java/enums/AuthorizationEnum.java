package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AuthorizationEnum {
    VALUE("yourAuthTokens"),
    KEY_NAME("Authorization"),
    TYPE("Bearer");

    private final String authorization;
}
