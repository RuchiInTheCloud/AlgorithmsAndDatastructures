package treesandgraphs;

import arraysandstrings.datastructures.ArrayList;
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
//
public class Example7_1 {
    private static Graph.Node<Project>[] orderProjects(String[] projects, String[][] dependencies) {
        Graph<Project> projectGraph = buildProjectGraph(projects, dependencies);
        return orderProjects(projectGraph);
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

    private static Graph.Node<Project>[] orderProjects(Graph<Project> projectGraph) {
        Graph.Node<Project>[] orderedProjects = new Graph.Node[projectGraph.size()];

        int endOfList = addNonDependent(orderedProjects, projectGraph.nodes, 0);
        int toBeProcessedIndex = 0;

        while (toBeProcessedIndex < orderedProjects.length) {
            Graph.Node<Project> projectNode = orderedProjects[toBeProcessedIndex];
            if (projectNode == null) {
                return null;
            }
            ArrayList<Graph.Node<Project>> projectDependents = projectNode.adjacentNodes;
            for (int i = 0; i < projectDependents.size(); i++) {
                projectDependents.get(i).decrementDependencies();
            }
            endOfList = addNonDependent(orderedProjects, projectDependents, endOfList);
            toBeProcessedIndex++;
        }

        return orderedProjects;
    }

    private static int addNonDependent(Graph.Node<Project>[] orderedProjects, ArrayList<Graph.Node<Project>> nodes, int index) {
        for (int i = 0; i < nodes.size(); i++) {
            Graph.Node<Project> projectNode = nodes.get(i);
            if (projectNode.getDependencies() == 0) {
                orderedProjects[index++] = projectNode;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"},{"b", "d"}, {"f", "b"}, {"f", "a"}, {"d", "c"}};
        Graph.Node<Project>[] orderedProjects = orderProjects(projects, dependencies);

        for (Graph.Node<Project> orderedProjectNode : orderedProjects) {
            System.out.println(orderedProjectNode.data);
        }
    }
}
