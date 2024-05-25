class Solution {
    List<String> fin = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        
        wordbreak2(s,new ArrayList<>(),set);
        return fin;
    }
    
    public void wordbreak2(String s,ArrayList<String> list,HashSet<String> set){
        if(s.length()==0){
            String str = "";
            for(int i=0;i<list.size();i++){
                str+=list.get(i);
                if(i!=list.size()-1){
                    str+=" ";
                }
            }
            fin.add(str);
            return;
        }
        for(int i=0;i<s.length();i++){
            String prefix = s.substring(0,i+1);
            String suffix = s.substring(i+1);
            if(set.contains(prefix)){
                list.add(prefix);
                wordbreak2(suffix,list,set);
                list.remove(list.size()-1);
            }
        }
    }
}