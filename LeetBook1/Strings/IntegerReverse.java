package Strings;

import org.junit.Test;

public class IntegerReverse {

    public int reverse(int x) {
        int res=0;
        boolean flag =false;
        if(x<0){
            x=-x;
            flag=true;
        }
        while(x>0){
            int temp=x%10;
            //判断是否越界，越界返回0
            if(res>Integer.MAX_VALUE/10 || res==Integer.MAX_VALUE/10 && temp>Integer.MAX_VALUE%19){
                return 0;
            }
            res*=10;
            res+=temp;
            x/=10;
        }
        if(flag) res=-res;
        return res;
    }

    @Test
    public void mytest() {
        int num = 123;
        System.out.println(num);
        System.out.println(reverse(num));
    }
}
