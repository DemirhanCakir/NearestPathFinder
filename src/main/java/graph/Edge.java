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


public class Edge {
    public final Node from;
    public final Node to;
    public final double weight;

    public Edge(Node from, Node to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}