package dev.webbe.task;

import java.util.Map;

import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;

@Data public class Task {
    String id;
    String type;
    int port;
    @Getter
    Map<String, Object> parameters;
    private TaskStatus status;

    public Task(String id, String type, Map<String, Object> params) {
        this.id = id;
        this.type = type;
        this.parameters = params;
        this.status = TaskStatus.PENDING;
    }

    void execute() {

    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Task fromJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Task.class);
    }

    public int getResult() {
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }
}