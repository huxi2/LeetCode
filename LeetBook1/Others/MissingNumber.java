package Others;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        // int res = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(res == nums[i]){
        //         res++;
        //     }else{
        //         break;
        //     }
        // }
        // return res;
        boolean[] flag = new boolean[nums.length + 1];
        int i = 0;
        for (; i < nums.length; i++) {
            flag[nums[i]] = true;
        }
        i = 0;
        while (flag[i]) i++;
        return i;
    }
}
