package com.itstep.aliexpress;

import java.util.HashMap;

public class ScenarioContext {

    private static HashMap<String, Object> context = new HashMap<>();

    public static void setContext(String key, Object value) {
        context.put(key, value);
    }

    public static Object getContext(String key) {
        return context.get(key);
    }

    public static void clearContext() {
        context.clear();
    }

}