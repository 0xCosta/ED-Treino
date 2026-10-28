package Ficha9.src.ex1;

import exceptions.ElementNotFoundException;
import tree.LinkedBinaryTree;

import java.util.Iterator;

/**
 * ============================================================================
 * EXERCÍCIO 1 - FICHA 9: LinkedBinaryTree
 * ============================================================================
 * NOTA TEÓRICA (GUIÃO / SLIDE 44):
 * "Tal como é explicado nos slides da aula teórica não é possível adicionar
 * elementos à árvore pelo que a demonstração da sua utilização não faz grande
 * sentido neste exercício."
 *
 * PORQUÊ?
 * 1. Ausência de Semântica de Inserção: Numa Árvore Binária Genérica
 *    (BinaryTreeADT), não existe um critério para posicionar um elemento
 *    novo (não tem início/fim como uma Lista, nem ordem como uma BST).
 *    Por essa razão, não existe um método add(element) na interface.
 *
 * 2. Construção via Subárvores (Slide 44): A única forma de instanciar uma
 *    árvore genérica é através de construção "bottom-up" (de baixo para cima),
 *    combinando folhas e subárvores com o construtor:
 *    LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right)
 *
 * 3. Objetivo desta Demonstração: Demonstrar essa construção do Slide 44 e
 *    comprovar o correto funcionamento das 4 travessias obrigatórias:
 *    - iteratorInOrder
 *    - iteratorPreOrder
 *    - iteratorPostOrder
 *    - iteratorLevelOrder
 * ============================================================================
 */
public class LinkedBinaryTreeDemo {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("         FICHA 9 - EXERCÍCIO 1: DEMONSTRAÇÃO LinkedBinaryTree         ");
        System.out.println("======================================================================\n");

        System.out.println(">>> NOTA TEÓRICA DA FICHA:");
        System.out.println("Numa Árvore Binária Genérica não existe um método add(element) genérico,");
        System.out.println("pois não há critério fixo para onde inserir novos nós. Como sugerido");
        System.out.println("no Slide 44, a árvore é montada combinando subárvores de baixo para cima.\n");

        /*
         * Estrutura da Árvore Binária montada:
         *
         *                A
         *              /   \
         *             B     C
         *            / \     \
         *           D   E     F
         */

        System.out.println("1. A construir as subárvores (Slide 44)...");

        // Nós folha
        LinkedBinaryTree<String> d = new LinkedBinaryTree<>("D");
        LinkedBinaryTree<String> e = new LinkedBinaryTree<>("E");
        LinkedBinaryTree<String> f = new LinkedBinaryTree<>("F");

        // Subárvores intermédias
        LinkedBinaryTree<String> b = new LinkedBinaryTree<>("B", d, e);     // B com filhos D e E
        LinkedBinaryTree<String> c = new LinkedBinaryTree<>("C", null, f);  // C com filho direito F

        // Árvore principal com raiz A
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>("A", b, c);

        System.out.println("Árvore construída com sucesso!\n");

        // 2. Propriedades básicas
        System.out.println("2. Propriedades da Árvore:");
        System.out.println("- Elemento Raiz (getRoot) : " + tree.getRoot());
        System.out.println("- Total de Nós (size)     : " + tree.size());
        System.out.println("- Está vazia? (isEmpty)    : " + tree.isEmpty());
        System.out.println("- Contém 'E'?              : " + tree.contains("E"));
        System.out.println("- Contém 'Z'?              : " + tree.contains("Z"));

        // 3. Representação visual da árvore
        System.out.println("\n3. Estrutura Visual da Árvore (toString):");
        System.out.println(tree);

        // 4. Teste das 4 Travessias
        System.out.println("4. Teste das 4 Travessias Obrigatórias:");

        // A. In-Order (Esquerda -> Raiz -> Direita)
        System.out.print("- In-Order    (E, Raiz, D) : ");
        imprimirIterador(tree.iteratorInOrder());

        // B. Pre-Order (Raiz -> Esquerda -> Direita)
        System.out.print("- Pre-Order   (Raiz, E, D) : ");
        imprimirIterador(tree.iteratorPreOrder());

        // C. Post-Order (Esquerda -> Direita -> Raiz)
        System.out.print("- Post-Order  (E, D, Raiz) : ");
        imprimirIterador(tree.iteratorPostOrder());

        // D. Level-Order (Nível a nível com Fila)
        System.out.print("- Level-Order (por níveis) : ");
        imprimirIterador(tree.iteratorLevelOrder());

        // 5. Teste da Pesquisa (find)
        System.out.println("\n5. Teste do método find():");
        try {
            String encontrado = tree.find("E");
            System.out.println("find('E') -> Encontrado: " + encontrado);

            System.out.println("find('X') -> A pesquisar nó inexistente...");
            tree.find("X");
        } catch (ElementNotFoundException ex) {
            System.out.println("Exceção capturada com sucesso: " + ex.getMessage());
        }

        System.out.println("\n======================================================================");
        System.out.println("                         FIM DA DEMONSTRAÇÃO                          ");
        System.out.println("======================================================================");
    }

    /**
     * Método auxiliar para percorrer e imprimir os elementos de um iterador formatados.
     */
    private static <T> void imprimirIterador(Iterator<T> it) {
        StringBuilder sb = new StringBuilder("[ ");
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }
}
