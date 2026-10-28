# Parte II - Exercício 2

## Pergunta:
> *Dada a versatilidade de uma lista porquê que não é sempre a escolhida em vez de uma Stack ou de uma Queue?*

---

### Resposta:

Embora uma lista seja mais flexível e permita operações de inserção, remoção e consulta em qualquer ponto (início, fim e meio), **não é sempre a melhor escolha** face a uma `Stack` (Pilha) ou `Queue` (Fila) pelas seguintes razões:

1. **Segurança de Desenho e Integridade dos Dados (Restrição Semântica):**
   * Estruturas como a **Pilha (LIFO)** e a **Fila (FIFO)** impõem intencionalmente restrições ao acesso aos dados.
   * Por exemplo, na avaliação de expressões ou no histórico de "Undo" de uma aplicação, pretendemos garantir que apenas o elemento do topo possa ser manipulado. Numa fila de impressão ou processamento de mensagens, devemos garantir que o primeiro a chegar seja o primeiro a sair.
   * Se utilizássemos uma lista em vez de uma pilha ou fila, qualquer parte do código poderia violar as regras LIFO/FIFO ao remover ou inserir elementos arbitrariamente no meio da coleção, introduzindo bugs difíceis de detetar.

2. **Complexidade e Eficiência Garantidas:**
   * Numa `Stack` e numa `Queue`, as operações fundamentais (`push`/`pop`, `enqueue`/`dequeue`) são estritamente garantidas em tempo constante: $\mathcal{O}(1)$.
   * Numa lista, operações como procurar, aceder ou inserir no meio exigem frequentemente tempo linear $\mathcal{O}(n)$, podendo levar a perdas de desempenho quando a flexibilidade extra não é necessária.

3. **Clareza de Intenção no Código:**
   * Usar `Stack` ou `Queue` comunica imediatamente ao leitor/programador o fluxo lógico e a forma de processamento dos dados na aplicação, tornando o código auto-explicativo e mais fácil de manter.

