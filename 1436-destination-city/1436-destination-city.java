class Solution {
    public String destCity(List<List<String>> paths) {
       HashSet<String> hash = new HashSet<String>();
       for(List p : paths) hash.add((String)p.get(0));
       for(List p : paths) if(!hash.contains((String)p.get(1))) return (String)p.get(1);  
       return ""; 
    }
}