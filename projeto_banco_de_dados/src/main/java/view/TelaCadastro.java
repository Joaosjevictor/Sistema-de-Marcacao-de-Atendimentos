package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controller.UsuarioController;

import java.awt.*;
import java.text.ParseException;

public class TelaCadastro extends JFrame {

    private JTextField txtNome; 
    private JFormattedTextField txtTelefone;
    private JTextField txtEmail;
    private JPasswordField txtSenha;

    public TelaCadastro() {
        setTitle("Invictus - Cadastro de Cliente");
        /*setSize(540, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);*/
        // No construtor da TelaLogin ou TelaCadastro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.height * 0.85); // Usa 85% da altura da tela do usuário
        int width = (int) (height * 0.56); // Mantém a proporção vertical
        setSize(width, height); 

        UsuarioController controller = new UsuarioController(this);

        // Reutiliza o painel de fundo que você já criou
        PainelFundoBarbearia painel = new PainelFundoBarbearia("/imagem_cadastro.png");
        add(painel);

        // Configurações comuns de estilo
        Color corTexto = new Color(150, 150, 150);
        Font fonteLabel = new Font("SansSerif", Font.BOLD, 14);
        int xCentro = 100;
        int largura = 340;

        // --- CAMPO NOME ---
        JLabel lblNome = new JLabel("NOME COMPLETO");
        lblNome.setForeground(corTexto);
        lblNome.setFont(fonteLabel);
        lblNome.setBounds(xCentro, 450, largura, 20); // Começa mais alto (450)
        painel.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(xCentro, 475, largura, 40);
        txtNome.setBorder(null);
        txtNome.setBackground(new Color(235, 235, 235));
        painel.add(txtNome);

        // --- CAMPO TELEFONE (Com Máscara) ---
        JLabel lblTelefone = new JLabel("TELEFONE");
        lblTelefone.setForeground(corTexto);
        lblTelefone.setFont(fonteLabel);
        lblTelefone.setBounds(xCentro, 530, largura, 20);
        painel.add(lblTelefone);

        txtTelefone = new JFormattedTextField();
        try {
            // Máscara para telefone brasileiro: (##) #####-####
            MaskFormatter mascara = new MaskFormatter("(##) #####-####");
            mascara.install(txtTelefone);
        } catch (ParseException e) { e.printStackTrace(); }
        
        txtTelefone.setBounds(xCentro, 555, largura, 40);
        txtTelefone.setBorder(null);
        txtTelefone.setBackground(new Color(235, 235, 235));
        painel.add(txtTelefone);

        // --- CAMPO E-MAIL ---
        JLabel lblEmail = new JLabel("E-MAIL");
        lblEmail.setForeground(corTexto);
        lblEmail.setFont(fonteLabel);
        lblEmail.setBounds(xCentro, 610, largura, 20);
        painel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(xCentro, 635, largura, 40);
        txtEmail.setBorder(null);
        txtEmail.setBackground(new Color(235, 235, 235));
        painel.add(txtEmail);

        // --- CAMPO SENHA ---
        JLabel lblSenha = new JLabel("SENHA");
        lblSenha.setForeground(corTexto);
        lblSenha.setFont(fonteLabel);
        lblSenha.setBounds(xCentro, 690, largura, 20);
        painel.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(xCentro, 715, largura, 40);
        txtSenha.setBorder(null);
        txtSenha.setBackground(new Color(235, 235, 235));
        painel.add(txtSenha);

        // --- BOTÃO CADASTRAR ---
        JButton btnCadastrar = new JButton("CRIAR CONTA");
        btnCadastrar.setBounds(xCentro, 790, largura, 55);
        btnCadastrar.setBackground(new Color(25, 25, 25));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painel.add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            controller.salvarNovoUsuario();
        });

        // --- BOTÃO VOLTAR (Para o Login) ---
        JButton btnVoltar = new JButton("VOLTAR PARA O LOGIN");
        btnVoltar.setBounds(xCentro, 860, largura, 30);
        btnVoltar.setContentAreaFilled(false); // Transparente
        btnVoltar.setBorderPainted(false);      // Sem borda
        btnVoltar.setForeground(new Color(100, 100, 100));
        btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        painel.add(btnVoltar);

        // Lógica para voltar
        btnVoltar.addActionListener(e -> {
            this.dispose();
            new TelaLogin().setVisible(true);
        });
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JFormattedTextField getTxtTelefone() {
        return txtTelefone;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }


    
}