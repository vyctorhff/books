package br.study.trees.base;

import java.util.Map;

/**
 * parent first then children
 */
public class VisitPreOrderPrinter implements VisitAlgorithm<String> {

    @Override
    public void execute(GenericTree<String> tree, Map<Object, Object> context) {
        var sb = new StringBuilder();

        helper(tree.getRoot(), sb);

        context.put("preOrderPrinter", sb.toString());
    }

    private void helper(Node<String> node, StringBuilder sb) {
        sb.append(node.getElement());

        for (Node<String> son : node.getChildren()) {
            helper(son, sb);
        }
    }
}
