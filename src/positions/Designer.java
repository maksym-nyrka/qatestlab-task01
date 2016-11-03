package positions;


import positions.models.HourlyRateable;
import positions.models.Position;

public class Designer extends Position implements HourlyRateable {

    public Designer() {
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
