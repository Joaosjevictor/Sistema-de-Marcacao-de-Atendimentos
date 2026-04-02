package controller;

import view.TelaAgendamento;
import model.Agendamento;
import model.Servico;
import model.Cliente;
import javax.swing.JOptionPane;
import dao.AgendamentoDAO;
import dao.ClienteDAO;
import dao.ServicoDAO;

public class AgendamentoController {
    private final TelaAgendamento view;
    private String servicoSelecionado; 

    public AgendamentoController(TelaAgendamento view, String servicoSelecionado) {
        this.view = view;
        this.servicoSelecionado = servicoSelecionado;
    }

    public void confirmarAgendamento() {
        String dataStr = view.getTxtData().getText();
        String horaStr = (String) view.getComboHoras().getSelectedItem();
        String dataEHora = dataStr + " " + horaStr;
        
        if (dataStr.contains("_")) {
            JOptionPane.showMessageDialog(view, "Erro: Informe uma data válida!");
            return;
        }       

        try {
            java.time.format.DateTimeFormatter parser = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            java.time.LocalDateTime dataDigitada = java.time.LocalDateTime.parse(dataEHora, parser);
            java.time.LocalDateTime agora = java.time.LocalDateTime.now();

        if (dataDigitada.isBefore(agora)) {
            JOptionPane.showMessageDialog(view, "🚫 Erro: Não é possível agendar horários no passado!\n" 
                                              + "Escolha uma data e hora posterior a: " 
                                              + agora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM HH:mm")));
            return; 
        }
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            Agendamento agendamentoDaTela = view.getAgendamentoExistente();

            if (agendamentoDaTela != null) {
                // --- UPDATE  ---
                agendamentoDaTela.setDataHora(dataEHora);
                agendamentoDAO.atualizar(agendamentoDaTela);
                JOptionPane.showMessageDialog(view, "Agendamento atualizado com sucesso!");
            } 
            else {
                // --- CREATE  ---
                ClienteDAO clienteDAO = new ClienteDAO();
                ServicoDAO servicoDAO = new ServicoDAO();
                model.Usuario usuarioLogado = util.Sessao.getUsuario();

                Cliente cliente = clienteDAO.buscarPorEmail(usuarioLogado.getEmail());
                Servico servico = servicoDAO.buscarPorDescricao(this.servicoSelecionado);

                if (cliente == null || servico == null) {
                    JOptionPane.showMessageDialog(view, "Erro ao localizar Cliente ou Serviço!");
                    return;
                }

                Agendamento novo = new Agendamento(0, cliente, servico, (float) servico.getPreco(), dataEHora, false);
                agendamentoDAO.salvar(novo);
                JOptionPane.showMessageDialog(view, "Agendamento realizado com sucesso!");
            }
            
            limparCampos(); 
       
        }catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(view, "Erro: Formato de data inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro na operação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void excluirAgendamento(int id) {
        int resposta = JOptionPane.showConfirmDialog(view, "Deseja realmente cancelar este agendamento?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if (new AgendamentoDAO().deletar(id)) {
                JOptionPane.showMessageDialog(view, "Agendamento removido!");
            }
        }
    }


    private void limparCampos() {
        view.getTxtData().setText(""); 
        view.getComboHoras().setSelectedIndex(0); 
    }
    
}