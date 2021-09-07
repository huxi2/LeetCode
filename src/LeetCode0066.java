import org.junit.Test;

public class LeetCode0066 {
    /**
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。实现加1
     */
    public int[] plusOne(int[] digits) {
        int flag = 1;
        //直接对digit进行+1操作，若最后有进位则flag==1.否则为0
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + flag;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
        }
        //通过flag判断，是否最后有进位，创建新数组。
        int[] result=new int[digits.length+flag];
        //若有进位，则设置进位1，此时flag=1。然后复制digits。否则flag=0，result[0]会被digits[0]替换
        result[0]=1;
        for (int i=0;i<digits.length;i++){
            result[flag++]=digits[i];
        }
        return result;
    }

    @Test
    public void mytest() {
        int[] digits = {0};
        int[] res=plusOne(digits);
        for (int it:res){
            System.out.print(it+" ");
        }
    }
}