package dev.webbe.task;

import java.util.Map;
import lombok.Data;

@Data public class Task {
    String id;
    String type;
    int port;
    Map<String, Object> parameters;
    TaskStatus status;

    public Task(String id, String type, Map<String, Object> params) {
        this.id = id;
        this.type = type;
        this.parameters = params;
    }

    void execute() {

    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    public String toJson() {
        throw new UnsupportedOperationException("Unimplemented method 'toJson'");
    }

    public static Task fromJson(String jsonString) {
        throw new UnsupportedOperationException("Unimplemented method 'fromJson'");
    }

    public int getResult() {
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }
}