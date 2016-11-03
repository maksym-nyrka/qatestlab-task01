package positions;


import positions.models.FixedRateable;
import positions.models.Position;

public class Manager extends Position implements FixedRateable {

    public Manager() {
        super();
    }

    @Override
    public void setFixedRate(double amount) {
        this.setSalary(amount);
    }

    @Override
    public double getFixedRate() {
        return this.getSalary();
    }
}
