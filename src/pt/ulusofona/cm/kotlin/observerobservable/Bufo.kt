package pt.ulusofona.cm.kotlin.observerobservable

class Bufo(nome: String) : Leitor(nome), OnNumeroListener, OnNoticiaListener {

    var listaNumeros: MutableList<Int> = mutableListOf()
    var listaNoticias: MutableList<Noticia> = mutableListOf()

    fun imprimeNumeros(): String{
        return "$nome leu as seguintes noticias: ${listaNumeros.toString()}"
    }

    fun imprimeNoticias(): String{

        return "$nome leu as seguintes noticias: ${listaNoticias.toString()}"
    }

    override fun onReceiveNoticia(noticia: Noticia) {
        listaNoticias.add(noticia)
    }

    override fun onReceiveNumero(numero: Int) {
        listaNumeros.add(numero)
    }
}
