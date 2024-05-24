class Solution {
    private int checkValidAndGetScore(String str, HashMap<Character, Integer> charSet, int[] score) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c: str.toCharArray()) {
            charCount.merge(c, 1, Integer::sum);
        }
        int tempScore = 0;
        for (char c: charCount.keySet()) {
            if (!charSet.containsKey(c) || charCount.get(c) > charSet.get(c)) {
                return -1;
            }
            tempScore += score[c - 'a'] * charCount.get(c);
        }

        return tempScore;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int ret = 0;
        HashMap<Character, Integer> charSet = new HashMap<>();
        for (char letter: letters) {
            charSet.merge(letter, 1, Integer::sum);
        }
        HashSet<String> record = new HashSet<>();
        record.add("");
        for (String word: words) {
            HashSet<String> newAdd = new HashSet<>();
            for (String item: record) {
                String temp = item + word;
                int check = checkValidAndGetScore(temp, charSet, score);
                if (check != -1) {
                    newAdd.add(temp);
                    ret = Math.max(ret, check);
                }
            }
            record.addAll(newAdd);
        }

        return ret;
    }
}