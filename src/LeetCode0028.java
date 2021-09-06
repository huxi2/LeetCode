import org.junit.Test;

public class LeetCode0028 {
    //对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
    //模式匹配  暴力破解法
    public int strStr(String haystack, String needle) {
        int i,j,res=-1;
        for(i=0;i<=haystack.length()-needle.length();i++){//可以判别haystack为空 needle非空
            int tempi=i;
            j=0;
            while (j<needle.length() && haystack.charAt(tempi)==needle.charAt(j)){
                j++;
                tempi++;
            }
            if (j==needle.length()){
                res=i;
                break;
            }
        }
        return res;
    }

    @Test
    public void mytest(){
        String str1="";
        String str2="0";
        System.out.println(strStr(str1,str2));
    }
}