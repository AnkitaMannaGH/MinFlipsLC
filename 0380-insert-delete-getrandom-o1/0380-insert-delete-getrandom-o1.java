class RandomizedSet {

     /** Initialize your data structure here. */
    Set<Integer> set;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        set=new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean toReturn=set.contains(val);
        if(toReturn) set.remove(val);
      return toReturn;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        List<Integer> lst=new ArrayList<>(set);
          return lst.get(rand.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */