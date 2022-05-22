package com.company;

/*

Earth is being invaded by space aliens. Earth defence forces have rallied a number of anti-spacecraft guns. However,
they have a bug in their aiming hardware: initially they are aimed straight up, and this aim can only be adjusted
downward.

Thousands of alien craft are streaking towards Earth as we speak -- and yes, some of them are even aimed at Canada. The
Earth defence forces must now come into play. Each gun can fire as many shots as necessary, and can be re-fired as often
and as quickly as necessary, but only to a lower setting. Thus if a spacecraft came in at height 3 and then another at
height 2, one gun could eliminate both, but could not if they came in the other order. The Earth has only a finite
number of guns, and it is unknown how many alien craft are coming in; thus, they need a way to minimize the number of
guns for a given set of incoming alien craft. Guess what? This is where you come in!

Input

The data will consist of several sets of data. The first line of each set will contain one positive integer n
(n < 100000), where n is the number of incoming alien craft. The next n lines will contain one floating point number
giving the heights of the incoming alien craft in order of arrival (ie, the order the guns must eliminate them). The
last line in the data file will contain only zero, ie n = 0.
Output

For each set other than the final, n = 0, case, one integer specifying the minimum number of guns required to eliminate
EVERY alien craft is to be output.
Sample Input

10
4.0
2.0
3.0
4.0
5.0
3.0
1.0
4.0
2.0
5.0
0
Output for sample input

4
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Aliens {
    public static ArrayList<ArrayList<Integer>> min_guns(ArrayList<Integer> lst) {
        if (lst.size() < 2) {
            var arrayList = new ArrayList<ArrayList<Integer>>();
            arrayList.add(lst);
            return arrayList;
        }
        var lstButLast = new ArrayList<>(lst.subList(0, lst.size() - 1));
        var semiFinal = min_guns(lstButLast);
        for (var sublist: semiFinal) {
            if (lst.get(lst.size() - 1) <= sublist.get(sublist.size() - 1)) {
                sublist.add(lst.get(lst.size() - 1));
                System.out.println(sublist);
                return semiFinal;
            }
        }
        var arrayList2 = new ArrayList<Integer>();
        arrayList2.add(lst.get(lst.size() - 1));
        semiFinal.add(arrayList2);

        return semiFinal;
    }
}
