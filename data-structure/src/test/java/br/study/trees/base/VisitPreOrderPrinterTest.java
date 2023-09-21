package br.study.trees.base;

import br.study.helpers.GenericTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class VisitPreOrderStringTest {

    /**
     * create testing tree with simple math expression
     * do the visite
     */

    private GenericTreeHelper<String> helper;

    @BeforeEach
    void setUp() {
        this.helper = new GenericTreeHelper<>();
    }

    private GenericTree<String> createSimpleMathTree() {
        // expression
        // (2 + 2) - (3 + 3 + 3)

        GenericTree<String> tree = helper.createTree("-");
        return tree;
    }
}