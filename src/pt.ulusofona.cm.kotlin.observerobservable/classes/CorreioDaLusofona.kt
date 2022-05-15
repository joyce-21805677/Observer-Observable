package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(val maxLeitores: Int, private var listaNoticias: MutableList<Noticia>) { //TODO

    private val listaLeitoresRegistados: MutableList<OnNoticiaListener> = mutableListOf()

    fun adicionarLeitor(leitor: OnNoticiaListener){
        if (listaLeitoresRegistados.size<maxLeitores){
            listaLeitoresRegistados.add(leitor)
        }else{
            throw LimiteDeLeitoresAtingidoException("CorreioDaLusofona atingiu o número máximo de leitores: $maxLeitores")
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
            it.onReceiveNoticia(listaNoticias.last())
        }
    }

    fun iniciar(){
        notificarLeitores()
    }
}
