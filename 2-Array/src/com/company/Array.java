package com.company;

import java.util.Arrays;

public class Array <T>{
    public static boolean all_elements_unique(char [] array) {
        boolean ascii[] = new boolean[256];
        Arrays.fill(ascii, false);
        char ch;
        int ascii_value;
        for (var i = 0; i < array.length; ++i) {
            ch = array[i];
            ascii_value = (int) ch;
            if (ascii[ascii_value])
                return false;
            ascii[ascii_value] = true;
        }
        return true;
    }
}
