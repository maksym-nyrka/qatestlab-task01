package employees;

import helpful.Info;
import helpful.Pair;
import helpful.random.RandomNumberBetween;
import positions.models.Position;

//Class that describes an employee who is hired by the company when all office workers are occupied
// (a freelancer)
public class RemoteEmployee extends Position {

    private double earnedMoney;
    private Pair<Double,Double> expensiveTasksCost;
    private Pair<Double,Double> tasksCost;


    public RemoteEmployee() {
        super();
        this.expensiveTasksCost = new Pair<>(105.5,307.84);
        this.tasksCost = new Pair<>(15.5,37.84);
        this.earnedMoney=0;
        addAbilities();
    }

    private void addAbilities(){
        Info.getAllAbilities().forEach(this::addAbility);
    }

    public double getEarnedMoney() {
        return earnedMoney;
    }

    public void addEarnedMoney(double earnedMoney) {
        this.earnedMoney += earnedMoney;
    }

    public Pair<Double, Double> getExpensiveTasksCost() {
        return expensiveTasksCost;
    }

    public Pair<Double, Double> getTasksCost() {
        return tasksCost;
    }

    public void doTask(String taskName)
    {
        boolean taskIsExpensive=false;
        for (int i=0;i<Info.ACCOUNTANT_ABILITIES.length;i++)
            if (taskName.equals(Info.ACCOUNTANT_ABILITIES[i]))
                taskIsExpensive=true;
        for (int i=0;i<Info.MANAGER_ABILITIES.length;i++)
            if (taskName.equals(Info.MANAGER_ABILITIES[i]))
                taskIsExpensive=true;

        if (taskIsExpensive)
        {
            this.addEarnedMoney(RandomNumberBetween
                    .get(this.getExpensiveTasksCost().getFirst()
                            ,this.getExpensiveTasksCost().getSecond()));
        }else
            this.addEarnedMoney(RandomNumberBetween
                    .get(this.getTasksCost().getFirst()
                            ,this.getTasksCost().getSecond()));
    }
}
