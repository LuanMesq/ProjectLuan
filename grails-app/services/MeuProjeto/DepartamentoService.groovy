package MeuProjeto

class DepartamentoService {
    // Lista Departamentos, recenoo ID.
    def listaDepartamento() {
        Departamento.list()
    }
    // Lista por id.
    def buscaDepartamento(Long id) {
        Departamento.get(id)
    }
   // Cria o registro de Departamento.
    def criaRegdepartamento(Map departamentoData) {
        def departamento = new Departamento(departamentoData)
        departamento.save()
        departamento
    }
   // Atualiza registro deDepartamento
    def atzDepartamento(Long id, Map departamentoData) {
        def departamento = Departamento.get(id)
        departamento.properties = departamentoData
        departamento.save()
        departamento
    }
  // Deleta.
    def excluir(Long id) {
        def departamento = Departamento.get(id)
        departamento.delete()
        departamento
    }
}