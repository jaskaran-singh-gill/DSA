
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        Map<String,List<Integer>> needMap=new HashMap<>(n*2);
        int[] need=new int[n];
        for(int i=0;i<n;i++){
            need[i]=ingredients.get(i).size();
            for(String ing:ingredients.get(i)){
                needMap.computeIfAbsent(ing,k->new ArrayList<>()).add(i);
            }
        }
        Set<String> have=new HashSet<>(Math.max(16, supplies.length*2));
        Deque<String> q=new ArrayDeque<>(supplies.length+n);
        for(String s:supplies){ if(have.add(s)) q.add(s); }
        List<String> ans=new ArrayList<>(n);
        Map<String,Integer> idx=new HashMap<>(n*2);
        for(int i=0;i<n;i++) idx.put(recipes[i],i);
        while(!q.isEmpty()){
            String cur=q.poll();
            List<Integer> list=needMap.get(cur);
            if(list==null) continue;
            for(int id:list){
                if(--need[id]==0){
                    String r=recipes[id];
                    ans.add(r);
                    if(have.add(r)) q.add(r);
                }
            }
        }
        return ans;
    }
}
