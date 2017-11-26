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

    public static Node firstCommonAncestor(Node left, Node right) {
        if (left.parent == null || right.parent == null) {
            return null;
        }
        if (left.parent.equals(right.parent)) {
            return left.parent;
        }

        Set visitedAncestors = new HashSet<Node>();
        collectAllAncestorsOfOneNode(visitedAncestors, left);
        Node ancestor = findFirstCommonAncestorInSet(visitedAncestors, right);
        return ancestor;
    }

    private static void collectAllAncestorsOfOneNode(Set visitedAncestors, Node temp) {
        if (temp.parent != null) {
            visitedAncestors.add(temp.parent);
            collectAllAncestorsOfOneNode(visitedAncestors, temp.parent);
        }
    }

    private static Node findFirstCommonAncestorInSet(Set visitedAncestors, Node temp) {
        if (!visitedAncestors.contains(temp.parent)) {
            return findFirstCommonAncestorInSet(visitedAncestors, temp.parent);
        } else {
            return temp.parent;
        }
    }
}

