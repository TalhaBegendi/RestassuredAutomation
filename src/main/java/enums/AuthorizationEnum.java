package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthorizationEnum {
    VALUE("yourAuthTokens"),
    KEY_NAME("Authorization"),
    TYPE("Bearer");

    private final String authorization;
}
