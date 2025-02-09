package model.request;
import enums.AuthorizationEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageRequest {
    private String swaggerUrl;
    private AuthorizationValue authorizationValue;

    public static LanguageRequest createLanguageRequest() {
        return LanguageRequest.builder()
                .swaggerUrl("http://petstore.swagger.io/v2/swagger.json")
                .authorizationValue(AuthorizationValue.builder()
                        .value(AuthorizationEnum.VALUE.getAuthorization())
                        .keyName(AuthorizationEnum.KEY_NAME.getAuthorization())
                        .type(AuthorizationEnum.TYPE.getAuthorization())
                        .build())
                .build();
    }
}
