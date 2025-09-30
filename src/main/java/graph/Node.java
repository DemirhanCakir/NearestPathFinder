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


public class Node {
    public final String id;
    public final double x, y;
    public final boolean isRestaurant;
    public List<Edge> edges = new ArrayList<>();

    public Node(String id, double x, double y, boolean isRestaurant) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.isRestaurant = isRestaurant;
    }

    @Override
    public String toString() {
        return id;
    }
}
