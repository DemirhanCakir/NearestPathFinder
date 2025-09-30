## Description

NearestPathFinder is a JavaFX desktop application that visualizes a graph-based map and helps users find the shortest path to the nearest restaurant node. The project loads a map from a JSON file, displays it with interactive nodes and edges, and allows users to select any location to automatically calculate and display the optimal route to the closest restaurant.

This application is ideal for learning about graph algorithms, pathfinding (Dijkstra's algorithm), and interactive map interfaces in Java.

## Features

- **Interactive Map Visualization:** Displays a city map (e.g., Istanbul) with nodes and edges.
- **Graph-based Pathfinding:** Uses Dijkstra's algorithm to find the shortest path.
- **Nearest Restaurant Finder:** Click any node to automatically locate and trace the path to the nearest restaurant.
- **Visual Feedback:** Highlights selected nodes, nearest restaurants, and the computed path.
- **Edge Visibility Control:** Buttons to show/hide all edges for clearer visualization.

## How It Works

- The map and graph structure are loaded from a `map.json` file (nodes and edges).
- Each node can represent a location; some are flagged as restaurants.
- When you click on a node, the app computes the shortest path to the nearest restaurant and draws it.
- Restaurants are marked in red; other locations in blue.

## Getting Started

### Prerequisites

- Java 8 or above
- JavaFX libraries
- Gson library for JSON parsing

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DemirhanCakir/NearestPathFinder.git
   ```

2. Make sure `map.json` and `istanbul.png` (background image) are present in your resources.

3. Build and run the project using your preferred IDE or command line.

### Usage

- Launch the application.
- Click on any node (location) on the map.
- The app will display:
  - The selected node
  - The nearest restaurant
  - The shortest path highlighted in green
  - The total distance of the path

## File Structure

- `src/main/java/graph/`: Graph, Node, Edge, Dijkstra algorithm, MapLoader
- `src/main/java/ui/`: Main app entry (`Main.java`), map visualization (`MapCanvas.java`)
- `resources/`: `map.json` (map data), `istanbul.png` (background image)

## Technologies

- **Java**
- **JavaFX**
- **Gson** (for JSON parsing)

## Credits

Developed by [DemirhanCakir](https://github.com/DemirhanCakir)

## License

MIT License (see LICENSE file)

---

**Showcase:**  
![App Screenshot](istanbul.png)
