import org.junit.Test;

public class LeetCode0035 {

    public int searchInsert(int[] nums, int target) {
        // 二分查找。时间复杂度为O(logn) 实现有序数组的定位或者插入的位置
        int low=0,high=nums.length-1;
        while(low<=high){//小于等于。才能访问到数组两端的值。小于号无法访问到尾结点，仅访问首
            int mid = (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return low;//返回low
    }

    @Test
    public void mytest() {
        int[] nums={1,3,5,6};
        for(int i=-1;i<8;i++){
            int target=i;
            System.out.println(target+": "+searchInsert(nums,target));
        }
    }
}