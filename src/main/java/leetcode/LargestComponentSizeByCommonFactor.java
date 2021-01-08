package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*  952. Largest Component Size by Common Factor    */

/*  https://leetcode.com/problems/largest-component-size-by-common-factor/  */

/*
*
* Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.



Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

*
* */

public class LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {

        Map<Integer,Integer> map = new HashMap<>();

        int max = Arrays.stream(A).max().getAsInt();

        UF uf = new UF(max);

        for(int a:A) {
            for(int num=2;num<=Math.sqrt(a);num++) {

                if(a%num==0) {
                    uf.union(a,num);
                    uf.union(a,a/num);
                }

            }
        }

        int ans = 0;

        for(int a: A) {
            int m = uf.find(a);
            if(map.containsKey(m)) {
                map.put(m,map.get(m)+1);
            } else {
                map.put(m,1);
            }

            ans = Math.max(ans,map.get(m));
        }

        return ans;
    }
}


class UF {
    int parent[];
    int rank[];

    UF(int max) {
        this.parent = new int[max+1];
        this.rank = new int[max+1];

        for(int i=0;i<=max;i++) {
            parent[i] = i;
        }
    }

    public void union(int u,int v) {

        int pau = find(u);
        int pav = find(v);

        if(pau==pav) {
            return;
        }

        if(rank[pau]<rank[pav]) {
            parent[pau]= pav;
        } else if(rank[pau]>rank[pav]) {
            parent[pav]= pau;
        } else {
            parent[pau] = pav;
            rank[pav]++;
        }

    }


    public int find(int u) {
        while(u!=parent[u]) {
            parent[u]= parent[parent[u]];
            u= parent[u];
        }

        return u;
    }
}
