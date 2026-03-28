package controller;

import view.TelaAgendamento;
import model.Agendamento;
import model.Servico;
import model.Cliente;
import javax.swing.JOptionPane;
import java.util.Date;

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
        
        // 2. Validação básica de campo vazio (máscara incompleta)
        if (dataStr.contains("_")) {
            JOptionPane.showMessageDialog(view, "Erro: Informe uma data válida!");
            return;
        }

        // 3. Montagem do Objeto (Regra de Negócio)
        // Aqui, para o Hibernate, precisaríamos converter String para Date.
        // Por enquanto, vamos simular a criação do objeto Model:
        System.out.println("Processando agendamento...");
        System.out.println("Serviço: " + servicoSelecionado);
        System.out.println("Data/Hora: " + dataStr + " às " + horaStr);

        // 4. Feedback ao usuário
        JOptionPane.showMessageDialog(view, "Agendamento de " + servicoSelecionado + " confirmado para " + dataStr + "!");
        
        // 5. Finalização: Fecha a tela e volta para o início ou para a lista
        view.dispose();
    }
}