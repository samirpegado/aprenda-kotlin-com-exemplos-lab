class Usuario(val nome: String, val email: String){
    override fun toString(): String {
        return "Usuario(nome='$nome', email='$email')"
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun listarConteudos(){
        println("Conteudos da Formacao $nome:")
        for (conteudo in conteudos){
            println(" - ${conteudo.nome}, Duracao: ${conteudo.duracao}h ")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Fundamentos do Koltin", 60)
    val conteudo2 = ConteudoEducacional("Programacao Orientada a Objetos", 100)
    
    val usuario1 = Usuario("Jose", "jose@mail.com")
    val usuario2 = Usuario("Maria", "maria@mail.com")
    
    val formacao = Formacao("Kotlin Backend", mutableListOf(conteudo1, conteudo2))
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    println("${usuario1.toString()} está inscrito na formação ${formacao.nome}")
    println("${usuario2.toString()} está inscrito na formação ${formacao.nome}")

    formacao.listarConteudos()
}
