package Fila.FilaJava.FilaEstatica;

public class FilaEstaticaCircular implements Enfileiravel {

    private Object[] dados;
    private int ponteiroIncio;
    private int ponteiroFim;
    private int quantidade;

    public FilaEstaticaCircular(int tamanho) {
        dados = new Object[tamanho];
        ponteiroIncio = 0;
        ponteiroFim = -1;
        quantidade = 0;
    }

    public FilaEstaticaCircular() {
        this(10);
    }

    @Override
    public void enfileirar(Object dado) {
        /*
         * 1 Passo : Verificar se a fila não esta cheia
         * 2 Passo : Adicionar o valor em ponteiro fim
         * 3 Passo : Verificar se a situacao da fila chegar a estar cheia, porem a
         * posicoes ainda
         * validas no array, utiliza - se da fila circular
         * 4 Passo : incrementacao da quantidade
         * 5 Passo : Alocacao do dado na ultima posicao da fila(ponteiroFIm)
         */

        if (!estaCheia()) {
            ponteiroFim++;
            if (ponteiroFim == dados.length)
                ponteiroFim = 0;
            quantidade++;
            dados[ponteiroFim] = dado;
        } else {
            System.out.println("Queue is full");
        }
    }

    @Override
    public Object desenfileirar() {
        /*
         * 1 Passo : Verificar se a fila nao esta vazia
         * 2 Passo : Passar o dado que esta na primeira posicao como retorno com uma
         * variavel local do metodo
         * 3 Passo : Incrementar ponteiroInicio para o novo Inicio
         * 4 Passo : Fazer a verificação da fila circular, para caso o ponteiroIncio
         * chegue ao final do array
         * 5 Passo : Decrementar quantidade
         * 6 Passo : Retorno do dado desenfilerado
         */
        Object dadoInicio = 0;
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroIncio];
            ponteiroIncio++;

            if (ponteiroIncio == dados.length)
                ponteiroIncio = 0;

            quantidade--;

        } else {
            System.out.println("Queue is empty");
        }

        return dadoInicio;
    }

    @Override
    public Object atualizar(Object dado) {
        Object dadoInicio = 0;
        if (!estaVazia()) {
            dados[ponteiroIncio] = dado;
        } else {
            System.out.println("Queue is empty");
        }
        return dadoInicio;
    }

    @Override
    public Object espiar() {
        Object dadoInicio = 0;
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroIncio];
        } else {
            System.out.println("Queue is empty");
        }
        return dadoInicio;
    }

    @Override
    public Boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public Boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public String imprimir() {
        /*
         * 1 Passo : Criar variavel local de texto para retorno dos dados da fila
         * 2 Passo : Criar variavel local para alocar o valor do ponteiroInicio
         * 3 Passo : for para impressao da fila
         * 4 Passo : Condicao para impressao ou nao da virgula no array
         * 5 Passo : Incrementaçao de ponteiroAux
         * 6 Passo : Retorno da variavel resultado
         */

        String resultado = "[";

        for (int i = 0, ponteiroAux = ponteiroIncio; i < quantidade; i++, ponteiroAux++) {
            if (i == quantidade - 1) {
                resultado += dados[ponteiroAux % dados.length];
            } else {
                resultado += dados[ponteiroAux % dados.length] + ",";
            }
        }

        return resultado + "]";
    }

}
