package com.pluralsight;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int thisYear = 2025;
        int carAge = thisYear - year;

        double value = super.getValue();
        double newValue;
        if (carAge < 3) {
            newValue = value *(1.0 -(0.03 * carAge));
        } else if (carAge <= 6) {
            newValue = value * (1.0 -(0.06 * carAge));
        } else if (carAge <= 10) {
            newValue = value * (1.0 - (0.10 * carAge));
        } else {
            newValue = 1000.0;
        }

        if (odometer > 100000 && (!makeModel.contains("honda") || !makeModel.contains("toyota"))) {
            newValue = newValue * 0.75;
        }

        return newValue;
    }
}
