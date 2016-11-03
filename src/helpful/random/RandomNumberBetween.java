package helpful.random;

import java.util.concurrent.ThreadLocalRandom;

//Generates a helpful.random number between two given numbers
public class RandomNumberBetween {
    public static int get(int first, int second)
    {
        assert second>first;
        return ThreadLocalRandom.current().nextInt(first,second);
    }
    public static double get(double first, double second)
    {
        assert second>first;
        return ThreadLocalRandom.current().nextDouble(first, second);
    }
}
