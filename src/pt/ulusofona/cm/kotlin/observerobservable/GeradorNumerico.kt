package pt.ulusofona.cm.kotlin.observerobservable


class GeradorNumerico(var maxLeitores: Int, private var listaNumeros: MutableList<Int>) { //TODO

    private val listaLeitoresRegistados: MutableList<OnNumeroListener> = mutableListOf()

    fun adicionarLeitor(leitor: OnNumeroListener){
        if (listaLeitoresRegistados.size<maxLeitores){
            listaLeitoresRegistados.add(leitor)
        }else{
            throw LimiteDeLeitoresAtingidoException("GeradorNumerico atingiu o número máximo de leitores: $maxLeitores")
        }
    }

    fun removerLeitor(leitor: OnNoticiaListener){

        var count: Int = 0

        listaLeitoresRegistados.forEach{
            if (it==leitor){
                listaLeitoresRegistados.remove(it)
            }else{
                count++
                if (count==listaLeitoresRegistados.size) {
                    throw LeitorInexistenteException("Este leitor não está registado!")
                }
            }
        }

    }

    private fun notificarLeitores(){
        listaLeitoresRegistados.forEach{
            it.onReceiveNumero(listaNumeros.last())
        }
    }

    fun iniciar(){
        notificarLeitores()
    }
}
