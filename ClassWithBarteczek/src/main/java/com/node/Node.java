package com.node;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private Node parent;
    private String name;

    public Node (String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    public static Node firstCommonAncestor(Node a, Node b) {
        if (a.parent == null || b.parent == null) {
            return null;
        }
        if (a.parent.equals(b.parent)) {
            return a.parent;
        }

        Set visitedAncestors = new HashSet<Node>();
        Node temp = a;
        while (temp.parent != null) {
            visitedAncestors.add(temp.parent);
            temp = temp.parent;
        }
        temp = b;
        while (!visitedAncestors.contains(temp.parent)) {
            temp = b.parent;
        }

        return temp.parent;
    }
}

