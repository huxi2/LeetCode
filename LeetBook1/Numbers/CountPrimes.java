package Numbers;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        //存储i是否是质数，true不是，false是
        boolean[] flag = new boolean[n + 1];
        flag[0] = true;
        flag[1] = true;

        int i = 2, res = 0;
        while (i < n) {
            if (!flag[i]) {//i为质数
                res++;
                for (int j = i * 2; j < n; ) {
                    if (!flag[j]) flag[j] = true;
                    j += i;
                }
            }
            i++;
        }
        return res;
    }
}
