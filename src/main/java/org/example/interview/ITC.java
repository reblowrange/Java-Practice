package org.example.interview;

public class ITC {

        public static void main(String[] a) {
            String str = "A1B4C3D5";
            // Print "A1B4C3D5" to "ABBBBCCCDDDDD"
            char[] charArray = str.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                if (Character.isDigit(charArray[i])) {
                    int i1 = Integer.parseInt(String.valueOf(charArray[i]));
                    for (int k = 0; k < i1; k++) {
                        System.out.print(charArray[i-1]);
                    }
                }
            }
        }
}
