public class MergeSort {
    public static void main(String args[]){
        int nums1[]={1,2,3};
        int nums2[]={4,5,6};
        int nums[] = new int[6];
        System.arraycopy ( nums1,0,nums,0,3 );
        System.arraycopy ( nums2,0,nums,3,3 );
        for(int i=0;i<6;i++){
            System.out.println (nums[i]);
        }
       // merge(nums);
    }

    private static void merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int nums1_copy[]= new int[m+n];

        int p1 =m-1;
        int p2 =n-1;
        int p = m+n-1;
        while((p1>=0)&&(p2>=0)){
            if(nums1[p1]>nums1[p2]) {
                nums1_copy[p--]=nums1[p1];
                p1--;
            }
            else {
                nums1_copy[p--]=nums2[p2];
                p2--;

            }
          //  System.arraycopy ( nums2,0,nums1_copy,0,p2+1 );
                for (int i=0;i< nums1_copy.length;i++){
                    System.out.println (nums1_copy[i]+" ");
                }
        }
    }
}
