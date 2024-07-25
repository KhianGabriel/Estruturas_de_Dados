class FilaEstaticaCircular(private val tamanho: Int = 10) : Enfileiravel {

    // Atributos da classe
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0

    override fun enfileirar(dado: Any?) {
        /*
        1 Passo : Verificar se a fila não esta cheia
        2 Passo : Adicionar o valor em ponteiro fim
        3 Passo : Verificar se a situacao da fila chegar a estar cheia, porem a posicoes ainda
                  validas no array, utiliza - se da fila circular
        4 Passo : incrementacao da quantidade
        5 Passo : Alocacao do dado na ultima posicao da fila(ponteiroFIm)
        */
        if (!estaCheia()) {
            ponteiroFim++
            if (ponteiroFim == dados.size) ponteiroFim = 0
            quantidade++
            dados[ponteiroFim] = dado
        } else {
            print("Queue is full")
        }
    }

    override fun desenfileirar(): Any? {

        /*
        1 Passo : Verificar se a fila nao esta vazia
        2 Passo : Passar o dado que esta na primeira posicao como retorno com uma variavel local do metodo
        3 Passo : Incrementar ponteiroInicio para o novo Inicio
        4 Passo : Fazer a verificação da fila circular, para caso o ponteiroIncio chegue ao final do array
        5 Passo : Decrementar quantidade
        6 Passo : Retorno do dado desenfilerado
        */
        var dadoInicio: Any? = null
        if (!estaVazia()) {

            dadoInicio = dados[ponteiroInicio]

            ponteiroInicio++

            if (ponteiroInicio == dados.size) ponteiroInicio = 0

            quantidade--
        } else {
            print("Queue is empty")
        }

        return dadoInicio
    }

    override fun atualizar(dado: Any?) {

        /*
         1 Passo : Verificar se a fila esta vazia
         2 Passo : Atualizar o dado da primeira posicao, ponteiroIncio
        */

        if(!estaVazia()){
            dados[ponteiroInicio] = dado
        }else{
            print("Queue is empty")
        }

    }

    override fun espiar(): Any? {
       /*
        1 Passo : Criar variavel para receber o dado da frente da fila, verificar se não esta vazia
        2 Passo : passar o dado como retorno do dado da primeira posicao
       */

       var dadoInicio: Any? = null
       
       if(!estaVazia()){
          dadoInicio = dados[ponteiroInicio]
       }else{
          print("Queue is empty")
       }

       return dadoInicio
    }

    override fun estaCheia(): Boolean {
        return (quantidade == dados.size)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {

        /*
        1 Passo : Criar variavel local de texto para retorno dos dados da fila
        2 Passo : Criar variavel local para alocar o valor do ponteiroInicio
        3 Passo : for para impressao da fila
        4 Passo : Condicao para impressao ou nao da virgula no array
        5 Passo : Incrementaçao de ponteiroAux
        6 Passo : Retorno da variavel resultado 
         */

         var resultado: String = "["
         var ponteiroAux = ponteiroInicio

         for (i in 0 .. quantidade-1) {
            if(i == quantidade - 1){
                resultado += "${dados[ponteiroAux % dados.size]}"
            }else{
                resultado += "${dados[ponteiroAux % dados.size]},"
            }

            ponteiroAux++
         }

         return "$resultado]"
    }
}
