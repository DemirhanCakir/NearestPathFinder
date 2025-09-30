package graph;

import java.io.*;
import com.google.gson.*;


public class MapLoader {
    static class MapData {
        NodeData[] nodes;
        EdgeData[] edges;
    }

    static class NodeData {
        String id;
        double x;
        double y;
        boolean isRestaurant;
    }

    static class EdgeData {
        String from;
        String to;
        double weight;
    }

    public static Graph loadGraphFromJson() throws IOException {
        InputStream is = MapLoader.class.getResourceAsStream("/map.json");
        Reader reader = new InputStreamReader(is);
        Gson gson = new Gson();
        MapData data = gson.fromJson(reader, MapData.class);

        Graph graph = new Graph();
        for (NodeData n : data.nodes) {
            graph.addNode(new Node(n.id, n.x, n.y, n.isRestaurant));
        }
        for (EdgeData e : data.edges) {
            graph.addEdge(e.from, e.to, e.weight);
        }
        return graph;
    }
}
