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
import graph.Edge;


public class Dijkstra {
    public static List<Node> findShortestPath(Graph graph, Node start, Node target) {
        Map<Node, Double> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Node node : graph.getAllNodes()) {
            distances.put(node, Double.POSITIVE_INFINITY);
            previous.put(node, null);
        }
        distances.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(target)) {
                break;
            }

            for (Edge edge : current.edges) {
                Node neighbor = edge.to;
                double alt = distances.get(current) + edge.weight;
                if (alt < distances.get(neighbor)) {
                    distances.put(neighbor, alt);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<Node> path = new ArrayList<>();
        for (Node at = target; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static Node findNearestRestaurant(Graph graph, Node start) {
        Map<Node, Double> distances = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Node node : graph.getAllNodes()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.isRestaurant) {
                return current;
            }

            for (Edge edge : current.edges) {
                Node neighbor = edge.to;
                double alt = distances.get(current) + edge.weight;
                if (alt < distances.get(neighbor)) {
                    distances.put(neighbor, alt);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }
}