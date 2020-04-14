package org.fasttrackit;

import javax.sound.midi.Soundbank;

public class Vehicle {

    // static variable / class variable
    private static int totalVehicleCount;

    // instance variables
    private int racingNumber;
    private String name;
    private int maxSpeed;
    private double mileage;
    private String colour;
    private double fuelLevel;
    private double totalDistance;
    private boolean damaged;

    public Vehicle () {
        totalVehicleCount++;
    }

    public double accelerate (double speed) {
        return accelerate(speed, 1);
    }

    public double accelerate(double speed, double durationInHours) {
        if (fuelLevel <= 0) {
            System.out.println("Not enough fuel.");
            return 0;
        }

        if (speed > maxSpeed) {
            System.out.println("Max speed exceeded!");
            return 0;
        } else if (speed == maxSpeed) {
            System.out.println("Be careful! Max speed reached!");
        } else {
            System.out.println("Valid speed entered.");
        }

        double mileageMultiplier = 1;
        if (speed > 120) {
            mileageMultiplier = speed / 100;
        }

        System.out.println(name + " is accelerating with " + speed + " km/h for " + durationInHours + " h ");

        // local variable
        double traveledDistance = speed * durationInHours;

        System.out.println("Traveled distance: " + traveledDistance);

        totalDistance += traveledDistance;

        System.out.println("Total traveled distance: " + totalDistance);

        double usedFuel = traveledDistance * mileage / 100;

        usedFuel *= mileageMultiplier;

        fuelLevel = fuelLevel - usedFuel;

        // same result as the instruction above
//        fuelLevel -= usedFuel;

        System.out.println("Remaining fuel: " + fuelLevel);

        return traveledDistance;
    }

    public void decelerate() {
        // TODO: implement this
        System.out.println("This is a just a demo method");
    }

    // co-variant return type
    protected Vehicle clone() {
        return new Vehicle();
    }
    // write-only

    public int getRacingNumber() {
        return racingNumber;
    }

    public void setRacingNumber(int racingNumber) {
        this.racingNumber = racingNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    // read-only property
    public static int getTotalVehicleCount() {
        return totalVehicleCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "racingNumber=" + racingNumber +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", mileage=" + mileage +
                ", colour='" + colour + '\'' +
                ", fuelLevel=" + fuelLevel +
                ", totalDistance=" + totalDistance +
                ", damaged=" + damaged +
                '}';
    }
}
