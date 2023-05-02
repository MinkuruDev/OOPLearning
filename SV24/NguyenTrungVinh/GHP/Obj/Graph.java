package SV24.NguyenTrungVinh.GHP.Obj;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> adjList;

    public Graph() {
        adjList = new ArrayList<>();
    }

    public void addVertex() {
        adjList.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}