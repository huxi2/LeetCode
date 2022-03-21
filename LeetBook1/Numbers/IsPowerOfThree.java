package Numbers;

public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        int res = 0;
        //当n>3时弱不是3的幂次res就可过滤掉  n=4 ->  res=1,n=1  跳出循环
        while (n != 0 && res == 0) {
            res = n % 3;
            n /= 3;
        }
        return n == 0 && res == 1;
    }
}
