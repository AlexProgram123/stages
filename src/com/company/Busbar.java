package com.company;
import java.util.ArrayList;

public class Busbar {
    private int position;
    private double currentFirstStage;
    private double currentSecondStage;
    private double shortCircuitCurrent;

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }


    public void setCurrentOne(double currentFirstStage) {
        this.currentFirstStage = currentFirstStage;
    }

    public double getCurrentOne() {
        return currentFirstStage;
    }

    public void setCurrentTwo(double currentSecondStage) {
        this.currentSecondStage = currentSecondStage;
    }

    public double getCurrentTwo() {
        return currentSecondStage;
    }

    public void setShortCircuitCurrent(double shortCircuitCurrent) {
        this.shortCircuitCurrent = shortCircuitCurrent;
    }

    public double getShortCircuitCurrent() {
        return shortCircuitCurrent;
    }

    public void ShowSteps() {
        System.out.println("Выключатель №:" + getPosition() + "  Ток отсечки первой ступени: " + getCurrentOne() + " Ампер" + "  Ток отсечки второй ступени: " + getCurrentTwo() + " Ампер");
    }
}
