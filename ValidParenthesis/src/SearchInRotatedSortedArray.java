import org.junit.Test;

public class SearchInRotatedSortedArray {
    public static void main(String args[]){
        int nums[]={4,5,6,7,0,1,2};
        search(nums,0);
    }
@Test
public static int  search(int[] nums, int target) {
        //Binary Search
        int low=0,high= nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target) return mid;
            //to check if the mid value lies in which sorted array
            //current pointer is in First or second sorted array
           else if(nums[mid]>nums[low]){  //In first sorted array
                //Check if the target is between nums[low} and nums[mid]
                if(target>=nums[low]&& target<=nums[mid]) high = mid-1;
                    else low = mid+1;
                //else the target is in second sorted array
                if(target<=nums[high]&& target>nums[mid] ) high=mid-1;
                else low = mid+1;

            }



        }
        return -1;
    }
}
