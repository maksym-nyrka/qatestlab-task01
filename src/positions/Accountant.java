package positions;


import employees.OfficeEmployee;
import helpful.Info;
import positions.models.FixedRateable;
import positions.models.Position;

import java.util.ArrayList;

public class Accountant extends Position implements FixedRateable {
    public Accountant()
    {
        super();
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

    //TODO add default abilities to all positions
    private void addDefaultAbilities() {
        for (int i=0; i<Info.ACCOUNTANT_ABILITIES.length;i++)
            this.addAbility(Info.ACCOUNTANT_ABILITIES[i]);
    }
    public void sendSalary(ArrayList<OfficeEmployee> employees)
    {
        for (OfficeEmployee e: employees) {
            //TODO give money
        }
    }
}
