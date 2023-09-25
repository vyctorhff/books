package br.study.trees.base;

import helpers.trees.GenericTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
class VisitPreOrderPrinterTest {

    /**
     * create testing tree with simple math expression
     * do the visite
     */

    private String MINUS_SYMBLE = "-";
    private String PLUS_SYMBLE = "+";

    private GenericTreeHelper<String> helper;

    private VisitPreOrderPrinter preOrderPrinter;

    @BeforeEach
    void setUp() {
        this.helper = new GenericTreeHelper<>();

        this.preOrderPrinter = new VisitPreOrderPrinter();
    }

    @Test
    void shouldVisitSuccessfully() {
        var tree = createSimpleMathTree();
        var expect = "-+22+333";

        Map<Object, Object> context = tree.visit(preOrderPrinter);

        assertEquals(expect, context.get("preOrderPrinter"));
    }

    private GenericTree<String> createSimpleMathTree() {
        // expression
        // (2 + 2) - (3 + 3 + 3)

        GenericTree<String> tree = helper.createTree(MINUS_SYMBLE);
        Node<String> root = tree.getRoot();

        Node<String> nodePlusLeft = new Node<>(root, PLUS_SYMBLE);
        nodePlusLeft.addSon("2");
        nodePlusLeft.addSon("2");

        Node<String> nodePlusRight = new Node<>(root, PLUS_SYMBLE);
        nodePlusRight.addSon("3");
        nodePlusRight.addSon("3");
        nodePlusRight.addSon("3");

        tree.add(root, nodePlusLeft);
        tree.add(root, nodePlusRight);

        return tree;
    }
}