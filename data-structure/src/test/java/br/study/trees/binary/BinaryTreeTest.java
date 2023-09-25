package br.study.trees.binary;

import helpers.trees.BinaryTreeHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class BinaryTreeTest {

    private BinaryTree<String> sut;

    private BinaryTreeHelper helper;

    @BeforeEach
    void setUp() {
        this.helper = new BinaryTreeHelper();
    }

    @Test
    void shouldBePropria() {
        Assertions.fail();
    }
}