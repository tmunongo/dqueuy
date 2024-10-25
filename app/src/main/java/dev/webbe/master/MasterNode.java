package dev.webbe.master;

import dev.webbe.worker.Worker;
import dev.webbe.worker.WorkerNode;
import lombok.Getter;

import java.util.ArrayList;

public class MasterNode {
    private String connectString;
    @Getter
    private ArrayList<WorkerNode> workers;

    public MasterNode(String connectString) {
        this.connectString = connectString;
    }

    public void addWorker(WorkerNode worker) {
        this.workers.add(worker);
    }

    public void removeWorker(WorkerNode worker) {
        this.workers.remove(worker);
    }
}
