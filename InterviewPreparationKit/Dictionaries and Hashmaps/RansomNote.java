package com.mfutbg.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> 
note) {
        for (String magazineWord : magazine) {
            note.remove(magazineWord);
        }
        System.out.println(note.isEmpty() ? "Yes" : "No");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new 
InputStreamReader(System.in));

        String[] firstMultipleInput = 
bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = 
Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = 
Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
