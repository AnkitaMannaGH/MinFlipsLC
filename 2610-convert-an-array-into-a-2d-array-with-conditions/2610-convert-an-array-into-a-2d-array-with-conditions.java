class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>hash=new HashMap<Integer,Integer>();
        for(int x:nums)
        {
            if(hash.containsKey(x))
            {
                hash.put(x,hash.get(x)+1);
            }
            else
            {
                hash.put(x,1);
            }
        }  
        List<List<Integer>> ans=new ArrayList<>();
        while(!hash.isEmpty())
        {
            List<Integer>row=new ArrayList<>();
            Iterator<Map.Entry<Integer,Integer>> itr=hash.entrySet().iterator();
            while(itr.hasNext())
            {
                 Map.Entry<Integer,Integer> entry = itr.next();
                 Integer key = entry.getKey();
                 Integer value = entry.getValue();
                if(value==0)
                {
                    itr.remove();
                }
                else
                {
                    row.add(key);
                    value--;
                    hash.put(key,value);
                }
            }
            if(row.size()>0)
                ans.add(row);
        }
        return ans;
    }
}