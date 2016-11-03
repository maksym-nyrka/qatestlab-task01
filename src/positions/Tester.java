package positions;


import positions.models.HourlyRateable;
import positions.models.Position;

public class Tester extends Position implements HourlyRateable {

    public Tester() {
        super();
    }

    @Override
    public void setHourlyRate(double amount) {
        this.setSalary(amount);
    }

    @Override
    public double getHourlyRate() {
        return this.getSalary();
    }
}
