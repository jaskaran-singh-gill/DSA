

class TaskManager {
    static final class Node {
        int p,id;
        Node(int p,int id){this.p=p;this.id=id;}
    }
    int[] user,prio;
    boolean[] alive;
    PriorityQueue<Node> pq;
    public TaskManager(List<List<Integer>> tasks) {
        int maxId = 100000 + 5;
        user = new int[maxId];
        prio = new int[maxId];
        alive = new boolean[maxId];
        pq = new PriorityQueue<>((a,b)->{
            int c = Integer.compare(b.p,a.p);
            return c!=0? c : Integer.compare(b.id,a.id);
        });
        for (List<Integer> t: tasks) add(t.get(0), t.get(1), t.get(2));
    }
    public void add(int userId, int taskId, int priority) {
        user[taskId]=userId;
        prio[taskId]=priority;
        alive[taskId]=true;
        pq.add(new Node(priority,taskId));
    }
    public void edit(int taskId, int newPriority) {
        prio[taskId]=newPriority;
        pq.add(new Node(newPriority,taskId));
    }
    public void rmv(int taskId) {
        alive[taskId]=false;
    }
    public int execTop() {
        while(!pq.isEmpty()){
            Node x=pq.peek();
            int id=x.id;
            if(!alive[id] || prio[id]!=x.p){ pq.poll(); continue; }
            pq.poll();
            alive[id]=false;
            return user[id];
        }
        return -1;
    }
}
