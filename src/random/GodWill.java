package random;

import java.util.concurrent.ThreadLocalRandom;

//Returns true with some probability, helpful class for "yes-or-no" situations
public class GodWill {
    private static final int CHANCE_FOR_A_GOD_WILL=36; // ~36% chance of "true"
    public static boolean isThere()
    {
        return ThreadLocalRandom.current().nextInt(1,100) < CHANCE_FOR_A_GOD_WILL;
    }
}
