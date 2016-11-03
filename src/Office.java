import employees.OfficeEmployee;
import positions.models.Position;

public class Office {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        OfficeEmployee s = new OfficeEmployee();
        String s1 = "Director";


        Class<?> clazz = Class.forName("positions." + s1);
        Object object = clazz.newInstance();
        s.getPositions().add((Position) object);
        s.getPositions().get(0).addAbility("Lel");
        s.getPositions().get(0).getAbilitiesList().forEach(System.out::println);
    }
}
