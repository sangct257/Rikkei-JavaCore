package bai3.model;

public class FullTimeEmployee extends Employee implements BonusEligible{
    // lương cơ bản
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    // thưởng 10%
    @Override
    public double calculateBonus() {
        return baseSalary * 10/100;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
