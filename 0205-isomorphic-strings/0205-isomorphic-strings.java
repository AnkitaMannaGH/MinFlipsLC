class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {

            int src=s.charAt(i);
            int trgt=t.charAt(i);
            if(map.containsKey(Integer.valueOf(src)) && map.get(Integer.valueOf(src))==Integer.valueOf(trgt))
                continue;
            else if(!map.containsKey(Integer.valueOf(src)) &&!map.containsValue(Integer.valueOf(trgt)) )
                map.put(Integer.valueOf(src),
                        Integer.valueOf(trgt));
            else 
                return false;
            
        }
        
        return true;
    }
}