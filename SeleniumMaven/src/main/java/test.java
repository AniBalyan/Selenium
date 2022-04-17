public class test {
    public static void main(String[] args) {

        int[] test = {5, 9, 4};
        int max = test[0];

        for (int findMax =1; findMax <= test.length; findMax++) {
            if (test[findMax] > max) {
                max = test[findMax];

                System.out.println(max);
            }

        }


    }
}
