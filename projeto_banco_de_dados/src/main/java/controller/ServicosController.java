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

    public void selecionarServico(String nomeServico) {
        JOptionPane.showMessageDialog(view, "Ótima escolha! Vamos agendar seu " + nomeServico);
        
        view.fecharTela();
        
        TelaAgendamento proximaTela = new TelaAgendamento(nomeServico);
        proximaTela.setVisible(true);
    }

    public List<Servico> listarServicosDisponiveis() {
        ServicoDAO dao = new ServicoDAO();
        return dao.listarTodos();
    }
}