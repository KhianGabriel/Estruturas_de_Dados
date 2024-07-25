class ListaEstaticaCircular(val tamanho: Int = 10) : Listavel {

    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    // idêntico ao enfileirar de FilaEstaticaCircular
    override fun anexar(dado: Any?) {
        /*
        	1 Passo : Verificar se a lista não esta cheia
        	2 Passo : Incrementar ponteiroFim, para alocar no novo dado
        	3 Passo : Fazer a verificação da lista circular
        	4 Passo : passar o novo dado para a última posicao da lista
        	5 Passo : Incrementar o valor de quantidade
        */
        if (!estaCheia()) {
            ponteiroFim++
            if (ponteiroFim == dados.size) ponteiroFim = 0

            dados[ponteiroFim] = dado
            quantidade++
        } else {
            println("Lista cheia!")
        }
    }

    override fun selecionarTodos(): Array<Any?> {
        /*
        	1 Passo : Criação de um array para receber todos os dados
        	2 Passo : Verificar se a lista não esta vazia
        	3 Passo : Criação de uma variavel para receber o valor de ponteiroInicio
        	4 Passo : Criação do loop para iterar esse novo array
        	5 Passo : Passar os dados para o novo array
        	6 Passo : Retorno do array
        */
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            var ponteiroAux = ponteiroInicio
            for (i in 0 until quantidade) dadosAux[i] = dados[(ponteiroAux + i) % dados.size]
        }
        return dadosAux
    }

    override fun selecionar(posicao: Int): Any? {
        /*
        	1 Passo = Criar uma variavel que ira retornar o dado da posicao requerida do usuario
        	2 Passo = Verificar se a lista não esta vazia
        	3 Passo = Verificar se a posicao requerida pelo o usuario é valida
        	4 Passo = Verificaçaõ da posicaoFisica
        	5 Passo = Passar o dado da posicaoFisica para a variavel de retorno
        	6 Passo = retorna variavel
        */
        var dadoAux: Any? = null
        if (!estaVazia()) {
            // índice/posição lógica é válida?
            if (posicao >= 0 && posicao < quantidade) {
                // mapeamento:
                // DE endereçamento lógico
                // (informado pelo usuário)
                // PARA endereçamento físico
                // (onde o dado está no array)
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                dadoAux = dados[posicaoFisica]
            } else {
                println("Indice Inválido!")
            }
        } else {
            println("Lista Vazia!")
        }
        return dadoAux
    }

    override fun atualizar(posicao: Int, dado: Any?) {
        /*
        	1 Passo : Verificar se a lista esta vazia
        	2 Passo : Verificar se a posicao passada pelo o usuario e valida
        	3 Passo : Verificar a posicaoFisica
        	4 Passo : Passar o dado para a posicao requerida
        */
        if (!estaVazia()) {
            // índice/posição lógica é válida?
            if (posicao >= 0 && posicao < quantidade) {
                // mapeamento:
                // DE endereçamento lógico
                // (informado pelo usuário)
                // PARA endereçamento físico
                // (onde o dado está no array)
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                dados[posicaoFisica] = dado
            } else {
                println("Indice Inválido!")
            }
        } else {
            println("Lista Vazia!")
        }
    }

    override fun estaCheia(): Boolean {
        return quantidade == dados.size
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade) {
            if (i == ponteiroFim) {
                resultado += "${dados[(ponteiroAux+i) % dados.size]}"
            } else {
                resultado += "${dados[(ponteiroAux+i) % dados.size]},"
            }
        }
        return "$resultado]"
    }

    override fun apagar(posicao: Int): Any? {
        /*
        	1 Passo : Criar uma variavel local para o retorno do valor que foi apagado
        	2 Passo : Verificar se a lista não esta vazia
        	3 Passo : Verificar se a posicao passada pelo o usuario é valida
        	4 Passo : Verificar a posicaoFisica
        	5 Passo : Passar o dado da posicaoFisica no array para a variavel de retorno
        	6 Passo : Criar uma variavel para verificar a posicao atual da posicaoFisica
        	7 Passo : Sobrescrever o valor "Removido" iterando o array com um loop


        */
        // Criação da variavel de retorno
        var dadoAux: Any? = null
        // Verificação da lista não estar vazia
        if (!estaVazia()) {
            // Verificação da posicao valida
            if (posicao >= 0 && posicao < quantidade) {
                // Verificação da PosiçãoFisica
                var posicaoFisica = (posicao + ponteiroInicio) % dados.size
                // Passagem do dado da posição para a variavel de retorno
                dadoAux = dados[posicaoFisica]
                // Criação de uma variavel para receber o valor da posicaoFisica
                var atual = posicaoFisica
                /*Criação do loop, com condição de que será quantidade ex 10, - posicao ex 4 - 1, ou seja
                  a ideia é fazer o loop iterar da posicao 4 até 10, sobrescrevendo a posicao 4, ou seja
                  até a posicao 5
                */
                for (i in 0..quantidade - posicao - 1) {
                    /*Criação da variavel proximo para receber o valor de atual + 1 e verificação da
                      posicao se é valida
                    */
                    var proximo = (atual + 1) % dados.size
                    // Passagem do valor de proximo para atual
                    dados[atual] = dados[proximo]
                    // Verificação da posicao de atual
                    atual = (atual + 1) % dados.size
                }
                // Decrementação do ponteiroFim, para o novo fim
                ponteiroFim--
                // Verificação de ponteiroFim para uma possivel exceção
                if (ponteiroFim == -1) {
                    ponteiroFim = dados.size - 1
                    quantidade--
                }
            } else {
                print("Posicao invalida")
            }
        } else {
            print("List is empty")
        }
        return dadoAux
    }

    override fun inserir(posicao: Int, dado: Any?) {
        /*
             	1 Passo : Verificar se a lista esta cheia
        2 Passo : Verificar se a posicao requerida pelo o usuario e valida
        3 Passo : Verificar a posicao fisica da lista
        4 Passo : Criar uma variavel que irá receber o valor de uma nova posição do array var = atual
        5 Passo : Criação do looping para iteração da lista, até a posicao requerida pelo o usuario esteja
        vazia
        6 Passo : Colocar condição no loop, para que ele rode da posicao especificada + 1 até o final
        7 Passo : Criar uma outra variavel que sempre sera menor que atual, para passar os dados dela
        para atual, até que abra o espaço da posicao requerida pelo o usuario
        8 Passo : Verificar se após a incrementação de atual ele não der erro e fique do tamanho do
        array
        9 Passo : A passagem do valor de anterior para atual e a decrementação de atual
        10 Passo : Após aberta a posicao do usuario, é passado o novo dado para a posicao, e a incrementação
        de ponteiroFim para o novo fim da lista, além da incrementação de quantidade

             */

        if (!estaCheia()) {
            // Verificaçao se a posicao é valida
            if (posicao >= 0 && posicao <= quantidade) {
                // Verificacao da posicao fisica
                var posicaoFisica = (posicao + ponteiroInicio) % dados.size
                // Atual recebe a nova posicao após ponteiro fim na lista
                var atual = ponteiroFim + 1
                // Iteração do array, da posicao que o usuario passou até o final, Ex: 10 - 4 = 6,
                // ou seja
                // o i vai rodar 6 vezes, até chegar na última posicao da lista
                for (i in 0..quantidade - posicao) {
                    /*
                    Posicao anterior recebe a posicao que antecede a atual, ou seja a penultima posicao e
                    Atual a ultima
                     */
                    var anterior = atual - 1
                    /*
                    Se a posicao atual for igual ao tamanho do array ele irá receber o valor 0
                    muito por conta da lista nao estar cheia e ser circular, ou seja, mesmo que tenha
                    chegado ao tamanho do array, possa haver posicoes validas no seu começo
                                  */
                    if (atual == dados.size) {
                        atual = 0
                    }

                    if (atual == -1) {
                        atual = dados.size - 1
                    }

                    /*
                    	Ainda dentro do loop, começa a passar os valores de anterior para atual
                    	e a decrementação de atual, no caso não precisa decrementar anterior, pois toda
                    	vez que rodar o looping, o valor de anterior sempre sera um antes de atual
                    */
                    dados[atual] = dados[anterior]
                    atual--
                }

                /*
                	Após a posicao requerida pelo o usuario estar valida, passase o valor de dado para
                	aquela posicao e após isso a incrementação do ponteiroFim, para o seu novo fim
                */
                dados[posicaoFisica] = dado
                ponteiroFim++

                /*Verificação para caso a nova posicao de ponteiroFim for igual ao tamanho do array,
                para evitar exceção se passa a nova posicao valida para ele */

                if (ponteiroFim == dados.size) {
                    ponteiroFim = 0
                }
                /*Incrementação de quantidade após o inserir do novo dado */
                quantidade++
            } else {
                print("Indice invalido")
            }
        } else {
            print("List is full")
        }
    }
}
