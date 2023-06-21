import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
     static int minimumSwaps(int[] arr) {
        int i = 0;
        int swaps = 0;

        while (i < arr.length) {
            // as array is of 1 based indexing so the
            // correct position or index number of each
            // element is element-1 i.e. 1 will be at 0th
            // index similarly 2 correct index will 1 so
            // on...
            int correctpos = arr[i] - 1;

            if (/*arr[i] < arr.length && */arr[i] != arr[correctpos]) {
                // if array element should be lesser than
                // size and array element should not be at
                // its correct position then only swap with
                // its correct position or index value
                int temp = arr[i];
                arr[i] = arr[correctpos];
                arr[correctpos] = temp;
                swaps++;
            } else {
                // if element is at its correct position
                // just increment i and check for remaining
                // array elements
                i++;
            }
        }

        return swaps;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new 
FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

