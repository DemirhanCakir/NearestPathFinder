package ui;

import graph.Graph;
import graph.MapLoader;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.MapCanvas;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Graph graph = MapLoader.loadGraphFromJson();
        MapCanvas canvas = new MapCanvas(graph);

        Button hideEdgesButton = new Button("Hide Edges");
        Button showEdgesButton = new Button("Show Edges");

        hideEdgesButton.setOnAction(e -> canvas.toggleEdges(false));
        showEdgesButton.setOnAction(e -> canvas.toggleEdges(true));

        HBox buttonBar = new HBox(10, hideEdgesButton, showEdgesButton);

        BorderPane root = new BorderPane();
        root.setTop(buttonBar);
        root.setCenter(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("En Yakın Restoran Bulucu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}