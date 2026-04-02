package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controller.AgendamentoController;
import model.Agendamento;

import java.awt.*;
import java.text.ParseException;

public class TelaAgendamento extends JFrame {

    private JFormattedTextField txtData;
    private JComboBox<String> comboHoras;
    private JButton btnFinalizar;
    private Agendamento agendamentoExistente = null;

    public TelaAgendamento(String servicoSelecionado) {
        setTitle("Invictus - Agendar Horário");
        setSize(540, 960);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        AgendamentoController controller = new AgendamentoController(this, servicoSelecionado);

        PainelFundoBarbearia painel = new PainelFundoBarbearia("/imagem_fundo.png");
        add(painel);

        // Estilo padrão
        int xCentro = 100;
        int largura = 340;
        Color corTexto = new Color(150, 150, 150);
        Font fonteLabel = new Font("SansSerif", Font.BOLD, 14);

        // Título com o serviço escolhido
        JLabel lblServico = new JLabel("AGENDANDO: " + servicoSelecionado.toUpperCase());
        lblServico.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblServico.setBounds(0, 420, 540, 30);
        lblServico.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(lblServico);

        // --- SELEÇÃO DE DATA ---
        JLabel lblData = new JLabel("DATA (DD/MM/AAAA)");
        lblData.setForeground(corTexto);
        lblData.setFont(fonteLabel);
        lblData.setBounds(xCentro, 480, largura, 20);
        painel.add(lblData);

        txtData = new JFormattedTextField();
        try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
            mascaraData.install(txtData);
        } catch (ParseException e) { e.printStackTrace(); }
        
        txtData.setBounds(xCentro, 505, largura, 45);
        txtData.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtData.setBorder(null);
        txtData.setBackground(new Color(235, 235, 235));
        painel.add(txtData);

        // --- SELEÇÃO DE HORÁRIO ---
        JLabel lblHora = new JLabel("HORÁRIOS DISPONÍVEIS");
        lblHora.setForeground(corTexto);
        lblHora.setFont(fonteLabel);
        lblHora.setBounds(xCentro, 580, largura, 20);
        painel.add(lblHora);

        String[] horarios = {"09:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        comboHoras = new JComboBox<>(horarios);
        comboHoras.setBounds(xCentro, 605, largura, 45);
        comboHoras.setBackground(Color.WHITE);
        comboHoras.setFont(new Font("SansSerif", Font.PLAIN, 16));
        painel.add(comboHoras);

        // --- BOTÃO FINALIZAR ---
        btnFinalizar = new JButton("Confirmar Agendamento");
        btnFinalizar.setBounds(xCentro, 680, largura, 60);
        btnFinalizar.setBackground(new Color(25, 25, 25));
        btnFinalizar.setForeground(Color.WHITE);
        btnFinalizar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnFinalizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painel.add(btnFinalizar);

         btnFinalizar.addActionListener(e -> {
            controller.confirmarAgendamento();
        });  

        // --- BOTÃO VOLTAR ---
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(xCentro, 760, largura, 60);
        btnVoltar.setBackground(new Color(25, 25, 25));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painel.add(btnVoltar);

         btnVoltar.addActionListener(e -> {
            this.dispose();
            new TelaServicos().setVisible(true);
        });
    }

    public TelaAgendamento(Agendamento agendamento, String servicoNome) {
        this(servicoNome); 
        this.agendamentoExistente = agendamento;
    
        java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.txtData.setText(agendamento.getData().format(formato));
    
        String hora = agendamento.getData().getHour() + ":00"; 
        this.comboHoras.setSelectedItem(hora);
    
        this.btnFinalizar.setText("Salvar Alteração");
    }

  
    public Agendamento getAgendamentoExistente() {
        return agendamentoExistente;
    }

    public JFormattedTextField getTxtData() {
        return txtData;
    }

    public JComboBox<String> getComboHoras() {
        return comboHoras;
    }

    
}
