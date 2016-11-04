package positions;


import helpful.Info;
import helpful.random.GodWill;
import helpful.random.RandomNumberBetween;
import positions.models.FixedRateable;
import positions.models.Position;

import java.util.ArrayList;

public class Director extends Position implements FixedRateable {

    public Director() {
        super();
        this.setFixedRate(Info.DIRECTOR_SALARY);
    }

    @Override
    public void setFixedRate(double amount) {
        this.setSalary(amount);
    }

    @Override
    public double getFixedRate() {
        return this.getSalary();
    }

    public ArrayList<String> giveTasks()
    {
        ArrayList<String> t = Info.getAllAbilities();
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add(t.get(RandomNumberBetween.get(0,t.size())));

        while (GodWill.isThere())
        {
            tasks.add(t.get(RandomNumberBetween.get(0,t.size())));
        }
        return tasks;
    }
}
