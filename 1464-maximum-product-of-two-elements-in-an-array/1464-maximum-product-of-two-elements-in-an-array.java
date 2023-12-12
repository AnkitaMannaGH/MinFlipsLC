class Solution {
    public int maxProduct(int[] nums) {
        int max=(nums[0]-1)*(nums[1]-1);
        int n =nums.length;
        for(int i=0;i<n;i++)
       {
        for(int j=0;j<n&&j!=i;j++)
        {
         int nex =(nums[i]-1)*(nums[j]-1);
            if(nex>max)
            {
                max=nex;
            }
        }
     }
     return max;
    }
}