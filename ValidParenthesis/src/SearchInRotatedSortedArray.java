import org.junit.Assert;

import static org.junit.Assert.*;

public class SearchInRotatedSortedArray {
  public static void main(String args[]){
       int nums[]={4,5,6,7,0,1,2};
       int target =0;
       int index = search ( nums,target );
       if (index!=4) {
           System.out.println ("Invalid index:"+index);
       }


  }


public static int  search(int[] nums, int target) {
        //Binary Search
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[low]) {
            if (target >= nums[low] && target <= nums[mid]) {
                high = mid - 1;
                System.out.println ("Indexof high:"+high);
            } else {
                low = mid + 1;
                System.out.println ("Index of low:"+low);

            }
        }
        else{
            if(target<=nums[high]&& target>nums[mid]){
                low = mid+1;
            }
            else high = mid-1;
        }

    }

    return -1;
}


}
