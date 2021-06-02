package definition;

import groovy.json.internal.LazyMap;

public class ProcessAPI {
    private static String API_URL = "http://agapito-server.herokuapp.com/processos/";
    private static LazyMap fieldsJson = new LazyMap();
    private static String ProcessId;
    private static String ProcessValue;

    public static String getEndpoint() {
        return API_URL;
    }

    public static void addFields(String field, String value) {
        fieldsJson.put(field, value);
    }

    public static void clearFields() {
        fieldsJson.clear();
    }

    public static LazyMap getFields() {
        return fieldsJson;
    }

    public static void storeProcessId(String processId) {
        ProcessId = processId;
    }

    public static String getProcessId() {
        return ProcessId;
    }

    public static void setProcessValue(String processValue) {
        ProcessValue = processValue;
    }

    public static String getProcessValue() {
        return ProcessValue;
    }
}
