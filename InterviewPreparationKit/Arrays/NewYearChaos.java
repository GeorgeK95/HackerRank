import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
     
     
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int n = q.size();
        int bribes = 0;

        for (int i = n - 2; i >= 0; i--) {
            int j = i;

            if (q.get(j) > q.get(j + 1)) {
                int bribesPerPerson = 0;

                while (j <= (q.size() - 2) && q.get(j) > q.get(j + 1)) {
                    int temp = q.get(j);
                    q.set(j, q.get(j + 1));
                    q.set(j + 1, temp);
                    j++;
                    bribesPerPerson++;
                }

                bribes += bribesPerPerson;

                if (bribesPerPerson > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
            }

        }

        System.out.println(bribes);
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new 
InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = 
Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = 
Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

