package positions;


import positions.models.HourlyRateable;
import positions.models.Position;

public class Programmer extends Position implements HourlyRateable {

    public Programmer() {
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
