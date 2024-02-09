class Solution {
    private Map<Integer,Set<Integer>> map=new HashMap();
    private int[] max=new int[2];
    private Set<Integer> divisible(int index,int[] nums){
        if(index>=0&&!map.containsKey(nums[index])){
           Set<Integer> currSet=new HashSet<Integer>(); 
           int i=index-1;
           while(i>=0){
              Set<Integer> set=divisible(i,nums);
              if(nums[index]%nums[i]==0&&set.size()>currSet.size()){
                 currSet.clear();
                 currSet.addAll(set); 
              } 
              i--; 
           }//~   
           currSet.add(nums[index]); 
           int len=currSet.size(); 
           if(max[1]<len){
              max[1]=len;
              max[0]=nums[index]; 
           } 
           map.put(nums[index],currSet); 
        }//
        return map.get(nums[index]);
    }//~
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length<2) 
           return IntStream.of(nums).boxed().collect(Collectors.toList());
        Arrays.sort(nums);
        divisible(nums.length-1,nums);
        
        return new ArrayList<Integer>(map.get(max[0]));
    }
}