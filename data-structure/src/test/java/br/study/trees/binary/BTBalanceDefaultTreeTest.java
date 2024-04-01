package br.study.trees.binary;

import helpers.trees.BinaryTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTBalanceDefaultTreeTest {

    private BTBalanceDefaultTree<Integer> sut;

    private BinaryTreeHelper<Integer> helper;

    @BeforeEach
    void setUp() {
        this.helper = new BinaryTreeHelper<>();
    }

    @Test
    void shouldBalanceWithRootOnly() {
        BinaryTree<Integer> tree = this.helper.createTreeWithRoot(2);

        this.sut = new BTBalanceDefaultTree<>(tree);
        
        fail("not implement");
    }
}