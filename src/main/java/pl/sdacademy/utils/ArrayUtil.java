package pl.sdacademy.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtil {
    public static <T> void shuffleArray(T[] ar)
    {
        if (ar == null || ar.length == 0 || ar.length == 1) { // nie trzeba sortowac pustej lub tablicy z jednym elementem lub tablicy ktora nie istniejeop…istniejeopm
            return;
        }

        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
