package treesandgraphs;

import stacksandqueues.datastructures.Stack;
import treesandgraphs.datastructures.Graph;
import treesandgraphs.datastructures.Project;

//Project: a, b, c, d, e, f
//Dependencies:
//a -> d
//b -> d
//f -> b, a
//d -> c
//e
//Project build order: f, e, a, b, d, c
//
//Ordering not possible if there are cycles
//
//Create an empty
//For every node in the graph
//  Execute DFS for the nodes in Unvisited state
//      If DFS detects a loop return null
//
//DFS (stack, node)
//If node is in Visiting state (meaning waiting for its children to be in Visited state) enters in DFS call stack
//  return false, this is an indication of cycle
//
//If node state is Unvisited
//  Set its state as Visiting
//  For each child, call DFS
//      If DFS detects loop return false
//  set node state as Visited
//  add node to stack
//
// Topological sort = O (N + E)
public class Example7_2 {
    private static Stack<Graph.Node<Project>> orderProjects(String[] projects, String[][] dependencies) {
        Graph<Project> projectGraph = buildProjectGraph(projects, dependencies);
        return orderProjects(projectGraph);
    }

    private static Stack<Graph.Node<Project>> orderProjects(Graph<Project> projectGraph) {
        Stack<Graph.Node<Project>> stack = new Stack<>(projectGraph.size());

        projectGraph.resetNodeState();
        for (int i = 0; i < projectGraph.size(); i++) {
            Graph.Node<Project> projectNode = projectGraph.get(i);
            if (projectNode.state == Graph.State.Unvisited) {
                if (!DFS(projectNode, stack)) {
                    return null;
                }
            }
        }

        return stack;
    }

    private static boolean DFS(Graph.Node<Project> projectNode, Stack<Graph.Node<Project>> stack) {
        if (projectNode.state == Graph.State.Visiting) {
            return false;
        }

        if (projectNode.state == Graph.State.Unvisited) {
            projectNode.state = Graph.State.Visiting;
            for (int i = 0; i < projectNode.adjacentNodes.size(); i++) {
                Graph.Node<Project> adjacentProjectNode = projectNode.adjacentNodes.get(i);
                if (adjacentProjectNode.state == Graph.State.Unvisited) {
                    if (!DFS(adjacentProjectNode, stack)) {
                        return false;
                    }
                }
            }
            projectNode.state = Graph.State.Visited;
            stack.push(projectNode);
        }

        return true;
    }

    private static Graph<Project> buildProjectGraph(String[] projects, String[][] dependencies) {
        Graph<Project> projectGraph = new Graph<>();
        for (String project : projects) {
            projectGraph.add(project, new Project(project));
        }

        for (String[] edge : dependencies) {
            projectGraph.addEdge(edge[0], edge[1]);
        }
        return projectGraph;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"b", "d"}, {"f", "b"}, {"f", "a"}, {"d", "c"}};
        Stack<Graph.Node<Project>> orderedProjects = orderProjects(projects, dependencies);

        System.out.println(orderedProjects);
    }
}
