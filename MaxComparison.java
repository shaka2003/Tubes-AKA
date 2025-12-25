import java.util.Random;

public class MaxComparison {

    public static int maxIterative(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int maxRecursive(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n - 1], maxRecursive(arr, n - 1));
    }

    public static void main(String[] args) {
        int[] inputSizes = {1, 10, 20, 100, 500, 1000, 5000, 10000};
        Random random = new Random();

        int repeat = 100_000;

        System.out.println("Ukuran Input | Iteratif (ns) | Rekursif (ns)");
        System.out.println("--------------------------------------------");

        for (int size : inputSizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(100000);
            }

            //iterasi
            long startIter = System.nanoTime();
            for (int i = 0; i < repeat; i++) {
                maxIterative(arr);
            }
            long endIter = System.nanoTime();

            //rekursif
            long startRec = System.nanoTime();
            for (int i = 0; i < repeat; i++) {
                maxRecursive(arr, arr.length);
            }
            long endRec = System.nanoTime();

            double iterAvg = (double) (endIter - startIter) / repeat;
            double recAvg  = (double) (endRec - startRec) / repeat;

            System.out.printf(
                "%12d | %13.2f | %13.2f%n",
                size, iterAvg, recAvg
            );
        }
    }
}
