package helpful.generators;


import employees.OfficeEmployee;
import helpful.Info;
import helpful.random.GodWill;
import helpful.random.RandomNumberBetween;
import positions.Accountant;
import positions.Director;
import positions.Manager;
import positions.models.Position;

import java.util.ArrayList;

//Class that generates employees for the company
public class EmployeesGenerator {
    public static ArrayList<OfficeEmployee> generate(int number) {
        assert number > 3; //required minimum for the company
        ArrayList<OfficeEmployee> officeEmployeeList = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            officeEmployeeList.add(new OfficeEmployee());
        }

        //Adding to first employees positions that are required (Director,Manager,Accountant)
        officeEmployeeList.get(0).getPositions().add(new Director());
        officeEmployeeList.get(1).getPositions().add(new Manager());
        officeEmployeeList.get(2).getPositions().add(new Accountant());

        //Adding positions to all employees
        for (int i = 3; i < number; i++) {
            for (int j = 0; j < Info.NUMBER_OF_POSITIONS; j++) {
                if (GodWill.isThere()) {
                    try {
                        Class<?> c = Class.forName("positions." + Info.NAMES_OF_POSITIONS[j]);
                        officeEmployeeList.get(i).getPositions().add((Position) c.newInstance());
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //Checking if all employees got at least one position, if not then adding one random position
        for (int i=0;i<number;i++)
        {
            if(officeEmployeeList.get(i).getPositions().isEmpty())
            {
                try {
                    Class<?> c = Class.forName
                            ("positions." + Info.NAMES_OF_POSITIONS[RandomNumberBetween.get(0,Info.NUMBER_OF_POSITIONS-1)]);
                    officeEmployeeList.get(i).getPositions().add((Position) c.newInstance());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        //Generating working hours (schedule) for employees
        for (int i=0;i<number;i++)
        {
            int h = RandomNumberBetween.get(Info.OFFICE_WORK_HOURS.getFirst(),Info.OFFICE_WORK_HOURS.getSecond()-8);
            officeEmployeeList.get(i).getWorkingHours().setFirst(h);
            officeEmployeeList.get(i).getWorkingHours().setSecond(h+8);
        }

        return officeEmployeeList;
    }
}
