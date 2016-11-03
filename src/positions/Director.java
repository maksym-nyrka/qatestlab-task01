package positions;


import positions.models.FixedRateable;
import positions.models.Position;

public class Director extends Position implements FixedRateable {

    public Director() {
        super();
        this.addAbility("LUL");
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
