package MeuProjeto

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import java.time.format.DateTimeFormatter

@Transactional
class EmpregadoController {

    def EmpregadoService

    def index() {
        def empregados = empregadoService.listarFunc()
        // Ajuste para trazer o nome do Departamento.
        if (empregados) {
            def empregadosComDepartamento = empregados.collect { empregado ->
                [
                        id: empregado.id,
                        departamento: [
                                id: empregado.departamento ? empregado.departamento.id : null,
                                nome: empregado.departamento ? empregado.departamento.nome : null
                        ],
                        matricula: empregado.matricula,
                        nome: empregado.nome,
                        dataNascimento: empregado.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                ]
            }
            render empregadosComDepartamento as JSON
        } else {
            render "Lista de empregados não encontrada."
        }
    }

    def show(Long id) {
        def empregado = empregadoService.BuscIdFunc(id)
        if (empregado) {
            render empregado as JSON
        } else {
            render "Empregado não encontrado."
        }
    }

    def save() {
        def empregadoData = request.JSON
        def empregado = empregadoService.CriaRegempregado(empregadoData)
        if (empregado) {
            render empregado as JSON
        } else {
            render "Erro ao criar o empregado."
        }
    }

    def update(Long id) {
        def empregadoData = request.JSON
        def empregado = empregadoService.atzEmpregado(id, empregadoData)
        if (empregado) {
            render empregado as JSON
        } else {
            render "Erro ao atualizar o empregado."
        }
    }

    def delete(Long id) {
        def empregado = empregadoService.excluir(id)
        if (empregado) {
            render empregado as JSON
        } else {
            render "Erro ao excluir o empregado."
        }
    }
}
