class Solution {
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if(A == null || A.length == 0){
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : A[0].toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i = 1; i < A.length; i++){
            map = helper(A[i], map);
        }
        for (Character key : map.keySet()){
            int value = map.get(key);
            for(int i = 0; i < value; i++){
                result.add(key+"");
            }
        }
        return result;
    }

    private static Map<Character, Integer> helper(String s, Map<Character, Integer> map) {
        Map<Character, Integer> current = new HashMap<>();
        for(char c : s.toCharArray()){
            current.put(c, current.getOrDefault(c,0) +1);
        }
        Map<Character, Integer> common = new HashMap<>();
        for(Character key : map.keySet()){
            if(current.containsKey(key)){
                common.put(key, Math.min(map.get(key), current.get(key)));
            }
        }
        return common;
    }
}