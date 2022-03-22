package Others;

import org.junit.Test;

public class HammingWeight {

    public int hammingWeight(int n) {
        String input = Integer.toBinaryString(n);
        int res=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '1')res++;
        }
        return res;
    }

    //位运算
    public int hammingWeight2(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            if(((n >>> i) & 1) == 1)res++;
        }
        return res;
    }

    @Test
    public void mytest(){
        System.out.println(hammingWeight(-3));
    }
}
