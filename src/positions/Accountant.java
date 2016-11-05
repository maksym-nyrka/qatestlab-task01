package positions;


import employees.OfficeEmployee;
import helpful.Info;
import positions.models.FixedRateable;
import positions.models.HourlyRateable;
import positions.models.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Accountant extends Position implements FixedRateable {

    private Map<String,Integer> doneTasks;

    public Accountant()
    {
        super();
        this.doneTasks = new HashMap<>();
        this.setFixedRate(Info.ACCOUNTANT_SALARY);
        addDefaultAbilities();
    }

    @Override
    public void setFixedRate(double amount) {
        this.setSalary(amount);
    }

    @Override
    public double getFixedRate() {
        return this.getSalary();
    }

    private void addDefaultAbilities() {
        for (int i=0; i<Info.ACCOUNTANT_ABILITIES.length;i++)
            this.addAbility(Info.ACCOUNTANT_ABILITIES[i]);
    }
    public void sendWeeklySalary(ArrayList<OfficeEmployee> employees)
    {
        for (OfficeEmployee e: employees)
        {
            e.getPositions().stream().filter(p -> p instanceof HourlyRateable).forEach(p -> {
                e.addEarnedMoney((((HourlyRateable) p).getWorkedHours()) * ((HourlyRateable) p).getHourlyRate());
                ((HourlyRateable) p).setWorkedHours(0);
            });
        }
    }

    public void sendMonthlySalary(ArrayList<OfficeEmployee> employees)
    {
        for (OfficeEmployee e: employees)
            e.getPositions().stream().filter(p -> p instanceof FixedRateable)
                    .forEach(p ->
                            e.addEarnedMoney(((FixedRateable) p).getFixedRate()));
    }

    public Map<String, Integer> getDoneTasks() {
        return doneTasks;
    }
    public void addDoneTask(String taskName){
        if (doneTasks.isEmpty())
        {
            ArrayList<String> t = Info.getAllAbilities();
            for (String s : t)
            {
                doneTasks.put(s,0);
            }
        }
        doneTasks.put(taskName,doneTasks.get(taskName)+1);
    }
}
