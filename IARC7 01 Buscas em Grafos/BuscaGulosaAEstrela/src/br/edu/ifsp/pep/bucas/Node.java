package br.edu.ifsp.pep.bucas;

import java.util.ArrayList;
import java.util.Objects;

public class Node {

    private String info;
    private ArrayList<Node> adjacentes = new ArrayList<>();
    private ArrayList<Integer> distancias = new ArrayList<>();

    public Node(String info) {
        this.info = info;
    }

    public void adcionarAdjacente(Node n, int distancia) {
        this.adjacentes.add(n);
        this.distancias.add(distancia);
    }

    public void apresentarAdjacente() {
        for (Node adjacente : adjacentes) {
            System.out.print(adjacente);
        }
    }

    public boolean match(String valor) {
        return this.info.equals(valor); 
    }

    public ArrayList<Node> getAdjacentes() {
        return adjacentes;
    }

    public ArrayList<Integer> getDistancias() {
        return distancias;
    }
    
    @Override
    public String toString() {
        return " {" + info + "} ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Node other = (Node) obj;
        return Objects.equals(this.info, other.info);
    }

}
