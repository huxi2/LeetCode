package Strings;

import org.junit.Test;

public class ReverseString {

    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char c=s[i];
            s[i] =s[s.length -1-i];
            s[s.length -1-i] =c;
        }
    }

    @Test
    public void mytest() {
        char[] s = {'h','e','l','l','o'};
        for (char c:s){
            System.out.print(c);
        }
        System.out.println();
        reverseString(s);
        for (char c:s){
            System.out.print(c);
        }


    }
}
