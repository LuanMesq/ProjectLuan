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
        def empregadosComDepartamento = empregados.collect { empregado ->
            [
                    id: empregado.id,
                    departamento: [
                            id: empregado.departamento.id,
                            nome: empregado.departamento.nome
                    ],
                    matricula: empregado.matricula,
                    nome: empregado.nome,
                    dataNascimento: empregado.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            ]
        }
        render empregadosComDepartamento as JSON
     //   render empregados as JSON
    }

    def show(Long id) {
        def empregado = empregadoService.BuscIdFunc(id)
        render empregado as JSON
    }

    def save() {
        def empregadoData = request.JSON
        def empregado = empregadoService.CriaRegempregado(empregadoData)
        render empregado as JSON
    }

    def update(Long id) {
        def empregadoData = request.JSON
        def empregado = empregadoService.atzEmpregado(id, empregadoData)
        render empregado as JSON
    }

    def delete(Long id) {
        def empregado = empregadoService.excluir(id)
        render empregado as JSON
    }
}
