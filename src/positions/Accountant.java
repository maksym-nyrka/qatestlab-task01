package positions;


import positions.models.FixedRateable;
import positions.models.Position;

public class Accountant extends Position implements FixedRateable {
    public Accountant()
    {
        super();
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

    //TODO add default abilities to all positions
    private void addDefaultAbilities() {
        this.addAbility("");
        this.addAbility("");
    }
}
