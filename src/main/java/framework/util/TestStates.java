package framework.util;

import java.util.HashMap;
import java.util.Map;

public class TestStates {
    private static ThreadLocal<Map<String, Object>> states = ThreadLocal.withInitial(HashMap::new);

    public static Map<String, Object> getTestData() {
        return states.get();
    }

}
