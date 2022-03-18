package SortAndSearch;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,loc=0;
        int[] copyNums= new int[m+1];
        if (m>0){
            while (i<m){
                copyNums[i]=nums1[i++];
            }
        }

        //处理数据
        i=0;
        while(i<m && j<n){
            if (copyNums[i]<nums2[j]){
                nums1[loc++] = copyNums[i++];
            }else{
                nums1[loc++] = nums2[j++];
            }
        }
        while(i<m){
            nums1[loc++]=copyNums[i++];
        }
        while(j<n){
            nums1[loc++]=nums2[j++];
        }
    }
}
