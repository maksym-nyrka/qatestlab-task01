package positions;


import helpful.Info;
import positions.models.HourlyRateable;
import positions.models.Position;

public class Programmer extends Position implements HourlyRateable {

    private int workedHours;

    public Programmer() {
        super();
        this.workedHours=0;
        this.setHourlyRate(Info.PROGRAMMER_SALARY);
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
        for (int i=0; i<Info.PROGRAMMER_ABILITIES.length;i++)
            this.addAbility(Info.PROGRAMMER_ABILITIES[i]);
    }
}
