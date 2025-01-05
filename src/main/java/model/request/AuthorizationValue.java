package model.request;
import lombok.*;

@Data
@Builder
public class AuthorizationValue {
        private String value;
        private String keyName;
        private String type;
}
