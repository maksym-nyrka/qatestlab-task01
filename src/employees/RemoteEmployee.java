package employees;

import helpful.Info;
import positions.models.Position;

//Class that describes an employee who is hired by the company when all office workers are occupied
// (a freelancer)
public class RemoteEmployee extends Position {

    private double earnedMoney;

    public RemoteEmployee() {
        super();
        this.earnedMoney=0;
        addAbilities();
    }

    private void addAbilities(){
        Info.getAllAbilities().forEach(this::addAbility);
    }

    public double getEarnedMoney() {
        return earnedMoney;
    }

    public void setEarnedMoney(double earnedMoney) {
        this.earnedMoney = earnedMoney;
    }
}
