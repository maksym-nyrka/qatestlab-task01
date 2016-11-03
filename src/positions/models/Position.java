package positions.models;


import java.util.ArrayList;

//Abstract class Position that has all common parameters and methods for all positions
public abstract class Position {
    private ArrayList<String> abilitiesList;
    private double salary;

    public Position()
    {
        abilitiesList = new ArrayList<>();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<String> getAbilitiesList() {
        return abilitiesList;
    }

    public void setAbilitiesList(ArrayList<String> abilitiesList) {
        this.abilitiesList = abilitiesList;
    }

    public void addAbility(String abilityName) {
        this.abilitiesList.add(abilityName);
    }
}
