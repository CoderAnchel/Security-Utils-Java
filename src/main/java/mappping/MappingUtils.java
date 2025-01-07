package mappping;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> convertObjectToMap(Object object) {
        return objectMapper.convertValue(object, Map.class);
    }
}
