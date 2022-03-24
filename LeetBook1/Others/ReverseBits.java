package Others;

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //空出新的1位
            res = res << 1;
            //用n的最后1位填充res
            res += (n >>> i) & 1;
        }
        return res;
    }
}
