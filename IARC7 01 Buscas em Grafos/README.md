# Buscas em Grafos
## Busca em largura e em profundidade

![Grafo para as Buscas](https://images2.imgbox.com/31/fd/jzb2qaF6_o.png)
### Busca em largura
Implemente a busca em largura para o grafo a seguir, seguindo as instruções:
 1. Implemente em Java ou Python.
 2. Insira os nós informando seu nome e a qual outro nó está conectado.
 3. Após, imprima a lista de adjacentes para todos os nós.
 4. **A raiz é o nó I**. 
 5. O **nó objetivo é o B**. 
 6. Mostre todo o caminho percorrido a partir da raiz para atingi-lo.

### Busca em profundidade
Implemente a busca em profundidade para o grafo a seguir, seguindo as instruções:
 1. Implemente em Java ou Python.
 2. Imprima a lista de adjacentes paratodos os nós.
 3. **A raiz é o nó H.**
 4. O **nó objetivo é o R**.
 5. Mostre todo o caminho percorrido a partir da raiz para atingi-lo.

## Busca Gulosa e A*


| Cidade          | Distância até Bucareste |
|-----------------|-------------------------|
| Arad            | 366                     |
| Bucareste       | 0                       |
| Craiova         | 160                     |
| Dobreta         | 242                     |
| Eforie          | 161                     |
| Fagaras         | 176                     |
| Giurgiu         | 77                      |
| Hirsova         | 151                     |
| Iasi            | 226                     |
| Lugoj           | 244                     |
| Mehadia         | 241                     |
| Neamt           | 234                     |
| Oradea          | 380                     |
| Pitesti         | 100                     |
| Rimnicu Vilcea  | 193                     |
| Sibiu           | 253                     |
| Timisoara       | 329                     |
| Urziceni        | 80                      |
| Vaslui          | 199                     |
| Zerind          | 374                     |

![Mapa das Estradas da Romênia](https://images2.imgbox.com/6c/26/vKtJsev7_o.jpg)

### Busca Gulosa
Implemente a busca gulosa no mapa da Romênia fornecido
 1. Apenas as distâncias de todas as cidades em linha reta até Bucareste são consideradas. Essas distâncias estão na tabela.
 2. As cidades são os nós do grafo.
 3. A busca gulosa não é a busca cega (que varreria todos os nós), portanto há pelo menos uma função heurística simples, a menor distância do vizinho até Bucareste.
 4. A entrada do programa pelo usuário é apenas a cidade da qual desejo partir (origem) para chegar em Bucareste (destino) e o algoritmo de busca escolhido (gulosa ou A*).
 5. A saída do programa é o caminho mostrando todas as cidades da origem até Bucareste.

### Busca A*
Implemente a busca A* no mapa da Romênia fornecido
 1. Apenas as distâncias de todas as cidades em linha reta até Bucareste são consideradas. Essas distâncias estão na tabela.
 2. As distâncias entre os vizinhos são as estradas do mapa, ou seja, as arestas do grafo. As cidades são os nós do grafo.
 3. As cidades são os nós do grafo.
 4. A entrada do programa pelo usuário é apenas a cidade da qual desejo partir (origem) para chegar em Bucareste (destino) e o algoritmo de busca escolhido (gulosa ou A*).
 5. A saída do programa é o caminho mostrando todas as cidades da origem até Bucareste.
