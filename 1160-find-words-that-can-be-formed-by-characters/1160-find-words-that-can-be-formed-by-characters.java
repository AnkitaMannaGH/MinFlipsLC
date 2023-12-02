class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> map = new HashMap();
        int sum =0;
        boolean flag=true;
        for(char letter:chars.toCharArray()){
            map.put(letter, map.getOrDefault(letter, 0)+1);
        }
        for(String word:words){
            flag = true;
            HashMap<Character,Integer> mapcopy = new HashMap(map);
            for(char Character : word.toCharArray()){
                if(mapcopy.containsKey(Character) && mapcopy.get(Character)!=0){
                    mapcopy.put(Character, mapcopy.get(Character)-1);
                }else{
                    flag = false;
                    break;
                }   
            }
            if(flag){
                sum += word.length(); 
            }
        }
        return sum;
    }
}