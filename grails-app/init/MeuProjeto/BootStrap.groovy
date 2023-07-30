package MeuProjeto

import org.springframework.transaction.annotation.Transactional

@Transactional
class BootStrap {

    def inicializacaoService
    def init = { servletContext ->
        // Chama o método de inicialização do serviço InicializacaoService
       inicializacaoService.init()
    }

     def destroy() {
         Empregado.deleteAll()
         Departamento.deleteAll()
     }
}