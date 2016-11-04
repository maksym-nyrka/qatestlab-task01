import employees.OfficeEmployee;
import employees.RemoteEmployee;
import helpful.Info;
import helpful.generators.EmployeesGenerator;
import helpful.generators.ReportGenerator;
import helpful.random.GodWill;
import helpful.random.RandomNumberBetween;
import positions.Accountant;
import positions.Director;
import positions.models.HourlyRateable;
import positions.models.Position;

import java.util.ArrayList;

public class Office {

    private static final int LAST_DAY=30;
    private static ArrayList<OfficeEmployee> employees;
    private static RemoteEmployee freelancer;
    private static int day;
    private static int hour;

    public static void main(String[] args){
        employees = EmployeesGenerator.generate(RandomNumberBetween.get(10,100));
        freelancer = new RemoteEmployee();

        for (day=1;day<=LAST_DAY;day++)
        {
            if (day%7==0){
                accountantSendsSalary();
            }
            for (hour = Info.OFFICE_WORK_HOURS.getFirst();hour<Info.OFFICE_WORK_HOURS.getSecond();hour++)
            {
                System.out.println("d"+day+"h"+hour);
                directorGivesTasks();
            }
        }

        ReportGenerator.generate(employees,freelancer);

    }

    private static void directorGivesTasks()
    {
        for ( OfficeEmployee e : employees)
        {
            for (Position p : e.getPositions()) {
                if (p instanceof Director) {
                     ArrayList<String> tasks = ((Director) p).giveTasks();
                    tasks.forEach(Office::doTask);
                    return;
                }
            }
        }
    }
    private static void accountantSendsSalary()
    {
        for (OfficeEmployee e: employees)
            for (Position p : e.getPositions()) {
                if (p instanceof Accountant) {
                    ((Accountant) p).sendSalary(employees);
                    return;
                }
            }
    }
    private static void doTask(String taskName)
    {
        boolean taskIsComplex = GodWill.isThere();//"true" == task requires 2 hours
        boolean taskIsGiven = false;
        for (OfficeEmployee e : employees ) {
            for (Position p : e.getPositions()) {
                for (String s : p.getAbilitiesList()) {
                    if (s.equals(taskName)) {
                        if (!taskIsComplex && e.getWorkingHours().getFirst() < hour//if task requires 1hour
                                && e.getWorkingHours().getSecond() > (hour + 1)     //and employee is free
                                && !e.getBusyHours().contains(hour)
                                && !e.getBusyHours().contains(hour + 1))
                        {
                            taskIsGiven = true;
                            if (p instanceof HourlyRateable)
                                ((HourlyRateable) p).addWorkedHours(1);
                            e.getBusyHours().add(hour);
                            e.getBusyHours().add(hour + 1);
                        }
                        else if (e.getWorkingHours().getSecond() > (hour + 2)//if task req. 2 hours
                                && !e.getBusyHours().contains(hour + 2))    //and employee is free
                        {
                            taskIsGiven = true;
                            if (p instanceof HourlyRateable)
                                ((HourlyRateable) p).addWorkedHours(2);
                            e.getBusyHours().add(hour);
                            e.getBusyHours().add(hour + 1);
                            e.getBusyHours().add(hour + 2);
                        }
                    }
                }
            }
        }

        if (!taskIsGiven)
            giveTaskToFreelancer(taskName);
    }
    private static void giveTaskToFreelancer(String taskName)
    {
        //TODO

    }
}
