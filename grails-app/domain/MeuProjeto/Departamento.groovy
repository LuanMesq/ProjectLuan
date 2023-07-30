package MeuProjeto

import org.springframework.transaction.annotation.Transactional

@Transactional
class Departamento {
    Long id
    String nome

    static hasMany = [empregados: Empregado]

    static constraints = {
        nome nullable: false
    }

}
