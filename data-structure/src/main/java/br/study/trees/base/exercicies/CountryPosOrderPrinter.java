package br.study.trees.base.exercicies;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.study.trees.base.GenericTree;
import br.study.trees.base.Node;
import br.study.trees.base.VisitAlgorithm;

/**
 * Criativite 7-5
 * 
 * Based on this tree:
 * Sellers
 *  - National
 *  - International
 *      - Canada
 *      - South America
 *      - Ultramar
 *          - Africa
 *          - Europe
 *          - Asia
 *          - Australia
 * 
 * Should be printed as
 * Sellers(
 *  National
 *  International(
 *      Canada
 *      South America
 *      Ultramar(
 *          Africa
 *          Europe
 *          Asia
 *          Australia
 *      )
 *  )
 * )
 */
public class CountryPosOrderPrinter implements VisitAlgorithm<String> {

    private static final int IDENTATION = 4;

    @Override
    public void execute(GenericTree<String> tree, Map<Object, Object> context) {
        StringBuilder sb = new StringBuilder();
        helper(tree.getRoot(), sb, 0);

        context.put("result", "");
    }

    private void helper(Node<String> node, StringBuilder sb, int identation) {
        sb.append(node.getElement() + " )");
        
        for (Node<String> son: node.getChildren()) {
            helper(son, sb, identation + 4);
        }

        closeBracet(sb, identation);
    }

    private void closeBracet(StringBuilder sb, int identation) {
        sb.append(StringUtils.LF);

        if (identation == 0) {
            sb.append(")");
        } else {
            var space = " ".repeat(identation);
            sb.append("%s)".formatted(space));
        }
    }
}
