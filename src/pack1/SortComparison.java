package pack1;
import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr1 = new int[100000];
        int[] arr2 = new int[100000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt();
            arr2[i] = arr1[i];
        }

        long startTime1 = System.nanoTime();
        Arrays.sort(arr1);
        long endTime1 = System.nanoTime();
        long time1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        Arrays.parallelSort(arr2);
        long endTime2 = System.nanoTime();
        long time2 = endTime2 - startTime2;

        System.out.println("Arrays.sort() time: " + time1 + " ns");
        System.out.println("Arrays.parallelSort() time: " + time2 + " ns");
    }
}
