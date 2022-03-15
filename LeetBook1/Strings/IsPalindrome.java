package Strings;

import org.junit.Test;

public class IsPalindrome {

    public boolean isValidChar(char c) {
        return ((c < 'a' || c > 'z') && (c < '0' || c > '9'));
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        char c1, c2;
        while (i < j) {
            while (i < s.length() && isValidChar(s.charAt(i))) i++;
            while (j > 0 && isValidChar(s.charAt(j))) j--;
            if (i >= j) break;

            c1 = s.charAt(i);
            c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            } else {
                i++;
                j--;
            }

        }
        return true;
    }

    @Test
    public void mytest() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

}
