package CCC_2018;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RoboGraph {

    ArrayList<ArrayList<RoboNode>> graph;
    ArrayList<RoboNode> queue;

    ArrayList<ArrayList<Integer>> cameras;

    public RoboGraph() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Data/CCC_2018/S3"));
        graph = new ArrayList<>();
        queue = new ArrayList<>();
        cameras = new ArrayList<>();
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < rows; i++) {
            var arr = new ArrayList<RoboNode>();
            var row = sc.nextLine().toCharArray();
            for (int j = 0; j < columns; j++) {
                if (row[j] == 'C') cameras.add(new ArrayList<>(Arrays.asList(i, j)));
                var node = new RoboNode(row[j]);
                arr.add(node);
                if (row[j] == 'S') queue.add(arr.get(j));
            }
            graph.add(arr);
        }

        blockWatchedSpots();

        for (int i = 1; i < rows-1; i++) {
            for (int j = 1; j < columns-1; j++) {
                RoboNode node = graph.get(i).get(j);
                char type = node.type;
                if (type != 'W') {
                    if ((type == '.' || type == 'S' || type == 'U') && !(graph.get(i-1).get(j).type == 'W' || graph.get(i-1).get(j).type == 'D' || graph.get(i-1).get(j).type == 'S')) {
                        node.up = graph.get(i-1).get(j);
                    }
                    if ((type == '.' || type == 'S' || type == 'D') && !(graph.get(i+1).get(j).type == 'W' || graph.get(i+1).get(j).type == 'U' || graph.get(i+1).get(j).type == 'S')) {
                        node.down = graph.get(i+1).get(j);
                    }
                    if ((type == '.' || type == 'S' || type == 'L') && !(graph.get(i).get(j-1).type == 'W' || graph.get(i).get(j-1).type == 'R' || graph.get(i).get(j-1).type == 'S')) {
                        node.left = graph.get(i).get(j-1);
                    }
                    if ((type == '.' || type == 'S' || type == 'R') && !(graph.get(i).get(j+1).type == 'W' || graph.get(i).get(j+1).type == 'L' || graph.get(i).get(j+1).type == 'S')) {
                        node.right = graph.get(i).get(j+1);
                    }
                }
            }
        }
        dijkstra();
        System.out.println(this);
        System.out.println(queue.size());
    }

    private void blockWatchedSpots() {
        var cameraHasVision = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> cam : cameras) {
            cameraHasVision.add(cam);
            int r = cam.get(0);
            int c = cam.get(1);
            for (var row = r + 1; graph.get(row).get(c).type != 'W'; ++row) {
                char ch = graph.get(row).get(c).type;
                if (ch == '.' || ch == 'S') cameraHasVision.add(new ArrayList<>(Arrays.asList(row, c)));
            }
            for (var row = r - 1; graph.get(row).get(c).type != 'W'; --row) {
                char ch = graph.get(row).get(c).type;
                if (ch == '.' || ch == 'S') cameraHasVision.add(new ArrayList<>(Arrays.asList(row, c)));
            }
            for (var column = c + 1; graph.get(r).get(column).type != 'W'; ++column) {
                char ch = graph.get(r).get(column).type;
                if (ch == '.' || ch == 'S') cameraHasVision.add(new ArrayList<>(Arrays.asList(r, column)));
            }
            for (var column = c - 1; graph.get(r).get(column).type != 'W'; --column) {
                char ch = graph.get(r).get(column).type;
                if (ch == '.' || ch == 'S') cameraHasVision.add(new ArrayList<>(Arrays.asList(r, column)));
            }
        }
        for (ArrayList<Integer> v : cameraHasVision) {
            graph.get(v.get(0)).set(v.get(1), new RoboNode('W'));
        }
    }

    public String toString() {
        String str = "";
        for (var arr : graph) {
            for (var node : arr) {
                str += node.toString() + ' ';
            }
            str += '\n';
        }
        return str;
    }


    private boolean allVisited() {
        for (var node : queue) {
            if (!node.visited) return false;
        }
        return true;
    }

    private void dijkstra() {
        while (queue.size() > 0 && !allVisited()) {
            RoboNode minValNode = new RoboNode('W');
            int index = 0;
            for (var i = 0; i < queue.size(); i++) {
                var node = queue.get(i);
                if (!node.visited && node.val < minValNode.val) {
                    minValNode = node;
                    index = i;
                }
            }



            queue.get(index).visited = true;

            if (minValNode.up != null && !minValNode.up.visited) {
                if (minValNode.up.type == '.') {
                    if (minValNode.up.val > minValNode.val) minValNode.up.val = minValNode.val + 1;
                } else {
                    if (minValNode.up.val > minValNode.val) minValNode.up.val = minValNode.val;
                }
                queue.add(minValNode.up);
            }
            if (minValNode.right != null && !minValNode.right.visited) {
                if (minValNode.right.type == '.') {
                    if (minValNode.right.val > minValNode.val) minValNode.right.val = minValNode.val + 1;
                } else {
                    if (minValNode.right.val > minValNode.val) minValNode.right.val = minValNode.val;
                }
                queue.add(minValNode.right);
            }
            if (minValNode.down != null && !minValNode.down.visited) {
                if (minValNode.down.type == '.') {
                    if (minValNode.down.val > minValNode.val) minValNode.down.val = minValNode.val + 1;
                } else {
                    if (minValNode.down.val > minValNode.val) minValNode.down.val = minValNode.val;
                }
                queue.add(minValNode.down);
            }
            if (minValNode.left != null && !minValNode.left.visited) {

                if (minValNode.left.type == '.') {
                    if (minValNode.left.val > minValNode.val) minValNode.left.val = minValNode.val + 1;
                } else {
                    if (minValNode.left.val > minValNode.val) minValNode.left.val = minValNode.val;
                }
                queue.add(minValNode.left);
            }
            queue.remove(index);


        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        var r = new RoboGraph();

    }

}
