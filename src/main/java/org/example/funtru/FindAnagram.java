package org.example.funtru;

import java.util.Arrays;

public class FindAnagram {
    public static void main(String[] arg) {
//        Check whether two Strings are anagram of each other

        String str1 = "listen", str2 = "silent";
        char[] sStr1 = str1.toCharArray();
        char[] sStr2 = str2.toCharArray();
        Arrays.sort(sStr1);
        Arrays.sort(sStr2);
        boolean flag = false;
        for (int i = 0; i < sStr1.length; i++) {
            System.out.println(sStr1[i]  + " - "+ sStr2[i]);
            if (sStr1[i] != sStr2[i]) {
                System.out.println("Strings are not anagram");
                flag=true; break;
            }
        }
        if(!flag)
            System.out.println("Strings are Anagram..");
    }
}
