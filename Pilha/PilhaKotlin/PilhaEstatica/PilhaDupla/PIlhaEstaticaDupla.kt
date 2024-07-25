class PilhaEstaticaDupla : DuplamenteEmpilhavel {

    private var ponteiroTopo1: Int
    private var ponteiroTopo2: Int
    private var dados: Array<Any?>
    // contrutores
    constructor() : this(10) {}

    constructor(tamanho: Int) {
        ponteiroTopo1 = -1
        ponteiroTopo2 = tamanho
        dados = arrayOfNulls(tamanho)
    }

    override fun empilhar1(dado1: Any?) {
        if (!estaCheia1()) {
            ponteiroTopo1++
            dados[ponteiroTopo1] = dado1
        } else {
            println("The stack is full")
        }
    }

    override fun empilhar2(dado2: Any?) {
        if (!estaCheia2()) {
            ponteiroTopo2--
            dados[ponteiroTopo2] = dado2
        } else {
            println("The stack is full")
        }
    }

    override fun desempilhar1(): Any? {
        var retorno: Any? = null
        if (!estaVazia1()) {
            retorno = dados[ponteiroTopo1]
            ponteiroTopo1--
        } else {
            println("The Stack is empty")
        }
        return retorno
    }

    override fun desempilhar2(): Any? {
        var retorno: Any? = null
        if (!estaVazia2()) {
            retorno = dados[ponteiroTopo2]
            ponteiroTopo2++
        } else {
            println("The stack is empty")
        }

        return retorno
    }

    override fun topo1(): Any? {
        var retorno: Any? = null
        if (!estaVazia1()) {
            retorno = dados[ponteiroTopo1]
        } else {
            println("The stack is empty")
        }
        return retorno
    }

    override fun topo2(): Any? {
        var retorno: Any? = null
        if (!estaVazia2()) {
            retorno = dados[ponteiroTopo2]
        } else {
            println("The stack is empty")
        }
        return retorno
    }

    override fun estaCheia1(): Boolean {
        // Esta cheio da PIlha Estatica
        return (ponteiroTopo1 == ponteiroTopo2 - 1)
    }

    override fun estaCheia2(): Boolean {
        // return (ponteiroTopo2 == ponteiroTopo1+1)
        return estaCheia1()
    }

    override fun estaVazia1(): Boolean {
        return (ponteiroTopo1 == -1)
    }

    override fun estaVazia2(): Boolean {
        return (ponteiroTopo2 == dados.size)
    }

    override fun imprimir1(): String {
        var resultado: String = "["

        for (i in ponteiroTopo1 downTo 0) {
            if (i == 0) {
                resultado += "${(dados[i])}"
            } else {
                resultado += "${dados[i]},"
            }
        }

        return "${resultado}]"
    }

    override fun imprimir2(): String {
        var resultado: String = "["

        for (i in ponteiroTopo2..dados.size - 1) {
            if (i == dados.size - 1) {
                resultado += "${(dados[i])}"
            } else {
                resultado += "${dados[i]},"
            }
        }

        return "${resultado}]"
    }
}
