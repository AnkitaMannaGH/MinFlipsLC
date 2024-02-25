class Solution {
    private Map<Integer, Integer> divisors;
    private DisjointSet[] sets;

    public boolean canTraverseAllPairs(int[] nums) {
        divisors = new HashMap<>();
        int l = nums.length;

        sets = new DisjointSet[l];
        for (int index = 0; index < l; index++) {
            sets[index] = new DisjointSet();
            DisjointSet current = sets[index];
            int n = nums[index];
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    link(current,i);
                    link(current, n/i);
                }
            }
            addDivisors(nums[index], index);
        }

        Set<DisjointSet> totalSets = new HashSet<>();

        for (DisjointSet set : sets) {
            totalSets.add(set.findSet());
        }

        return totalSets.size() == 1;

    }

    void link(DisjointSet current, int divisor) {
        Integer other = divisors.get(divisor);
         if(other != null)   DisjointSet.union(current, sets[other]);

    }

    void addDivisors(int n, int index) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                add(i, index);
                add(n / i, index);
            }
        }

        if(n != 1)add(n, index);
    }

    private void add(int divisor, int index) {
        divisors.put(divisor, index);
    }

    private static class DisjointSet {
        int rank = 0;
        DisjointSet p = this;

        private static void link(DisjointSet x, DisjointSet y) {
            if (x.rank > y.rank) {
                y.p = x;
            } else {
                x.p = y;
                if (x.rank == y.rank) y.rank++;
            }
        }

        public static void union(DisjointSet x, DisjointSet y) {
            link(x.findSet(), y.findSet());
        }

        public DisjointSet findSet() {
            if (this.p != this) this.p = this.p.findSet();
            return this.p;
        }

        public boolean sameSet(DisjointSet other) {
            return findSet() == other.findSet();
        }
    }
}