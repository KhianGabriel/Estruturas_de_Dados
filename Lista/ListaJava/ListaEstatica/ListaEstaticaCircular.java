package Lista.ListaJava.ListaEstatica;

public class ListaEstaticaCircular implements Listavel {

    private Object[] dados;
    private int quantidade;
    private int ponteiroInicio;
    private int ponteiroFim;

    public ListaEstaticaCircular(int tamanho) {
        dados = new Object[tamanho];
        quantidade = 0;
        ponteiroInicio = 0;
        ponteiroFim = -1;
    }

    public ListaEstaticaCircular(){
        this(10);
    }

    @Override
    public void anexar(Object dado) {
        /*
         * 1 Passo : Verificar se a lista não esta cheia
         * 2 Passo : Incrementar ponteiroFim, para alocar no novo dado
         * 3 Passo : Fazer a verificação da lista circular
         * 4 Passo : passar o novo dado para a última posicao da lista
         * 5 Passo : Incrementar o valor de quantidade
         */
        if (!estaCheia()) {
            ponteiroFim++;
            if (ponteiroFim == dados.length)
                ponteiroFim = 0;

            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.out.println("List is empty");
        }
    }

    @Override
    public void inserir(int posicao, Object dado) {
        /*
         * 1 Passo : Verificar se a lista esta cheia
         * 2 Passo : Verificar se a posicao requerida pelo o usuario e valida
         * 3 Passo : Verificar a posicao fisica da lista
         * 4 Passo : Criar uma variavel que irá receber o valor de uma nova posição do
         * array var = atual
         * 5 Passo : Criação do looping para iteração da lista, até a posicao requerida
         * pelo o usuario esteja
         * vazia
         * 6 Passo : Colocar condição no loop, para que ele rode da posicao especificada
         * + 1 até o final
         * 7 Passo : Criar uma outra variavel que sempre sera menor que atual, para
         * passar os dados dela
         * para atual, até que abra o espaço da posicao requerida pelo o usuario - var =
         * anterior
         * 8 Passo : Verificar se após a incrementação de atual ele não der erro e fique
         * do tamanho do
         * array
         * 9 Passo : A passagem do valor de anterior para atual e a decrementação de
         * atual
         * 10 Passo : Após aberta a posicao do usuario, é passado o novo dado para a
         * posicao, e a incrementação
         * de ponteiroFim para o novo fim da lista, além da incrementação de quantidade
         * 
         */

        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                int posicaoFisica = (posicao + ponteiroInicio) % dados.length;
                int atual = ponteiroFim + 1;

                for (int i = 0; i < quantidade - posicao; i++) {
                    int anterior = atual - 1;
                    if (atual == dados.length) {
                        atual = 0;
                    }

                    dados[atual] = dados[anterior];
                    atual--;
                }

                dados[posicaoFisica] = dado;
                ponteiroFim++;

                if (ponteiroFim == dados.length) {
                    ponteiroFim = 0;
                }

                quantidade++;
            } else {
                System.out.println("Posicao invalida");
            }
        } else {
            System.out.println("List is full");
        }
    }

    @Override
    public Object selecionar(int posicao) {
        /*
         * 1 Passo = Criar uma variavel que ira retornar o dado da posicao requerida do
         * usuario
         * 2 Passo = Verificar se a lista não esta vazia
         * 3 Passo = Verificar se a posicao requerida pelo o usuario é valida
         * 4 Passo = Verificaçaõ da posicaoFisica
         * 5 Passo = Passar o dado da posicaoFisica para a variavel de retorno
         * 6 Passo = retorna variavel
         */

        Object dadoAux = null;

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                int posicaoFisica = (posicao + ponteiroInicio) % dados.length;
                dadoAux = dados[posicaoFisica];
            } else {
                System.out.println("Posicao invalida");
            }
        } else {
            System.out.println("Lista is empty");
        }

        return dadoAux;
    }

    @Override
    public Object[] selecionarTodos() {
        /*
         * 1 Passo : Criação de um array para receber todos os dados
         * 2 Passo : Verificar se a lista não esta vazia
         * 3 Passo : Criação de uma variavel para receber o valor de ponteiroInicio
         * 4 Passo : Criação do loop para iterar esse novo array
         * 5 Passo : Passar os dados para o novo array
         * 6 Passo : Retorno do array
         */

        Object[] dadosAux = new Object[quantidade];
        if (!estaVazia()) {
            int ponteiroAux = ponteiroInicio;
            for (int i = 0; i < quantidade; i++) {
                dadosAux[i] = dados[(ponteiroAux + i) % dados.length];
            }
        }
        return dadosAux;
    }

    @Override
    public void atualizar(int posicao, Object dado) {
        /*
         * 1 Passo : Verificar se a lista esta vazia
         * 2 Passo : Verificar se a posicao passada pelo o usuario e valida
         * 3 Passo : Verificar a posicaoFisica
         * 4 Passo : Passar o dado para a posicao requerida
         */

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                int posicaoFisica = (posicao + ponteiroInicio) % dados.length;
                dados[posicaoFisica] = dado;
            } else {
                System.out.println("Posicao invalida");
            }
        } else {
            System.out.println("List is empty");
        }
    }

    @Override
    public Object apagar(int posicao) {
        Object dadoAux = null;
        if (!estaVazia()) {
            // verificar se a posicao informada é valida
            if ((posicao >= 0) && (posicao < quantidade)) {
                int posicaoFisica = (ponteiroInicio + posicao) % dados.length;
                dadoAux = dados[posicaoFisica];

                int atual = posicaoFisica;

                for (int i = 0; i < quantidade - posicao - 1; i++) {

                    int proximo = (atual + 1) % dados.length;
                    dados[atual] = dados[proximo];
                    atual = (atual + 1) % dados.length;
                }
                ponteiroFim--;
                if (ponteiroFim == -1) {
                    ponteiroFim = dados.length - 1;
                }
                quantidade--;
            } else {
                System.err.println("Indice Invalido!");
            }
        } else {
            System.err.println("Lista Vazia!");
        }
        return dadoAux;
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public boolean estaCheia() {
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

        for (int i = 0, ponteiroAux = ponteiroInicio; i < quantidade; i++, ponteiroAux++) {
            if (i == quantidade - 1) {
                resultado += dados[ponteiroAux % dados.length];
            } else {
                resultado += dados[ponteiroAux % dados.length] + ",";
            }
        }
        return resultado + "]";
    }

}
