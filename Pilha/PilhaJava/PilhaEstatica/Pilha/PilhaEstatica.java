package Pilha.PilhaJava.PilhaEstatica.Pilha;

public class PilhaEstatica implements Empilhavel {

    // Variaveis globais
    int ponteiroTopo;
    Object[] dados;

    // Declarar construrores
    public PilhaEstatica() {
        this(10);
    }

    public PilhaEstatica(int tamanho) {
        this.ponteiroTopo = -1;
        this.dados = new Object[tamanho];
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == -1);
    }

    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == dados.length - 1);
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

        for (int i = ponteiroTopo; i >=0; i--) {
            if (i == 0) {
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
            ponteiroTopo++;
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
            ponteiroTopo--;
        } else {
            System.out.println("The stack is empty");
        }

        return retorno;
    }
}
