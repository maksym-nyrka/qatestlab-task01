package helpful.generators;


import employees.OfficeEmployee;
import employees.RemoteEmployee;
import main.Office;
import positions.Accountant;
import positions.models.Position;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    private static String fileName = "report.txt";
    public static void generate(ArrayList<OfficeEmployee> employees, RemoteEmployee freelancer)
    {
        List<String> lines = new ArrayList<>();

        lines.add("Tasks that have been done:");
        Accountant accountant;
        int i=1;
        if ((accountant= Office.getMainAccountant())!=null)
        for (Map.Entry entry : accountant.getDoneTasks().entrySet())
        {
            lines.add(i+++"."+entry.getKey()+" - "+entry.getValue()+" times");
        }

        lines.add("");
        lines.add("Salary:");
        int j=1;
        StringBuilder sb;
        for (OfficeEmployee e : employees)
        {
            sb= new StringBuilder();
            sb.append("(").append(e.getWorkingHours().getFirst())
                    .append(":00-").append(e.getWorkingHours().getSecond()).append(":00) ");
            for (Position p : e.getPositions()) {
                sb.append(p.getClass().getSimpleName()).append(", ");
            }
            sb.setLength(Math.max(sb.length() - 2, 0));//remove two last chars from string
            lines.add("Employee #"+j+++" "+sb.toString()+": "+"$"+e.getEarnedMoney());
        }

        lines.add("");
        lines.add("Paid to freelancers: "+"$"+freelancer.getEarnedMoney());

        Path file = Paths.get(fileName);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
