package pt.ulusofona.cm.kotlin.observerobservable

class LeitorInexistenteException(val msg: String) : Exception() {

    override fun toString(): String {
        return msg // TODO: testar
    }
}
