package exercises;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {

        int[] abc = {1, 5, 8, 9, 8,5,1,1};
        int current = -1;
        int count = 0;
        Arrays.sort(abc);


        for (int i = 0; i < abc.length -1; i++) {
            if (abc[i] == abc[i+1]) {
                if(abc[i] != current){
                    current = abc[i];
                    System.out.println(current);
                    count ++;
                }

            }

            current = abc[i];
        }
        System.out.println(count);
    }
}
