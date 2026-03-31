package controller;

import view.TelaServicos;
import view.TelaAgendamento;
import model.Servico;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ServicoDAO;

public class ServicosController {
    private final TelaServicos view;

    public ServicosController(TelaServicos view) {
        this.view = view;
    }

    // Ação principal: selecionar o serviço e mudar de tela
    public void selecionarServico(String nomeServico) {
        JOptionPane.showMessageDialog(view, "Ótima escolha! Vamos agendar seu " + nomeServico);
        
        // 1. Fecha a tela atual
        view.fecharTela();
        
        // 2. Abre a tela de agendamento passando o serviço escolhido
        TelaAgendamento proximaTela = new TelaAgendamento(nomeServico);
        proximaTela.setVisible(true);
    }

    // Futuramente, este método buscará os dados do Hibernate
    public List<Servico> listarServicosDisponiveis() {
        ServicoDAO dao = new ServicoDAO();
        return dao.listarTodos(); // O Hibernate traz a lista do banco e você entrega para a View
    }
}