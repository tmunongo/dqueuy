package dev.webbe.task;

import java.util.Map;

public class Task {
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
        return "";
    }
}