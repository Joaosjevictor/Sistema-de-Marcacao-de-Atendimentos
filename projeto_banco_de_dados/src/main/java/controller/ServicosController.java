package controller;

import view.TelaServicos;
import view.TelaAgendamento;
import model.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicosController {
    private final TelaServicos view;

    public ServicosController(TelaServicos view) {
        this.view = view;
    }

    // Ação principal: selecionar o serviço e mudar de tela
    public void selecionarServico(String nomeServico) {
        System.out.println("Serviço selecionado: " + nomeServico);
        
        // 1. Fecha a tela atual
        view.fecharTela();
        
        // 2. Abre a tela de agendamento passando o serviço escolhido
        TelaAgendamento proximaTela = new TelaAgendamento(nomeServico);
        proximaTela.setVisible(true);
    }

    // Futuramente, este método buscará os dados do Hibernate
    public List<Servico> listarServicosDisponiveis() {
        // Exemplo de como o Controller entregará os dados para a View depois
        List<Servico> lista = new ArrayList<>();
        // lista = servicoDAO.buscarTodos();
        return lista;
    }
}