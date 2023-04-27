package edu.neu.csye6200.peoplemanagementsystem.pojo;

public class Compensation {
    public Compensation(double basePay, double bonus, double healthinsurance, double contribute401k, double totalComp) {
        this.basePay = basePay;
        this.bonus = bonus;
        this.healthinsurance = healthinsurance;
        this.contribute401k = contribute401k;
        this.totalComp = totalComp;
    }

    private double basePay;
    private double bonus;
    private double healthinsurance;

    private double contribute401k; //would be the percentage for 401k contribution by the employee

    private double totalComp;//would be the total compensation



    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getHealthinsurance() {
        return healthinsurance;
    }

    public void setHealthinsurance(double healthinsurance) {
        this.healthinsurance = healthinsurance;
    }

    public double getContribute401k() {
        return contribute401k;
    }

    public void setContribute401k(double contribute401k) {
        this.contribute401k = contribute401k;
    }

    public double getTotalComp() {
        return totalComp;
    }

    public void setTotalComp(double totalComp) {
        this.totalComp = totalComp;
    }

    public void calTotalComp(){
    }
}
