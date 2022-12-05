package com.example.azmart_android.data.model;

public class PerformanceModel {
    private String type;
    private long timeTookToProcess;

    public PerformanceModel(String type, long timeTookToProcess) {
        this.type = type;
        this.timeTookToProcess = timeTookToProcess;
    }

    @Override
    public String toString() {
        return "PerformanceModel{" +
                "type='" + type + '\'' +
                ", timeTookToProcess=" + timeTookToProcess +
                '}';
    }

    public String getType() {
        return type;
    }

    public long getTimeTookToProcess() {
        return timeTookToProcess;
    }
}
