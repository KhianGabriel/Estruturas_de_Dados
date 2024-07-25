package Pilha.PilhaJava.PilhaEstatica.PilhaDupla;

public class PilhaEstaticaDupla implements DuplamenteEmpilhavel {

    private Object dados[];
    private int ponteiroTopo1;
    private int ponteiroTopo2;

    public PilhaEstaticaDupla(){
        this(10);
    }
    public PilhaEstaticaDupla(int tamanho){
        dados = new Object[tamanho];
        ponteiroTopo1 = -1;
        ponteiroTopo2 = tamanho;
    }

    @Override
    public boolean estaVazia1() {
       return(ponteiroTopo1 == -1);
    }

    @Override
    public boolean estaCheia1() {
        return(ponteiroTopo1 == ponteiroTopo2 - 1);
    }

    @Override
    public String imprimir1() {
        String retorno = "[";

        for (int i = ponteiroTopo1; i >=0; i--) {
            if (i == 0) {
                retorno += dados[i];
            } else {
                retorno += dados[i] + ",";
            }
        }
        return retorno += "]";
    }

    @Override
    public boolean estaVazia2() {
       return(ponteiroTopo2 == dados.length);
    }

    @Override
    public boolean estaCheia2() {
        return(estaCheia1());
    }

    @Override
    public String imprimir2() {
        String retorno = "[";

        for (int i = ponteiroTopo2; i <= dados.length - 1; i++) {
            if (i == dados.length - 1) {
                retorno += dados[i];
            } else {
                retorno += dados[i] + ",";
            }
        }
        return retorno += "]";
    }

    @Override
    public void empilhar1(Object dado1) {
        if (!estaCheia1()) {
            ponteiroTopo1++;
            dados[ponteiroTopo1] = dado1;
        } else {
            System.out.println("The stack is full");
        }
    }

    @Override
    public Object desempilhar1() {
        Object retorno = "";
        if (!estaVazia1()) {
            retorno = dados[ponteiroTopo1];
            ponteiroTopo1--;
        } else {
            System.out.println("The stack is empty");
        }

        return retorno;
    }

    @Override
    public Object topo1() {
        Object retorno = "";
        if (!estaVazia1()) {
            retorno = dados[ponteiroTopo1];
        } else {
            System.out.println("The stack is empty");
        }
        return retorno;
    }

    @Override
    public void empilhar2(Object dado2) {
        if (!estaCheia2()) {
            ponteiroTopo2--;
            dados[ponteiroTopo2] = dado2;
        } else {
            System.out.println("The stack is full");
        }
    }

    @Override
    public Object desempilhar2() {
        Object retorno = "";
        if (!estaVazia2()) {
            retorno = dados[ponteiroTopo2];
            ponteiroTopo2++;
        } else {
            System.out.println("The stack is empty");
        }

        return retorno;
    }

    @Override
    public Object topo2() {
        Object retorno = "";
        if (!estaVazia2()) {
            retorno = dados[ponteiroTopo2];
        } else {
            System.out.println("The stack is empty");
        }
        return retorno;
    }
    
}
