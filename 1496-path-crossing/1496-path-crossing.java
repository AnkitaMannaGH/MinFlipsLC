class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set=new HashSet<>();
        set.add("0,0");
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            switch(path.charAt(i)){
                case 'N':{
                    y++;
                    break;
                }
                case 'S':{
                    y--;
                    break;
                }
                case 'W':{
                    x--;
                    break;
                }
                case 'E':{
                    x++;
                }
            }
            String temp=x+","+y;
            if(set.contains(temp))
                return true;
            set.add(temp);
                
        }
        return false; 
    }
}