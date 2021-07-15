package ua.com.nix.util;

import org.jgrapht.alg.shortestpath.ALTAdmissibleHeuristic;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class MinPath {

    public double getShortestPath(Graph graph, String source, String dest){
        AStarShortestPath<String, DefaultWeightedEdge> aStarShortestPath = new AStarShortestPath<>(graph.getGraph(),
                new ALTAdmissibleHeuristic<>(graph.getGraph(), graph.getGraph().vertexSet()));

        return aStarShortestPath.getPathWeight(source,dest);
    }

}
