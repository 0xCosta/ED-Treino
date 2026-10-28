package nodes;

/**
 * Representa um nó (node) numa árvore binária.
 * Armazena um elemento e mantém referências para os nós filhos esquerdo e direito.
 *
 * @param <T> o tipo do elemento guardado no nó
 */
public class BinaryTreeNode<T> {

    /**
     * Elemento armazenado neste nó.
     */
    private T element;

    /**
     * Referência para o filho à esquerda.
     */
    private BinaryTreeNode<T> left;

    /**
     * Referência para o filho à direita.
     */
    private BinaryTreeNode<T> right;

    /**
     * Cria um nó vazio com todas as referências a null.
     */
    public BinaryTreeNode() {
        this.element = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Cria um nó com o elemento especificado.
     *
     * @param element o elemento a ser guardado no nó
     */
    public BinaryTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    /**
     * Cria um nó com o elemento especificado e as respetivas referências
     * para as subárvores esquerda e direita.
     *
     * @param element o elemento a ser guardado no nó
     * @param left    o nó filho à esquerda
     * @param right   o nó filho à direita
     */
    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * Devolve o número total de descendentes não nulos deste nó.
     *
     * @return o número total de nós nas subárvores deste nó
     */
    public int numChildren() {
        int children = 0;
        if (left != null) {
            children = 1 + left.numChildren();
        }
        if (right != null) {
            children = children + 1 + right.numChildren();
        }
        return children;
    }

    /**
     * Verifica se este nó é uma folha (não possui filhos).
     *
     * @return true se for uma folha, false caso contrário
     */
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    /**
     * Devolve o elemento armazenado neste nó.
     *
     * @return o elemento armazenado
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Define o elemento armazenado neste nó.
     *
     * @param element o novo elemento a ser armazenado
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Devolve a referência para o nó filho à esquerda.
     *
     * @return a referência para o filho esquerdo
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Define a referência para o nó filho à esquerda.
     *
     * @param left o novo filho esquerdo
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Devolve a referência para o nó filho à direita.
     *
     * @return a referência para o filho direito
     */
    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    /**
     * Define a referência para o nó filho à direita.
     *
     * @param right o novo filho direito
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Devolve a representação textual do elemento contido no nó.
     *
     * @return a representação em String do elemento
     */
    @Override
    public String toString() {
        return (element == null) ? "null" : element.toString();
    }
}
