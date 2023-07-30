package MeuProjeto

import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Transactional
class InicializacaoService {
    def init() {
        // Inicializa os Departamentos e salva no banco de dados H2.
        def departamentoSup = new Departamento(nome: "Suporte").save(failOnError: true)
        def departamentoDev = new Departamento(nome: "Desenvolvimento").save(failOnError: true)

        // Cria e vincula os Empregados aos Departamentos
        def empregado1 = new Empregado(nome: "Siqueirão", dataNascimento: LocalDate.of(1995, 11, 20), matricula: 150)
        empregado1.departamento = departamentoDev
        empregado1.save(failOnError: true)

        def empregado2 = new Empregado(nome: "João - Não é Groovy", dataNascimento: LocalDate.of(2001, 8, 21), matricula: 151)
        empregado2.departamento = departamentoDev
        empregado2.save(failOnError: true)

        def empregado3 = new Empregado(nome: "Felipe", dataNascimento: LocalDate.of(1980, 6, 5), matricula: 152)
        empregado3.departamento = departamentoDev
        empregado3.save(failOnError: true)

        def empregado4 = new Empregado(nome: "Ricardo", dataNascimento: LocalDate.of(1998, 3, 5), matricula: 153)
        empregado4.departamento = departamentoSup
        empregado4.save(failOnError: true)

        def empregado5 = new Empregado(nome: "Luan", dataNascimento: LocalDate.of(2004, 3, 22), matricula: 154)
        empregado5.departamento = departamentoSup
        empregado5.save(failOnError: true)
    }
}