package tree;

import ADTs.BinaryTreeADT;
import queue.LinkedQueue;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import nodes.BinaryTreeNode;
import lists.ArrayUnorderedList;

import java.util.Iterator;

/**
 * Implementação ligada de uma Árvore Binária (LinkedBinaryTree).
 * Implementa a interface BinaryTreeADT utilizando nós do tipo BinaryTreeNode.
 *
 * @param <T> o tipo dos elementos guardados na árvore binária
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    /**
     * Referência para o nó raiz da árvore binária.
     */
    protected BinaryTreeNode<T> root;

    /**
     * Contagem total de elementos presentes na árvore binária.
     */
    protected int count;

    /**
     * Cria uma árvore binária vazia.
     */
    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * Cria uma árvore binária com o elemento especificado na raiz.
     *
     * @param element o elemento a colocar na raiz da árvore
     */
    public LinkedBinaryTree(T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<>(element);
    }

    /**
     * Cria uma árvore binária a partir de um elemento raiz e duas subárvores
     * (esquerda e direita), como sugerido no Slide 44.
     *
     * @param element      o elemento da raiz
     * @param leftSubtree  a subárvore esquerda
     * @param rightSubtree a subárvore direita
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree, LinkedBinaryTree<T> rightSubtree) {
        this.root = new BinaryTreeNode<>(element);
        this.count = 1;

        if (leftSubtree != null) {
            this.count += leftSubtree.size();
            this.root.setLeft(leftSubtree.root);
        }

        if (rightSubtree != null) {
            this.count += rightSubtree.size();
            this.root.setRight(rightSubtree.root);
        }
    }

    /**
     * Devolve o elemento guardado no nó raiz desta árvore.
     *
     * @return o elemento da raiz ou null se a árvore estiver vazia
     */
    @Override
    public T getRoot() {
        if (isEmpty()) {
            return null;
        }
        return root.getElement();
    }

    /**
     * Verifica se esta árvore binária está vazia.
     *
     * @return true se a árvore não tiver elementos, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Devolve o número total de elementos na árvore.
     *
     * @return o número de elementos
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Verifica se a árvore contém o elemento especificado.
     *
     * @param targetElement o elemento a procurar
     * @return true se o elemento for encontrado, false caso contrário
     */
    @Override
    public boolean contains(T targetElement) {
        try {
            find(targetElement);
            return true;
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    /**
     * Procura o elemento especificado na árvore binária e devolve-o.
     *
     * @param targetElement o elemento a procurar
     * @return o elemento encontrado
     * @throws ElementNotFoundException se o elemento não for encontrado
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> foundNode = findAgain(targetElement, root);

        if (foundNode == null) {
            throw new ElementNotFoundException("Elemento não encontrado na Árvore Binária.");
        }

        return foundNode.getElement();
    }

    /**
     * Método recursivo auxiliar para procurar um elemento a partir de determinado nó.
     *
     * @param targetElement o elemento a procurar
     * @param next          o nó atual da pesquisa
     * @return o nó que contém o elemento, ou null se não for encontrado
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.getElement().equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

        if (temp == null) {
            temp = findAgain(targetElement, next.getRight());
        }

        return temp;
    }

    /**
     * Devolve uma representação textual da estrutura da árvore.
     *
     * @return a representação em String da árvore binária
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, "", true);
        return sb.toString();
    }

    /**
     * Constrói recursivamente a representação gráfica em árvore com ramificações.
     */
    private void buildString(BinaryTreeNode<T> node, StringBuilder sb, String prefix, boolean isLeft) {
        if (node != null) {
            sb.append(prefix)
                    .append(isLeft ? "├── " : "└── ")
                    .append(node.getElement())
                    .append("\n");

            String newPrefix = prefix + (isLeft ? "│   " : "    ");
            buildString(node.getLeft(), sb, newPrefix, true);
            buildString(node.getRight(), sb, newPrefix, false);
        }
    }

    /**
     * Realiza uma travessia em ordem (in-order: esquerda, raiz, direita)
     * e devolve um iterador sobre os elementos da árvore.
     *
     * @return um iterador sobre os elementos em ordem
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        inorder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Método recursivo auxiliar para a travessia em ordem.
     *
     * @param node     o nó atual
     * @param tempList a lista temporária onde os elementos são recolhidos
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inorder(node.getRight(), tempList);
        }
    }

    /**
     * Realiza uma travessia em pré-ordem (pre-order: raiz, esquerda, direita)
     * e devolve um iterador sobre os elementos da árvore.
     *
     * @return um iterador sobre os elementos em pré-ordem
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        preorder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Método recursivo auxiliar para a travessia em pré-ordem.
     *
     * @param node     o nó atual
     * @param tempList a lista temporária onde os elementos são recolhidos
     */
    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.getElement());
            preorder(node.getLeft(), tempList);
            preorder(node.getRight(), tempList);
        }
    }

    /**
     * Realiza uma travessia em pós-ordem (post-order: esquerda, direita, raiz)
     * e devolve um iterador sobre os elementos da árvore.
     *
     * @return um iterador sobre os elementos em pós-ordem
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        postorder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Método recursivo auxiliar para a travessia em pós-ordem.
     *
     * @param node     o nó atual
     * @param tempList a lista temporária onde os elementos são recolhidos
     */
    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postorder(node.getLeft(), tempList);
            postorder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    /**
     * Realiza uma travessia por níveis (level-order / em largura)
     * recorrendo a uma Fila (Queue) e devolve um iterador sobre os elementos.
     *
     * @return um iterador sobre os elementos da árvore por níveis
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>();

        if (isEmpty()) {
            return results.iterator();
        }

        LinkedQueue<BinaryTreeNode<T>> nodes = new LinkedQueue<>();
        nodes.enqueue(root);

        try {
            while (!nodes.isEmpty()) {
                BinaryTreeNode<T> current = nodes.dequeue();

                if (current != null) {
                    results.addToRear(current.getElement());

                    if (current.getLeft() != null) {
                        nodes.enqueue(current.getLeft());
                    }

                    if (current.getRight() != null) {
                        nodes.enqueue(current.getRight());
                    }
                }
            }
        } catch (EmptyCollectionException ex) {
            System.err.println("Erro na fila: " + ex.getMessage());
        }

        return results.iterator();
    }
}
