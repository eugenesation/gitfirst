package ua.com.nix.util;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Graph {

    private final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public WeightedMultigraph<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public void addVertex(String name){
        graph.addVertex(name);
    }

    public void addVertexWithWeight(String nameFrom, String nameTo, int weight){
        DefaultWeightedEdge e1 = graph.addEdge(nameFrom, nameTo);
        graph.setEdgeWeight(e1, weight);
    }

}
