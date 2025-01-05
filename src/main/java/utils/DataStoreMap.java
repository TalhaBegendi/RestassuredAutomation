package utils;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class DataStoreMap {

    private static Map<String, Object> dataStoreMap;
    public DataStoreMap() {dataStoreMap = new HashMap<>();}

    public void setContext(String key, Object value) {
        dataStoreMap.put(key, value);
    }

    public Object getContext(String key) {
        return dataStoreMap.get(key);
    }

}
