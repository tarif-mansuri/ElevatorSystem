package model;

public class WeightSensor {
    private float weightLimit;
    private float currentWeight;

    public WeightSensor(float weightLimit) {
        this.weightLimit = weightLimit;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }
    public boolean isOverLoaded(){
        return currentWeight > weightLimit;
    }
}
