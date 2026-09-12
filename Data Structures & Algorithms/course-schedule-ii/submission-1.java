class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0;i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

            for (int nei: graph.get(node)) {
                if(--indegree[nei] == 0) q.offer(nei);
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}
