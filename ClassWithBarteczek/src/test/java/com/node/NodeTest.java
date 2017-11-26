package com.node;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void givenTwoNodesWithSameParent_whenFirstCommonAncestorIsCalled_thenParentIsReturned() {
        Node expected = new Node("a", null);
        Node b = new Node("b", expected);
        Node c = new Node("c", expected);

        Node actual = Node.firstCommonAncestor(b, c);

        assertEquals(expected, actual);
    }

    @Test
    public void givenSameNodeTwiceWithoutParent_whenFirstCommonAncestorIsCalled_thenNullIsReturned() {
        Node a = new Node("a", null);

        Node actual = Node.firstCommonAncestor(a, a);

        assertEquals(null, actual);
    }

    @Test
    public void given2NodesOfWhichOneHasNoParent_whenFirstCommonAncestorIsCalled_thenNullIsReturned() {
        Node a = new Node("a", null);
        Node b = new Node("b", a);

        Node actual = Node.firstCommonAncestor(a, b);

        assertEquals(null, actual);
    }

    @Test
    public void givenSameNodeTwiceWithParent_whenFirstCommonAncestorIsCalled_thenParentIsReturned() {
        Node expected = new Node("a", null);
        Node b = new Node("b", expected);

        Node actual = Node.firstCommonAncestor(b, b);

        assertEquals(expected, actual);
    }

    @Test
    public void givenTwoNodesWithCommonAncestor_whenFirstCommonAncestorIsCalled_thenParentIsReturned() {
        Node expected = new Node("a", null);
        Node b = new Node("b", expected);
        Node c = new Node("c", expected);
        Node d = new Node("d", b);

        Node actual = Node.firstCommonAncestor(c, d);

        assertEquals(expected, actual);
    }
}