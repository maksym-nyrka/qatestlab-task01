package employees;


import helpful.Pair;
import helpful.random.GodWill;
import positions.models.HourlyRateable;
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

    public double getEarnedMoney() {
        return earnedMoney;
    }

    public void addEarnedMoney(double earnedMoney) {
        this.earnedMoney += earnedMoney;
    }

    public ArrayList<Integer> getBusyHours() {
        return busyHours;
    }

    public void setBusyHoursNull()
    {
        this.busyHours.clear();
    }


    public boolean doTask(String taskName, int currentHour)//returns "true" if task is done by this employee
    {
        boolean taskIsComplex= GodWill.isThere();//"true" == task requires 2 hours

        for (Position p : this.getPositions()) {
            for (String s : p.getAbilitiesList()) {
                if (s.equals(taskName))
                    if (!taskIsComplex && this.getWorkingHours().getFirst() < currentHour//if task requires 1hour
                            && this.getWorkingHours().getSecond() > (currentHour + 1)     //and employee is free
                            && !this.getBusyHours().contains(currentHour)
                            && !this.getBusyHours().contains(currentHour + 1))
                    {
                        if (p instanceof HourlyRateable)
                            ((HourlyRateable) p).addWorkedHours(1);
                        this.getBusyHours().add(currentHour);
                        this.getBusyHours().add(currentHour + 1);
                        return true;
                    } else if (this.getWorkingHours().getSecond() > (currentHour + 2)//if task req. 2 hours
                            && !this.getBusyHours().contains(currentHour + 2))    //and employee is free
                    {
                        if (p instanceof HourlyRateable)
                            ((HourlyRateable) p).addWorkedHours(2);
                        this.getBusyHours().add(currentHour);
                        this.getBusyHours().add(currentHour + 1);
                        this.getBusyHours().add(currentHour + 2);
                        return true;
                    }
            }
        }
        return false;
    }
}
