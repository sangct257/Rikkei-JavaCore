package bai3.model;

public class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private double workingHour;

    public PartTimeEmployee(int id, String name, double hourlyRate, double workingHour) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.workingHour = workingHour;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workingHour;
    }
}
