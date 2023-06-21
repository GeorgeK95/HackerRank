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
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
         int luckSum = 0;

        contests.sort((o1, o2) -> {
            int comparatorByRow = Integer.compare(o2.get(1), o1.get(1));

            if (comparatorByRow != 0) {
                return comparatorByRow;
            } else {
                return Integer.compare(o2.get(0), o1.get(0));
            }
        });

        List<List<Integer>> luckiests = new ArrayList<>();
        List<List<Integer>> theWon = new ArrayList<>();
        List<List<Integer>> nonImportant = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            luckiests.add(contests.get(i));
        }

        for (int i = k; i < contests.size(); i++) {
            List<Integer> itemToAdd = contests.get(i);
            if (itemToAdd.get(1) == 1) {
                theWon.add(itemToAdd);
            }
        }

        for (int i = k; i < contests.size(); i++) {
            List<Integer> itemToAdd = contests.get(i);
            if (itemToAdd.get(1) == 0) {
                nonImportant.add(itemToAdd);
            }
        }

        for (List<Integer> row : luckiests) {
            luckSum += row.get(0);
        }

        for (List<Integer> row : theWon) {
            luckSum -= row.get(0);
        }

        for (List<Integer> row : nonImportant) {
            luckSum += row.get(0);
        }

        return luckSum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new 
InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new 
FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = 
bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                contests.add(
                    
Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

