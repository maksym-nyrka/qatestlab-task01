package helpful;


import positions.models.Position;

import java.util.ArrayList;

public class Info {
    public final static int NUMBER_OF_POSITIONS = 5;
    public final static String[] NAMES_OF_POSITIONS =
            {"Accountant", "Manager", "Programmer", "Tester", "Designer"};
    public final static Pair<Integer,Integer> OFFICE_WORK_HOURS = new Pair<>(8,20);//Hours when office work,
                                                                                    // from 8:00 to 20:00
    public final static double DIRECTOR_SALARY=5000;
    public final static double ACCOUNTANT_SALARY=4000;
    public final static double MANAGER_SALARY=3000;
    public final static double PROGRAMMER_SALARY=30;
    public final static double TESTER_SALARY=25;
    public final static double DESIGNER_SALARY=20;

    public final static String[] ACCOUNTANT_ABILITIES={"Calculate the profit","Make the report"};
    public final static String[] MANAGER_ABILITIES={"Sell the services","Make a schedule"};
    public final static String[] PROGRAMMER_ABILITIES={"Write code","Fix bugs"};
    public final static String[] TESTER_ABILITIES={"Test a program","Write a test-suit"};
    public final static String[] DESIGNER_ABILITIES={"Draw a mock-up","Redraw a mock-up"};

    public static ArrayList<String> getAllAbilities()
    {
        ArrayList<String> list = new ArrayList<>(Info.NUMBER_OF_POSITIONS);
        for (int i=0;i<Info.NUMBER_OF_POSITIONS;i++)
        {
            try {
                Class<?> c = Class.forName("positions." + Info.NAMES_OF_POSITIONS[i]);
                ((Position) c.newInstance()).getAbilitiesList().forEach(list::add);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
