package br.study.trees.binary;

import lombok.Setter;
import org.apache.commons.lang3.NotImplementedException;

public class BinaryTree<E> {

    private BTNode<E> root;

    @Setter
    private BTPropria<E> checkPropria;

    @Setter
    private BTSize<E> size;

    // TODO: extract interfaces
    public BinaryTree(BTNode<E> root) {
        this.root = root;
    }

    public void replace() {
        throw new NotImplementedException();
    }

    public void balance() {
        var balance = new BTBalanceDefaultTree<E>(this);
        balance.balance();
    }

    public int size() {
        return this.size.execute(this.root);
    }

    public boolean isPropria() {
        return this.checkPropria.check(this.root);
    }
}
