package Pilha.PilhaJava.PilhaEstatica.Pilha;

public interface Empilhavel {

    // Metodos auxiliares
    public boolean estaVazia();
    public boolean estaCheia();
    public String imprimir();

    // metodos principais
    public void empilhar(Object dado);
    public Object desempilhar();
    public Object topo();
}