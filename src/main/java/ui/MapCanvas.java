package ui;

import graph.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.List;

public class MapCanvas extends Canvas {
    private final Graph graph;
    private Node selectedNode = null;
    private final Image background = new Image("istanbul.png");
    private Node lastNearest = null;
    private List<Node> lastPath = null;
    private boolean showAllEdges = true;

    public MapCanvas(Graph graph) {
        super(800, 700);
        this.graph = graph;
        setFocusTraversable(true);
        setMouseTransparent(false);
        draw();

        this.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked at: " + e.getX() + ", " + e.getY());
            for (Node node : graph.getAllNodes()) {
                double dx = e.getX() - node.x;
                double dy = e.getY() - node.y;
                if (Math.hypot(dx, dy) <= 12) {
                    selectedNode = node;
                    lastNearest = Dijkstra.findNearestRestaurant(graph, selectedNode);
                    if (lastNearest != null) {
                        lastPath = Dijkstra.findShortestPath(graph, selectedNode, lastNearest);
                    } else {
                        lastPath = null;
                    }
                    draw();
                    return;
                }
            }
        });
    }

    public void toggleEdges(boolean show) {
        this.showAllEdges = show;
        draw();
    }

    private void draw() {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.drawImage(background, 0, 0, getWidth(), getHeight());

        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 20));
        gc.fillText("Nearest Restaurant Finder", 300, 30);

        if (selectedNode != null) {
            gc.fillText("Selected: " + selectedNode.id, 600, 600);
        }
        if (lastNearest != null) {
            gc.fillText("Nearest: " + lastNearest.id, 600, 630);
        }
        if (lastPath != null) {
            double distance = graph.calculatePathDistance(lastPath);
            gc.fillText("Distance: " + String.format("%.2f", distance), 600, 660);
        }

        if (showAllEdges) {
            gc.setStroke(Color.GRAY);
            for (Node node : graph.getAllNodes()) {
                for (Edge edge : node.edges) {
                    gc.strokeLine(node.x, node.y, edge.to.x, edge.to.y);
                }
            }
        }

        if (lastPath != null) drawPath(lastPath);

        for (Node node : graph.getAllNodes()) {
            gc.setFill(node.isRestaurant ? Color.RED : Color.BLUE);
            gc.fillOval(node.x - 5, node.y - 5, 10, 10);
        }
    }

    private void drawPath(List<Node> path) {
        if (path.size() < 2) return;
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(3);
        for (int i = 0; i < path.size() - 1; i++) {
            Node from = path.get(i);
            Node to = path.get(i + 1);
            gc.strokeLine(from.x, from.y, to.x, to.y);
        }
    }
}
