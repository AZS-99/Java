package com.company;

/*
A palindrome is a sequence of characters that reads the same forwards and backwards. e.g. RADAR, MADAMIMADAM
You are to write a program which finds the longest palindrome in a given string of characters.

Input:
The input file will begin with a line containing one positive integer n, the number of strings to be tested, followed by
n lines each containing one string of characters of up to 25,000 characters in length and terminated with a blank. The
input strings will contain upper case letters only.

Output:
Your program should output a pair of lines for each test case with the palindrome on the first line and the length of
the palindrome on the second. In the event of a tie for longest, any of the palindromes in the tie may be reported.
Sample Input

1
AHAHJHFYUBNMLOIUYTRERTYUIOLMNBAGWOIS
Output for sample input

BNMLOIUYTRERTYUIOLMNB
21
 */

public class LongestPalindrome {

    public static boolean isPalindrome(String string) {
        var len = string.length();
        if (len < 2) return true;
        return isPalindrome(string.substring(1, len - 1)) && string.charAt(0) == string.charAt(len - 1);
    }

    public static String findLongest(String string) {
        if (string.length() < 2 || isPalindrome(string))
            return string;
        var longestLeft = findLongest(string.substring(0, string.length() - 1));
        System.out.println(longestLeft);
        var longestRight = findLongest(string.substring(1));
        System.out.println(longestRight);
        return longestLeft.length() > longestRight.length() ? longestLeft : longestRight;
    }


}
