package com.avminin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (node.neighbors == null || node.neighbors.isEmpty())
            return new Node(node.val);
        HashMap<Node, Node> used = new HashMap<>();
        return cloneNode(node, used);
    }

    private Node cloneNode(Node node, HashMap<Node, Node> used) {
        Node newNode = new Node(node.val);
        used.put(node, newNode);
        List<Node> neighbors = new ArrayList<>();
        for (Node neigh : node.neighbors) {
            if (used.containsKey(neigh)) {
                neighbors.add(used.get(neigh));
            } else {
                neighbors.add(cloneNode(neigh, used));
            }
        }
        newNode.neighbors = neighbors;
        return newNode;
    }

}
