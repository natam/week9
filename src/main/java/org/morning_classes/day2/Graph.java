package org.morning_classes.day2;

import java.util.*;

public class Graph {
    private Map<Person, List<Person>> adjList;
    public Graph(){
        adjList = new HashMap<>();
    }

    public void addVertex(String name, int age){
        adjList.putIfAbsent(new Person(name,age), new ArrayList<>());
    }

    public void addVertex(Person person){
        adjList.putIfAbsent(person, new ArrayList<>());
    }

    public void addEdge(Person person1, Person person2){
        if(!adjList.containsKey(person1)){
            addVertex(person1);
        }
        if(!adjList.containsKey(person2)){
            addVertex(person2);
        }
        adjList.get(person1).add(person2);
        adjList.get(person2).add(person1);
    }

    public List<Person> getNeighbors(Person person){
        return adjList.get(person);
    }

    public void dfs(Person startVertex, Set<Person> visitedV){
        if(!visitedV.contains(startVertex)){
            System.out.println("Vertex: " + startVertex.getName());
            visitedV.add(startVertex);
            List<Person> neighbors = getNeighbors(startVertex);
            //neighbors.forEach(person -> System.out.println(person.getName()));
            for (Person person:neighbors){
                dfs(person, visitedV);
            }
        }
    }

    public void bfs(Person startVertex, String searchPersonName){
        Set<Person> visitedVertexes = new HashSet<>();
        Queue<Person> vertexesToProcess = new ArrayDeque<>();
        vertexesToProcess.add(startVertex);
        Person currentVertex;
        while (!vertexesToProcess.isEmpty()){
            currentVertex = vertexesToProcess.remove();
            System.out.println(currentVertex.getName());
            if(currentVertex.getName().equals(searchPersonName)){
                System.out.println("FOUND: " + currentVertex.getName() + " - " + currentVertex.getAge());
                return;
            }else {
                visitedVertexes.add(currentVertex);
                vertexesToProcess.addAll(getNeighbors(currentVertex));
                vertexesToProcess.removeAll(visitedVertexes);
            }
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("Natallia", 36);
        Person person2 = new Person("Nina", 26);
        Person person3 = new Person("Tom", 41);
        Person person4 = new Person("Jane", 15);
        Graph myGraph = new Graph();
        myGraph.addEdge(person1,person2);
        myGraph.addEdge(person1,person4);
        myGraph.addEdge(person3, person4);
        myGraph.addEdge(person2,person3);
        myGraph.dfs(person1, new HashSet<>());
        myGraph.bfs(person1, "Jane");
    }
}
