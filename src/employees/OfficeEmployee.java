package employees;


import helpful.Pair;
import positions.models.Position;

import java.util.ArrayList;

//Class that describes an employee that works in the company
public class OfficeEmployee {
    //public static final int MAX_WORK_HOURS_PER_WEEK = 40;
    private int workedHours;
    private ArrayList<Position> positions;
    private Pair<Integer, Integer> workingHours; //<from,to>
    private boolean isBusy;

    public OfficeEmployee() {
        this.isBusy = false;
        this.workedHours = 0;
        this.positions = new ArrayList<>();
        this.workingHours = new Pair<>(0, 0);
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
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

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
