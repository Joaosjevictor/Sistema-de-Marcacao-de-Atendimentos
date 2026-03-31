package controller;

import view.TelaAgendamento;
import model.Agendamento;
import model.Servico;
import model.Cliente;
import javax.swing.JOptionPane;

import dao.AgendamentoDAO;
import dao.ClienteDAO;
import dao.ServicoDAO;

import java.util.List;

public class AgendamentoController {
    private final TelaAgendamento view;
    private String servicoSelecionado; // Para saber o que foi escolhido

    public AgendamentoController(TelaAgendamento view, String servicoSelecionado) {
        this.view = view;
        this.servicoSelecionado= servicoSelecionado;
    }

    public void confirmarAgendamento() {
        // 1. Coleta os dados da View
        String dataStr = view.getTxtData().getText();
        String horaStr = (String) view.getComboHoras().getSelectedItem();
        String dataEHora = dataStr + " " + horaStr;
        
        // 2. Validação básica de campo vazio (máscara incompleta)
        if (dataStr.contains("_")) {
            JOptionPane.showMessageDialog(view, "Erro: Informe uma data válida!");
            return;
        }       

        try {
        ClienteDAO clienteDAO = new ClienteDAO();
        ServicoDAO servicoDAO = new ServicoDAO();

        model.Usuario usuarioLogado = util.Sessao.getUsuario();


        Cliente clienteSelecionado = clienteDAO.buscarPorEmail(usuarioLogado.getEmail());

        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(view, "Erro: Perfil de cliente não encontrado para este usuário!");
            return;
        }

        // 2. Use a variável correta que veio do construtor (nomeServicoSelecionado ou similar)
        // Se no topo da sua classe o nome for diferente, ajuste aqui:
        Servico servicoSelecionado = servicoDAO.buscarPorDescricao(this.servicoSelecionado);

        // 3. REMOVIDAS as labels "id:", "status:", etc. 
        // Passamos apenas as variáveis na ordem correta do construtor
        Agendamento novoAgendamento = new Agendamento(
            0, 
            clienteSelecionado, 
            servicoSelecionado, 
            (float) servicoSelecionado.getPreco(), 
            dataEHora, 
            false
        );

        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.salvar(novoAgendamento);

        JOptionPane.showMessageDialog(view, "Agendamento realizado para " + dataEHora);
        view.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao salvar agendamento: " + e.getMessage());
            e.printStackTrace();
        }
    }
}    