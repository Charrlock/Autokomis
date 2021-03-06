package com.game.src.main.classes;

public class Car implements Mechanics{
    final String make;
    private double value;
    public double mileage;
    public String color;
    private boolean brakesWorking;
    private boolean suspensionWorking;
    private boolean engineWorking;
    private boolean bodyWorking;
    private boolean transmissionWorking;
    final boolean isDelivery;
    final String segment;


    public Car(String make, boolean brakesWorking, boolean suspensionWorking, boolean engineWorking, boolean bodyWorking, boolean transmissionWorking, boolean isDelivery, String segment) {
        this.make = make;
        this.brakesWorking = brakesWorking;
        this.suspensionWorking = suspensionWorking;
        this.engineWorking = engineWorking;
        this.bodyWorking = bodyWorking;
        this.transmissionWorking = transmissionWorking;
        this.isDelivery = isDelivery;
        this.segment = segment;
    }


    public void setBodyWorking(boolean bodyWorking) {
        this.bodyWorking = bodyWorking;
    }

    public boolean isEngineWorking() {
        return engineWorking;
    }

    public void setEngineWorking(boolean engineWorking) {
        this.engineWorking = engineWorking;
    }

    public boolean isSuspensionWorking() {
        return suspensionWorking;
    }

    public void setSuspensionWorking(boolean suspensionWorking) {
        this.suspensionWorking = suspensionWorking;
    }

    public boolean isBrakesWorking() {
        return brakesWorking;
    }

    public void setBrakesWorking(boolean brakesWorking) {
        this.brakesWorking = brakesWorking;
    }

    public boolean isBodyWorking() {
        return bodyWorking;
    }

    public boolean isTransmissionWorking() {
        return transmissionWorking;
    }

    public void setTransmissionWorking(boolean transmissionWorking) {
        this.transmissionWorking = transmissionWorking;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void giveToJanusz() {
        //ma najdro??sze ceny ale 100% gwarancj??
    }

    @Override
    public void giveToMarian() {
        //bierze zdecydowanie mniej ni?? Janusz, ale masz 10% szans,
        // ??e nie uda mu si?? naprawi?? samochodu i konieczna b??dzie interwencja Janusza
    }

    @Override
    public void giveToAdrian() {
        //jest najta??szy, ale masz 20% szans, ??e nie uda mu si??
        // naprawi?? i 2% szans, ??e zepsuje co?? innego podczas naprawy
    }
}
