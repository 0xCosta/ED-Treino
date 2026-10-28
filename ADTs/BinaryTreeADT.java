package ADTs;

import exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 * Interface que define o Tipo Abstrato de Dados (ADT) para uma Árvore Binária (Binary Tree).
 *
 * @param <T> o tipo dos elementos guardados na árvore binária
 */
public interface BinaryTreeADT<T> {

    /**
     * Devolve uma referência para o elemento da raiz desta árvore binária.
     *
     * @return uma referência para o elemento da raiz
     */
    public T getRoot();

    /**
     * Verifica se esta árvore binária está vazia.
     *
     * @return true se a árvore binária não contiver elementos, false caso contrário
     */
    public boolean isEmpty();

    /**
     * Devolve o número total de elementos presentes nesta árvore binária.
     *
     * @return o número de elementos na árvore binária
     */
    public int size();

    /**
     * Devolve true se esta árvore binária contiver o elemento especificado e false caso contrário.
     *
     * @param targetElement o elemento a pesquisar na árvore binária
     * @return true se a árvore contiver o elemento alvo, false caso contrário
     */
    public boolean contains(T targetElement);

    /**
     * Devolve uma referência para o elemento especificado se este for encontrado nesta árvore binária.
     * Lança uma exceção se o elemento especificado não for encontrado.
     *
     * @param targetElement o elemento a ser procurado na árvore binária
     * @return uma referência para o elemento encontrado
     * @throws ElementNotFoundException se o elemento não for encontrado na árvore
     */
    public T find(T targetElement) throws ElementNotFoundException;

    /**
     * Devolve uma representação em formato String desta árvore binária.
     *
     * @return a representação textual da árvore binária
     */
    @Override
    public String toString();

    /**
     * Realiza uma travessia em ordem (in-order: subárvore esquerda, raiz, subárvore direita)
     * nesta árvore binária, devolvendo um iterador sobre os seus elementos.
     *
     * @return um iterador sobre os elementos da árvore binária em ordem
     */
    public Iterator<T> iteratorInOrder();

    /**
     * Realiza uma travessia em pré-ordem (pre-order: raiz, subárvore esquerda, subárvore direita)
     * nesta árvore binária, devolvendo um iterador sobre os seus elementos.
     *
     * @return um iterador sobre os elementos da árvore binária em pré-ordem
     */
    public Iterator<T> iteratorPreOrder();

    /**
     * Realiza uma travessia em pós-ordem (post-order: subárvore esquerda, subárvore direita, raiz)
     * nesta árvore binária, devolvendo um iterador sobre os seus elementos.
     *
     * @return um iterador sobre os elementos da árvore binária em pós-ordem
     */
    public Iterator<T> iteratorPostOrder();

    /**
     * Realiza uma travessia por níveis (level-order / em largura) nesta árvore binária,
     * utilizando uma fila, devolvendo um iterador sobre os seus elementos.
     *
     * @return um iterador sobre os elementos da árvore binária por níveis
     */
    public Iterator<T> iteratorLevelOrder();
}
