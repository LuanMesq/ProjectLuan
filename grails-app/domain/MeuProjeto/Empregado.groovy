package MeuProjeto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import grails.converters.JSON
import groovy.json.JsonBuilder
import org.springframework.transaction.annotation.Transactional

@Transactional
class Empregado {
    Long id
    String nome
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataNascimento
    Integer matricula

    static belongsTo = [departamento: Departamento]

    // Método utilitário para formatar a data de nascimento
    static {
        JSON.registerObjectMarshaller(LocalDate) { LocalDate date ->
            date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        }
    }

    static constraints = {
        nome blank: false
        dataNascimento nullable: false
        matricula nullable: false
    }

    String toJson() {
        def dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        def dataNascimentoFormatada = dataNascimento.format(dateFormatter)

        def json = new JsonBuilder(this)
        json.dataNascimento = dataNascimentoFormatada
        json.toString()
    }
}
