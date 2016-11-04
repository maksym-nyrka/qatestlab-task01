package positions;


import helpful.Info;
import positions.models.FixedRateable;
import positions.models.Position;

public class Manager extends Position implements FixedRateable {

    public Manager() {
        super();
        this.setFixedRate(Info.MANAGER_SALARY);
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
        for (int i=0; i<Info.MANAGER_ABILITIES.length;i++)
            this.addAbility(Info.MANAGER_ABILITIES[i]);
    }
}
