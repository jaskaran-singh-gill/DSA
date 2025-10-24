
class Twitter {
    private static class Tweet {
        int id, time;
        Tweet next;
        Tweet(int id, int time) { this.id = id; this.time = time; }
    }

    private static int timestamp = 0;
    private final Map<Integer, Tweet> tweets;
    private final Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId, timestamp++);
        t.next = tweets.get(userId);
        tweets.put(userId, t);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (tweets.containsKey(userId)) pq.offer(tweets.get(userId));
        if (follows.containsKey(userId)) {
            for (int f : follows.get(userId)) {
                Tweet t = tweets.get(f);
                if (t != null) pq.offer(t);
            }
        }
        List<Integer> res = new ArrayList<>(10);
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet cur = pq.poll();
            res.add(cur.id);
            if (cur.next != null) pq.offer(cur.next);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = follows.get(followerId);
        if (set != null) set.remove(followeeId);
    }
}
