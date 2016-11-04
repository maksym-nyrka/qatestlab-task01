package positions;


import helpful.Info;
import positions.models.HourlyRateable;
import positions.models.Position;

public class Tester extends Position implements HourlyRateable {

    private int workedHours;

    public Tester() {
        super();
        this.setHourlyRate(Info.TESTER_SALARY);
        this.workedHours=0;
        addDefaultAbilities();
    }

    @Override
    public void setHourlyRate(double amount) {
        this.setSalary(amount);
    }

    @Override
    public double getHourlyRate() {
        return this.getSalary();
    }

    @Override
    public void setWorkedHours(int hours) {
        this.workedHours=hours;
    }

    @Override
    public int getWorkedHours() {
        return this.workedHours;
    }

    @Override
    public void addWorkedHours(int hours) {
        this.workedHours+=hours;
    }

    private void addDefaultAbilities() {
        for (int i=0; i<Info.TESTER_ABILITIES.length;i++)
            this.addAbility(Info.TESTER_ABILITIES[i]);
    }
}
