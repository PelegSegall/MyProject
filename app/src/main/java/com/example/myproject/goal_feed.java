package com.example.myproject;

import java.io.Serializable;

public class goal_feed implements Serializable {
    private String description;
    private int current, max;

    public goal_feed(String description, int current, int max) {
        this.description = description;
        this.current = current;
        this.max = max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "goal_feed{" +
                "description='" + description + '\'' +
                ", current=" + current +
                ", max=" + max +
                '}';
    }
}
