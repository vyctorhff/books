package br.study.trees.base.exercicies;

import java.util.Map;

import br.study.trees.base.GenericTree;
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
    public void execute(GenericTree<String> tree, Map<Object, Object> contect) {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
}
