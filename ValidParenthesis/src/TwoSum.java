import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        int nums[]={2,7,11,15};
        sumIsEqualTarget(nums,11);
    }

    private static int[] sumIsEqualTarget(int[] nums, int target)  {
        Map<Integer, Integer> map = new HashMap<> ();
        for(int i=0;i<nums.length;i++){
            int comp = target-nums[i];
            if(map.containsKey ( comp )){
                return new int[] {map.get ( comp ),i};
            }
            map.put ( nums[i],i );
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
