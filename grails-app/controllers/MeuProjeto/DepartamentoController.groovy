package MeuProjeto

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoController {

    def departamentoService

    def index() {
        def departamentos = departamentoService.listaDepartamento()
        // Somente os departamentos, sem o relacionamento.
        if (departamentos) {
            def departamentosComDadosBasicos = departamentos.collect { departamento ->
                [
                        id: departamento.id,
                        nome: departamento.nome
                ]
            }
            render departamentosComDadosBasicos as JSON
        } else {
            render "Lista de departamentos não encontrada."
        }
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
        } else {
            render "Lista de departamentos não encontrada."
        }
    }

    def save() {
        def departamentoData = request.JSON
        def departamento = departamentoService.criaRegdepartamento(departamentoData)
        if (departamento) {
            render departamento as JSON
        } else {
            render "Erro ao criar o departamento."
        }
    }

    def update(Long id) {
        def departamentoData = request.JSON
        def departamento = departamentoService.atzDepartamento(id, departamentoData)
        if (departamento) {
            render departamento as JSON
        } else {
            render "Erro ao atualizar o departamento."
        }
    }

    def delete(Long id) {
        def departamento = departamentoService.excluir(id)
        if (departamento) {
            render departamento as JSON
        } else {
            render "Erro ao excluir o departamento."
        }
    }
}

