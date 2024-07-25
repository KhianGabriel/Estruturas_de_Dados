package Fila.FilaJava.FilaEstatica;

public interface Enfileiravel{

    //Metodos principais
    public void enfileirar(Object dado);
    public Object desenfileirar();
    public Object atualizar(Object dado);
    public Object espiar();

    //Metodos auxiliares
    public Boolean estaVazia();
    public Boolean estaCheia();
    public String imprimir();


}