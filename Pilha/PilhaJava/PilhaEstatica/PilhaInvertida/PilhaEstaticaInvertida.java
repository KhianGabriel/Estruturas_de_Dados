package Pilha.PilhaJava.PilhaEstatica.PilhaInvertida;

public class PilhaEstaticaInvertida implements Empilhavel {
    
    // Variaveis globais
    int ponteiroTopo;
    Object[] dados;

    // Declarar construrores
    public PilhaEstaticaInvertida() {
        this(10);
    }

    public PilhaEstaticaInvertida(int tamanho) {
        this.ponteiroTopo = tamanho;
        this.dados = new Object[tamanho];
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == dados.length);
    }

    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == 0);
    }

    @Override
    public Object topo() {
        Object retorno = "";
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo];
        } else {
            System.out.println("The stack is empty");
        }
        return retorno;
    }

    @Override
    public String imprimir() {
        String retorno = "[";

        for (int i = ponteiroTopo; i <= dados.length - 1; i++) {
            if (i == dados.length - 1) {
                retorno += dados[i];
            } else {
                retorno += dados[i] + ",";
            }
        }
        return retorno += "]";
    }

    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            ponteiroTopo--;
            dados[ponteiroTopo] = dado;
        } else {
            System.out.println("The stack is full");
        }
    }

    @Override
    public Object desempilhar() {
        Object retorno = "";
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo];
            ponteiroTopo++;
        } else {
            System.out.println("The stack is empty");
        }

        return retorno;
    }
}
