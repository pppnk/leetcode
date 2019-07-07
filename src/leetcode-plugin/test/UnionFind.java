/*
Source: https://leetcode.com/discuss/interview-question/264639/Facebook-phone-interview
Question 2: We are given a list of pairs. A pair a,b means there is directed edge from a to b. We are also guaranteed there are no cycles in this graph. Given two nodes X and Y, return if they have common ancestor.

[[5,6],[2,3],[2,4],[1,2]]

    1
    |
    2      5
   / \     ^
  3  4     6
X=3 Y=4 Yes
X=4 Y=6 No
X=5 Y=6 Yes

Theory about this algo: https://www.geeksforgeeks.org/union-find/
*/

import java.util.Arrays;

//V is vertices in graph, E is edges in graph
//Time O(EV) for creating parent array, once created HasCommonAncestor takes O(V)
//Space O(V) for parent array
public class UnionFind {
    private int[] _parent;
    private int[] _rank;

    public int find(int i) {
        int p = _parent[i];
        if (i == p) {
            return i;
        }
        return _parent[i] = find(p);
    }

    public void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root2 == root1)
            return;
        if (_rank[root1] > _rank[root2]) {
            _parent[root2] = root1;
        } else if (_rank[root2] > _rank[root1]) {
            _parent[root1] = root2;
        } else {
            _parent[root2] = root1;
            _rank[root1]++;
        }
    }

    private boolean hasCommonAncestor(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        return root2 == root1;
    }


    public UnionFind(int max) {
        _parent = new int[max];
        _rank = new int[max];
        for (int i = 0; i < max; i++) {
            _parent[i] = i;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
            {5,6},
            {2,3},
            {2,4},
            {1,2}
        };
        //Maximum node value
        int maximumValue = -1;
        for(int i = 0; i < edges.length; i++){
            maximumValue = Math.max(maximumValue, Math.max(edges[i][0], edges[i][1]));
        }
        UnionFind uf = new UnionFind(maximumValue + 1);
        for(int i = 0; i < edges.length; i++){
            uf.union(edges[i][0], edges[i][1]);
        }
        test(uf, 3, 4, true);
        test(uf, 4, 6, false);
        test(uf, 5, 6, true);
    }

    private static void test(UnionFind graph, int node1, int node2, boolean expected) {
        boolean actual = graph.hasCommonAncestor(node1, node2);
        System.out.println(actual == expected? "Passed": "Failed");
    }
}