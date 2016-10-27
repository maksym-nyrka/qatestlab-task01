package positions.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Abstract class Position that has all common parameters and methods for all positions
public abstract class Position {
    private ArrayList<String> abilitiesList;

    public Position()
    {
        abilitiesList = new ArrayList<>();
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
