package Pilha.PilhaJava.PilhaEstatica.PilhaDupla;

public interface DuplamenteEmpilhavel {

    //Metodos auxiliares
    public boolean estaVazia1();
    public boolean estaVazia2();
    public boolean estaCheia1();
    public boolean estaCheia2();
    public String imprimir1();
    public String imprimir2();

    //metodos principais
    public void empilhar1(Object dado1);
    public void empilhar2(Object dado2);
    public Object desempilhar1();
    public Object desempilhar2();
    public Object topo1();
    public Object topo2();
}
