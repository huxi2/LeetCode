import org.junit.Test;

public class LeetCode0058 {

    public int lengthOfLastWord(String s) {
        //通过掉包实现
        //String[] strs = s.split(" ");
        //if(strs.length>1)return strs[strs.length-1].length();

        int res=0;
        //从字符串末尾开始检查
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)!=' '){
                res++;
            }else if (res!=0){//遇到空格，并且已经有单词
                break;
            }
        }

        return res;
    }

    @Test
    public void mytest() {
        String s="a  aa  aaa";
        System.out.println("------");
        System.out.println(lengthOfLastWord(s));
        System.out.println("------");
    }
}