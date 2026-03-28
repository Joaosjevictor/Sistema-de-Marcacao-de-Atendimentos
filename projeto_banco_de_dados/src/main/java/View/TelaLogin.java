package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;


public class TelaLogin extends JFrame {

    int xCentral = 100;
    int larguraCampo = 340;

    public TelaLogin() {
        setTitle("Barber Shop - Login");
        /*setSize(540, 960); // Ajuste para o tamanho da sua imagem
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(nul l); // Centraliza na tela*/
        // No construtor da TelaLogin ou TelaCadastro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.height * 0.85); // Usa 85% da altura da tela do usuário
        int width = (int) (height * 0.56); // Mantém a proporção vertical
        setSize(width, height);

        // Cria o painel personalizado com o fundo
        PainelFundoBarbearia painel = new PainelFundoBarbearia();
        add(painel);

        /*JLabel lblTitulo = new JLabel("LOGIN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setBounds(0, 420, 540, 30);
        painel.add(lblTitulo);*/

        // --- Campo Usuário ---
        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setForeground(new Color(150, 150, 150)); // Texto branco
        lblUsuario.setFont(new Font("Serif", Font.BOLD, 14)); // Fonte elegante
        lblUsuario.setBounds(xCentral, 600, larguraCampo, 20); // Posiciona
        painel.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(xCentral, 625, larguraCampo, 40); // Posiciona
        txtUsuario.setBackground(new Color(230, 230, 230));
        txtUsuario.setBorder(null); // Remove a borda padrão para um visual limpo
        painel.add(txtUsuario);

        // --- Campo Senha ---
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(new Color(150, 150, 150));
        lblSenha.setFont(new Font("Serif", Font.BOLD, 14));
        lblSenha.setBounds(xCentral, 690, larguraCampo, 20);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField(); // Campo específico para senhas
        txtSenha.setBounds(xCentral, 715, larguraCampo, 40);
        txtSenha.setBackground(new Color(230, 230, 230));
        txtSenha.setBorder(null);
        painel.add(txtSenha);

        // --- Botão Entrar ---
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(xCentral, 780, larguraCampo, 55);
        btnEntrar.setBackground(new Color(30, 30, 30)); // Cinza claro
        btnEntrar.setForeground(Color.WHITE); // Texto preto
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setFocusPainted(false); // Remove a borda de foco ao clicar
        painel.add(btnEntrar);

        btnEntrar.addActionListener(e -> {
            new TelaServicos().setVisible(true);
            this.dispose(); // Fecha a tela de login
        });

         // --- Botão Cadastrar ---
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(xCentral, 850, larguraCampo, 55);
        btnCadastrar.setBackground(new Color(30, 30, 30)); // Cinza claro
        btnCadastrar.setForeground(Color.WHITE); // Texto preto
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCadastrar.setFocusPainted(false); // Remove a borda de foco ao clicar
        painel.add(btnCadastrar);
    
        // Ação do botão Cadastrar para abrir a tela de cadastro
        btnCadastrar.addActionListener(e -> {
            new TelaCadastro().setVisible(true);
            this.dispose(); // Fecha a tela de login
        });

          
    }

    public static void main(String[] args) {
        new TelaLogin().setVisible(true);
    }
}
