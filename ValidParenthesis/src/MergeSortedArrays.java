public class MergeSortedArrays {
    public static void main(String args[]){
        int nums1[] ={1,2,3};

        int nums2[] = {4,5,6,7};

        merge(nums1,nums2);

    }

    private static void merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int nums[] = new int[m+n];

        System.arraycopy ( nums1,0,nums,0,m );
        System.arraycopy ( nums2,0,nums,m,n);
        for(int i=0;i<m+n;i++){
            System.out.println(nums[i]);
        }

    }
}
