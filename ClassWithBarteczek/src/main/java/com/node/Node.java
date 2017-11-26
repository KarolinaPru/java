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
        return getAncestor(visitedAncestors, left, right);
//        collectAllAncestorsOfOneNode(visitedAncestors, left);
//        return findFirstCommonAncestorInSet(visitedAncestors, right);
    }


    private static Node getAncestor(Set visitedAncestors, Node left, Node right) {
        if (left.parent != null) {
            if (!visitedAncestors.contains(left.parent)){
                visitedAncestors.add(left.parent);
            } else {
                return left.parent;
            }
        }

        if (right.parent != null) {
            if (!visitedAncestors.contains(right.parent)){
                visitedAncestors.add(right.parent);
            } else {
                return right.parent;
            }
        }

        if (left.parent != null && right.parent != null) {
            return getAncestor(visitedAncestors, left.parent, right.parent);
        } else if (left.parent != null) {
            return getAncestor(visitedAncestors, left.parent, right);
        } else {
            return getAncestor(visitedAncestors, left, right.parent);
        }


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

