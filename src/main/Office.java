package main;

import employees.OfficeEmployee;
import employees.RemoteEmployee;
import helpful.Info;
import helpful.generators.EmployeesGenerator;
import helpful.generators.ReportGenerator;
import helpful.random.RandomNumberBetween;
import positions.Accountant;
import positions.Director;
import positions.models.Position;

import java.util.ArrayList;

public class Office {

    private static final int LAST_DAY=30;
    private static int day;
    private static int hour;

    private static ArrayList<OfficeEmployee> employees;
    private static RemoteEmployee freelancer;
    private static Accountant accountant;
    private static Director director;

    public static void main(String[] args){
        employees = EmployeesGenerator.generate(RandomNumberBetween.get(10,100));
        freelancer = new RemoteEmployee();
        accountant=getMainAccountant();
        director=getDirector();

        for (day=1;day<=LAST_DAY;day++)
        {
            if (day%7==0){//Every Sunday main accountant sends salary to programmers,testers,designers
                accountant.sendWeeklySalary(employees);
            }
            for (hour = Info.OFFICE_WORK_HOURS.getFirst();hour<Info.OFFICE_WORK_HOURS.getSecond();hour++)
            {
                System.out.println("d"+day+"h"+hour);
                directorGivesTasks();
            }
            for (OfficeEmployee e: employees)//Working day is over, employees are free
                e.setBusyHoursNull();
            if (day==LAST_DAY) {//On the last day of month main accountant sends salary to all employees
                accountant.sendMonthlySalary(employees);
                accountant.sendWeeklySalary(employees);
            }
        }

        ReportGenerator.generate(employees,freelancer);

    }

    public static Director getDirector()
    {
        for ( OfficeEmployee e : employees)
        {
            for (Position p : e.getPositions()) {
                if (p instanceof Director) {
                    return (Director) p;
                }
            }
        }
        return null;
    }
    public static Accountant getMainAccountant()
    {
        for ( OfficeEmployee e : employees)
        {
            for (Position p : e.getPositions()) {
                if (p instanceof Accountant) {
                    return (Accountant) p;
                }
            }
        }
        return null;
    }

    private static void directorGivesTasks()
    {
        ArrayList<String> tasks = director.giveTasks();
        for (String s : tasks)
        {
            if(!doTask(s))
                freelancer.doTask(s);
            accountant.addDoneTask(s);
        }
    }

    private static boolean doTask(String taskName)
    {
            for (OfficeEmployee e : employees) {
                if (e.doTask(taskName,hour)) {
                    return true;
                }
            }
            return false;
    }
}
