package graph;

import java.util.*;
import java.io.*;
import com.google.gson.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import graph.Node;
import graph.Edge;



public class Graph {
    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode(Node node) {
        nodes.put(node.id, node);
    }

    public void addEdge(String fromId, String toId, double weight) {
        Node from = nodes.get(fromId);
        Node to = nodes.get(toId);
        if (from != null && to != null) {
            Edge edge = new Edge(from, to, weight);
            from.edges.add(edge);
        }
    }

    public double calculatePathDistance(List<Node> path) {
        double total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Node from = path.get(i);
            Node to = path.get(i + 1);
            for (Edge edge : from.edges) {
                if (edge.to == to) {
                    total += edge.weight;
                    break;
                }
            }
        }
        return total;
    }


    public Collection<Node> getAllNodes() {
        return nodes.values();
    }

    public Node getNode(String id) {
        return nodes.get(id);
    }
}