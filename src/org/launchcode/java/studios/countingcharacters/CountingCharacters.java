package org.launchcode.java.studios.countingcharacters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CountingCharacters {

    static void printSortedByKey(HashMap<Character, Integer> map) {
        ArrayList<Character> sortedKeys = new ArrayList<Character>(map.keySet());

        Collections.sort(sortedKeys);

        for(char ch: sortedKeys) {
            System.out.println(ch + " = " + map.get(ch));
        }

    }

    public static void main(String []args) {

        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> charsCount = new HashMap<>();

        System.out.print("String: ");
        char []chars = in.nextLine().toCharArray();

        for(Character ch: chars) {
            if(Character.isLetter(ch)) charsCount.compute(ch, (key, val) -> (val == null) ? 1 : val + 1);
        }

        printSortedByKey(charsCount);
    }
}
