package model.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageRequest {
    private String swaggerUrl;
    private AuthorizationValue authorizationValue;
}
