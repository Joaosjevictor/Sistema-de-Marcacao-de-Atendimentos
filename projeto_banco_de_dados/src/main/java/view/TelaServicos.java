package view;

import javax.swing.*;

import controller.ServicosController;

import java.awt.*;

public class TelaServicos extends JFrame {

    public TelaServicos() {
        setTitle("Invictus - Escolha seu Serviço");
        setSize(540, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ServicosController controller = new ServicosController(this);
        // Usando o fundo limpo para não conflitar com o texto
        PainelFundoBarbearia painel = new PainelFundoBarbearia("/imagem_cadastro.png");
        add(painel);

        // Configurações de estilo
        int xCentro = 100;
        int largura = 340;
        Font fonteBotao = new Font("SansSerif", Font.BOLD, 18);
        Color corBotao = new Color(25, 25, 25);

        // Título da Tela
        JLabel lblTitulo = new JLabel("SELECIONE O SERVIÇO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setBounds(0, 420, 540, 30);
        painel.add(lblTitulo);

        // --- BOTÃO: CABELO ---
        JButton btnCabelo = new JButton("Corte de Cabelo - R$ 25");
        btnCabelo.setBounds(xCentro, 480, largura, 70);
        estilizarBotaoServico(btnCabelo, corBotao, fonteBotao);
        painel.add(btnCabelo);

        // --- BOTÃO: BARBA ---
        JButton btnBarba = new JButton("Barba Completa - R$ 15");
        btnBarba.setBounds(xCentro, 570, largura, 70);
        estilizarBotaoServico(btnBarba, corBotao, fonteBotao);
        painel.add(btnBarba);

        // --- BOTÃO: CABELO + BARBA ---
        JButton btnCombo = new JButton("Cabelo + Barba - R$ 40");
        btnCombo.setBounds(xCentro, 660, largura, 70);
        btnCombo.setBackground(new Color(60, 60, 60)); // Destaque para o combo
        estilizarBotaoServico(btnCombo, null, fonteBotao); 
        painel.add(btnCombo);

        // --- BOTÃO VOLTAR ---
        JButton btnSair = new JButton("Sair / Voltar");
        btnSair.setBounds(xCentro, 800, largura, 40);
        btnSair.setContentAreaFilled(false);
        btnSair.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painel.add(btnSair);

        // Eventos de clique (Exemplo)
        btnCabelo.addActionListener(e -> controller.selecionarServico("Corte de Cabelo"));
        btnBarba.addActionListener(e -> controller.selecionarServico("Barba"));
        btnCombo.addActionListener(e -> controller.selecionarServico("Cabelo + Barba"));
        
        btnSair.addActionListener(e -> {
            this.dispose();
            new TelaLogin().setVisible(true);
        });
    }

    // Método auxiliar para não repetir código de estilo
    private void estilizarBotaoServico(JButton btn, Color cor, Font fonte) {
        if(cor != null) btn.setBackground(cor);
        btn.setForeground(Color.WHITE);
        btn.setFont(fonte);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    public void fecharTela() {
    this.dispose();
    }

    

}