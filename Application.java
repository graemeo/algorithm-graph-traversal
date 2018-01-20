import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Application
{
    /*
    Graph (Undirected)
    0 -> 1, 2
    1 -> 0, 2, 6
    2 -> 0, 1, 3, 4
    3 -> 2, 5, 6
    4 -> 2, 5
    5 -> 3, 4
    6 -> 1, 3
    
    0 -- 1 -- 6   
     \   |    |
      -- 2 -- 3 -- 5
          \       /
           -- 4 --
    
    */

    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = getAdjacencyList();
        printAdjacencyList(adjacencyList);

        // BFS
        breadthFirstSearch(adjacencyList, 3);
         
        
    }

    public static void breadthFirstSearch(List<List<Integer>> adjacencyList, int number) {
        int steps = 0;
        boolean[] explored = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        explored[0] = true;

        while(!queue.isEmpty()) {
            steps++;
            Integer vertex = queue.remove();

            if (vertex == number) {
                System.out.println("FOUND! Number of steps: " + steps);
                break;
            }

            for(Integer v : adjacencyList.get(vertex)) {
                if (!explored[v]) {
                    queue.add(v);
                }
                explored[v] = true;
            }
        }
    }
    
    public static  List<List<Integer>> getAdjacencyList() {
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
        adjacencyList.add(Arrays.asList(1,2));
        adjacencyList.add(Arrays.asList(0, 2, 6));
        adjacencyList.add(Arrays.asList(0, 1, 3, 4));
        adjacencyList.add(Arrays.asList(2, 5, 6));
        adjacencyList.add(Arrays.asList(2, 5));
        adjacencyList.add(Arrays.asList(3, 4));
        adjacencyList.add(Arrays.asList(1, 3));

        return adjacencyList;
    }

    public static void printAdjacencyList(List<List<Integer>> adjacencyList) {
        int index = 0;

        for(List<Integer> adjacency : adjacencyList) {
            System.out.print(index + " -> ");
            for(Integer vertex : adjacency) {
                System.out.print(vertex + " ");
            }
            System.out.println("");
            index++;
        }

    }

}
