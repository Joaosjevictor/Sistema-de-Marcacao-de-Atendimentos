package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Agendamento;
import controller.AgendamentoController;
import dao.AgendamentoDAO;

public class TelaMeusAgendamentos extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;
    private AgendamentoController controller;

    public TelaMeusAgendamentos() {
        setTitle("Invictus - Meus Agendamentos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Criando a Tabela
        modelo = new DefaultTableModel(new Object[]{"ID", "Serviço", "Data/Hora", "Valor"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // 2. Painel de Botões
        JPanel painelBotoes = new JPanel();
        JButton btnAlterar = new JButton("Alterar Horário");
        JButton btnCancelar = new JButton("Cancelar Agendamento");
        
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnCancelar);
        add(painelBotoes, BorderLayout.SOUTH);

        // 3. Inicializar Controller e Carregar Dados
        // Passamos null na View e no Serviço pois essa tela é só de listagem
        controller = new AgendamentoController(null, null); 
        atualizarTabela();

        // --- AÇÕES ---

        // CANCELAR (DELETE)
        btnCancelar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                int id = (int) modelo.getValueAt(linha, 0);
                controller.excluirAgendamento(id);
                atualizarTabela(); // Recarrega a lista após deletar
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um agendamento na tabela!");
            }
        });

        // ALTERAR (UPDATE)
        btnAlterar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                int id = (int) modelo.getValueAt(linha, 0);
                // 1. Busca o objeto completo no banco pelo ID
                 Agendamento a = new AgendamentoDAO().buscarPorId(id);
        
        // 2. Abre a tela de agendamento passando o objeto (Modo Edição)
                new TelaAgendamento(a, a.getServico().getDescricao()).setVisible(true);
        
                this.dispose(); // Fecha a lista
            }
        });
    }

    public void atualizarTabela() {
        modelo.setNumRows(0); // Limpa a tabela
        dao.AgendamentoDAO dao = new dao.AgendamentoDAO();
        
        // Pega os agendamentos do cliente logado na Sessão
        int clienteId = util.Sessao.getUsuario().getId(); 
        List<Agendamento> lista = dao.listarPorCliente(clienteId);

        for (Agendamento a : lista) {
            modelo.addRow(new Object[]{
                a.getId(), 
                a.getServico().getDescricao(), 
                a.getData().toString(), 
                a.getValor()
            });
        }
    }
}