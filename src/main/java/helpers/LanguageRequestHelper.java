package helpers;

import enums.AuthorizationEnum;
import model.request.AuthorizationValue;
import model.request.LanguageRequest;

public class LanguageRequestHelper {

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



