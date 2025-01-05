package utils;

import lombok.experimental.UtilityClass;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class DataStoreMap {
    private final Map<String, String> contextMap = new HashMap<>();

    public void setContext(String key, String value) {
        contextMap.put(key, value);
    }

    public String getContext(String key) {
        return contextMap.get(key);
    }
}