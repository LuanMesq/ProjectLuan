package MeuProjeto

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import static java.time.LocalDate.parse

class EmpregadoService {
    // Lista Funcionário.
    def listarFunc() {
        Empregado.list()
    }
   // Busca o Empregado de acordo com o ID.
    def BuscIdFunc(Long id) {
        Empregado.get(id)
    }
   // Cria o registro de empregado, recebendo os novos dados e salvando.
    def CriaRegempregado(Map empregadoData) {
        def empregado = new Empregado(
            nome: empregadoData.nome,
            dataNascimento: parseDataNascimento(empregadoData.dataNascimento),
            matricula: empregadoData.matricula,
            departamento: empregadoData.departamento
        )
        empregado.save()
        empregado
    }
   // Formata a data de entrada dd/mm/yyyy.
    private static LocalDate parseDataNascimento(String dataNascimento) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return parse(dataNascimento, dateFormatter)
    }

  //  Atualiza os registros, recebendo os novos dados. e salvando.
    def atzEmpregado(Long id, Map empregadoData) {
        def empregado = Empregado.get(id)
        empregadoData.dataNascimento = LocalDate.parse(empregadoData.dataNascimento, DateTimeFormatter.ofPattern('dd/MM/yyyy'))
        empregado.properties = empregadoData
        empregado.save()
        empregado
    }
  // Delete do registro, de acordo com o id.
    def excluir(Long id) {
        def empregado = Empregado.get(id)
        empregado.delete()
        empregado
    }
}
