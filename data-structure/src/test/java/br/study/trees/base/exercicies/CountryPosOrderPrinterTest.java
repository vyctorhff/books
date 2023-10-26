package br.study.trees.base.exercicies;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.study.trees.base.DepthGenericTree;
import br.study.trees.base.GenericTree;
import br.study.trees.base.HeightGenericTree;
import br.study.trees.base.Node;
import helpers.trees.GenericTreeHelper;

@ExtendWith({MockitoExtension.class})
public class CountryPosOrderPrinterTest {

    private GenericTreeHelper<String> helper;

    private CountryPosOrderPrinter sut;

    @Mock
    private DepthGenericTree<String> depth;

    @Mock
    private HeightGenericTree<String> height;

    @BeforeEach
    void setup() {
        this.sut = new CountryPosOrderPrinter();
    }

    @Test
    void shouldPrint() {
        // REFACT: create with helper
        Node<String> root = Node.createRoot("Sellers");
        GenericTree<String> tree = new GenericTree<>(root, depth, height);

        Map<Object, Object> context = new HashMap<>();

        this.sut.execute(tree, context);

        System.out.println(context.get("result"));
        Assertions.assertNotNull(context.get("result"));
        
        Assertions.fail("not check yet");
    }
}
