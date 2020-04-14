package com.example.helthmonitor;

public class LifeClass {
    private float weight;
    private int steps;

    public LifeClass(float weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public float getWeight() {
        return weight;
    }

    public int getSteps() {
        return steps;
    }
}