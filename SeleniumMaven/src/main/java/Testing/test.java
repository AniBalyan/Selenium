package Testing;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        int[] abc = {1, 5, 8, 9, 8};
        int current = abc[0];
        int count = 1;
        Arrays.sort(abc);
      //  System.out.println(abc[3]);


        for (int i = 0; i < abc.length; i++) {
            if (abc[i] == current) {
                current = abc[i];
                System.out.println(current);
            }

            current = abc[i];
        }
    }
}