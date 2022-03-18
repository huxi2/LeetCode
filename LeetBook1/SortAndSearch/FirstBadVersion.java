package SortAndSearch;


import org.junit.Test;

public class FirstBadVersion {

    public boolean isBadVersion(int n) {
        return n >= 1702766719;
    }

    public int firstBadVersion(int n) {
        long low = 1, heigh = n;
        System.out.println(Integer.MAX_VALUE);

        while (low < heigh) {
            long mid = (low + heigh) / 2;
            if (isBadVersion((int)mid)) {//中间出错,第一次错误在左边
                heigh = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (isBadVersion((int)heigh)) return (int)heigh;
        return (int)heigh + 1;
    }

    public int firstBadVersion2(int n) {
        int low = 1, heigh = n;
        System.out.println(Integer.MAX_VALUE);

        while (low < heigh) {
            int mid = low + (heigh-low) / 2;
            if (isBadVersion(mid)) {//中间出错,第一次错误在左边
                heigh = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    @Test
    public void mytest() {
        System.out.println(firstBadVersion(2126753390));
    }
}
