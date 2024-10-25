package dev.webbe.worker;

public class WorkerNode {
    private String workerName;
    private String connectionString;

    public WorkerNode (String workerName, String connectionString) {
        this.workerName = workerName;
        this.connectionString = connectionString;
    }

    public void register() {
        // link to the master node

    }

    public void unregister() {
        // unlink from master node
    }
}
