public class BinarySerach {
public static void main(String args[]){
   int nums[] = {2,4,5,5,5,5,5,6,6};
   search(nums , 5);
}

    private static int search(int nums[], int target) {
    int cnt=0;
    int low=0,high = nums.length-1;
    int len = nums.length/2;
   while(low<high){
       int mid = low + (high-low)/2;
       if(nums[mid]==mid) return mid;
       else if (nums[mid]>mid) return low=mid+1;
       else return high=mid-1;

   }

        return low;
    }

}

