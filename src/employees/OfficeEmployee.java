package employees;


import helpful.Pair;
import positions.models.Position;

import java.util.ArrayList;

//Class that describes an employee that works in the company
public class OfficeEmployee {
    private ArrayList<Position> positions;
    private Pair<Integer, Integer> workingHours; //<from,to>
    private ArrayList<Integer> busyHours;
    private double earnedMoney;

    public OfficeEmployee() {
        this.earnedMoney = 0;
        this.positions = new ArrayList<>();
        this.workingHours = new Pair<>(0, 0);
        busyHours=new ArrayList<>();

    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public Pair<Integer, Integer> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Pair<Integer, Integer> workingHours) {
        this.workingHours = workingHours;
    }

    public double getEarnedMoney() {
        return earnedMoney;
    }

    public void addEarnedMoney(double earnedMoney) {
        this.earnedMoney += earnedMoney;
    }

    public ArrayList<Integer> getBusyHours() {
        return busyHours;
    }
}
