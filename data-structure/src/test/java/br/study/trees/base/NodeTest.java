package br.study.trees.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class NodeTest {

    @Test
    void shouldCreateRootOnly() {
        int expected = 7;

        var root = Node.createRoot(expected);

        assertTrue(root.isRoot());
        assertEquals(expected, root.getElement());
        assertTrue(root.isExternal());
    }

    @Test
    void shouldAddChildren() {
        var root = getGetRootWithSon(7, 8);
        var son = root.getChildren().get(0);

        assertFalse(root.isExternal());
        assertTrue(root.isInternal());

        assertTrue(son.isExternal());
        assertFalse(son.isRoot());
        assertFalse(son.isInternal());
    }

    @Test
    void shouldBeExternalAndNotRoot() {
        var root = getGetRootWithSon(7, 8);
        var son = root.getChildren().get(0);

        assertTrue(son.isExternal());
        assertFalse(son.isRoot());
        assertFalse(son.isInternal());
    }

    private Node<Integer> getGetRootWithSon(Integer elementRoot, Integer elementSon) {
        var root = Node.createRoot(elementRoot);

        var son = new Node<>(root, elementSon);
        root.getChildren().add(son);

        return root;
    }
}