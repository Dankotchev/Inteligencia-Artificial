import numpy as np
import random
import os
import json
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation


def random_position():
    return random.randint(0, 500), random.randint(0, 500)


if os.path.exists('cities.json'):
    # Se o arquivo existir, carregue as cidades do arquivo JSON
    with open('cities.json', 'r') as file:
        cities = np.array(json.load(file))
else:
    # Se o arquivo não existir, gere cidades aleatórias
    cities = np.array([random_position() for _ in range(50)])
    # Salvar as cidades geradas no arquivo JSON
    with open('cities.json', 'w') as file:
        json.dump(cities.tolist(), file)


# Função para calcular a distância total de um caminho
def total_distance(path):
    total = 0
    for i in range(len(path) - 1):
        total += np.linalg.norm(cities[path[i]] - cities[path[i+1]])
    return total


# Função para gerar uma população inicial aleatória
def generate_population(pop_size, num_cities):
    population = []
    for _ in range(pop_size):
        population.append(random.sample(range(num_cities), num_cities))
    return population


# Função para realizar o crossover entre dois pais para gerar um filho
def crossover(parent1, parent2):
    crossover_point = random.randint(0, len(parent1) - 1)
    child = parent1[:crossover_point]
    remaining = [gene for gene in parent2 if gene not in child]
    child.extend(remaining)
    return child


# Função para realizar a mutação em um indivíduo
def mutate(individual):
    index1, index2 = random.sample(range(len(individual)), 2)
    individual[index1], individual[index2] = individual[index2], individual[index1]
    return individual


# Função de reprodução da população
def reproduction(population, pop_size, mutation_tx):

    # Seleção dos melhores indivíduos para serem "pais"
    parents = selection(population, pop_size)
    next_gen = parents.copy()

    for _ in range(pop_size):
        parent1, parent2 = random.sample(parents, 2)
        child = crossover(parent1, parent2)
        if random.random() < mutation_tx:  # Taxa de mutação
            child = mutate(child)
        next_gen.append(child)
    return next_gen


# Função para selecionar os melhores indivíduos da população
def selection(population, best_of):
    population.sort(key=lambda x: total_distance(x))
    return population[:best_of]


# Função principal do algoritmo genético
def genetic_algorithm(pop_size, num_generations, mutation_tx, early_stopping=10):
    population = generate_population(pop_size, len(cities))
    best_paths = []
    best_distances = []
    best_path = None
    best_distance = float('inf')

    generations_no_improvement = 0

    for gen in range(num_generations):
        half_pop_size = pop_size // 2

        # Reprodução da população
        population = reproduction(population, half_pop_size, mutation_tx)

        # Seleção do melhor indivíduo da geração
        population = selection(population, pop_size)

        current_best_path = population[0]
        current_best_distance = total_distance(current_best_path)
        if current_best_distance < best_distance:
            best_path = current_best_path
            best_distance = current_best_distance
            generations_no_improvement = 0
        else:
            generations_no_improvement += 1

        # Adiciona o melhor caminho e menor distância da geração no histório
        best_paths.append(best_path.copy())
        best_distances.append(best_distance)

        print(f"Geração {gen + 1}, Melhor Distância: {best_distance:.2f}, Gerações consecutivas sem mudanças: {generations_no_improvement}")

        if generations_no_improvement >= early_stopping - 1:
            print(f"Condição de parada atingida na geração {gen + 1}:\n\tMelhor distância não mudou por {early_stopping} gerações consecutivas.")
            break

    return best_paths, best_distances


# Execução do algoritmo genético com registro da evolução dos melhores caminhos
best_paths, best_distances = genetic_algorithm(pop_size=1000, num_generations=1000, mutation_tx=0.1)


# Função para atualizar o gráfico a cada frame da animação
def update(frame):
    plt.cla()  # Limpa o eixo atual
    path = best_paths[frame]
    plt.plot(cities[path][:, 0], cities[path][:, 1], marker='D', label=f'Geração {frame+1}')
    plt.title("Evolução dos melhores caminhos")
    plt.xlabel("X")
    plt.ylabel("Y")
    plt.xlim(-20, 520)
    plt.ylim(-20, 520)
    plt.text(0.95, 0.95, f'Melhor distância: {best_distances[frame]:.2f}', ha='right', va='top', transform=plt.gca().transAxes,
             bbox=dict(facecolor='white', alpha=0.5))
    plt.legend()
    plt.grid(False)


# Criação da animação
fig = plt.figure(figsize=(10, 8))
ani = FuncAnimation(fig, update, frames=len(best_paths), interval=100)
ani.save('AG Caixeiro Viajante.gif', writer='imagemagick', savefig_kwargs={'facecolor': 'none'})

# Mostra a animação
plt.show()