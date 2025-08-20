class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        java.util.Deque<String> stack = new java.util.ArrayDeque<>();
        for (String dir : parts) {
            if (dir.isEmpty() || dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pollLast();
            } else {
                stack.addLast(dir);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) sb.append('/').append(dir);
        return sb.toString();
    }
}
