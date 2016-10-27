import random.GodWill;

import java.util.concurrent.ThreadLocalRandom;

public class Office {

    public static void main(String[] args) {
        int j=0;
            for (int i = 0;i<1000000000;i++) {
                if (GodWill.isThere())
                    j++;
            }
        System.out.println(j/10000000+"% _");
    }
}
