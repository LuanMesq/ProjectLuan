package MeuProjeto

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoController {

    def departamentoService

    def index() {
        def departamentos = departamentoService.listaDepartamento()
        // Somente os departamentos, sem o relacionamento.
        def departamentosComDadosBasicos = departamentos.collect { departamento ->
            [
                    id: departamento.id,
                    nome: departamento.nome
            ]
        }
        render departamentosComDadosBasicos as JSON
    }

    def show(Long id) {
        def departamento = departamentoService.buscaDepartamento(id)
        // Somente os departamentos, sem o relacionamento.
        if (departamento) {
            def departamentoSimplificado = [
                    id: departamento.id,
                    nome: departamento.nome
            ]
            render departamentoSimplificado as JSON
        }
    }

    def save() {
        def departamentoData = request.JSON
        def departamento = departamentoService.criaRegdepartamento(departamentoData)
        render departamento as JSON
    }

    def update(Long id) {
        def departamentoData = request.JSON
        def departamento = departamentoService.atzDepartamento(id, departamentoData)
        render departamento as JSON
    }

    def delete(Long id) {
        def departamento = departamentoService.excluir(id)
        render departamento as JSON
    }
}

