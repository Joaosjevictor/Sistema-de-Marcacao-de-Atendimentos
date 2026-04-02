package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;


public class TelaLogin extends JFrame {


    private JTextField txtUsuario; 
    private JPasswordField txtSenha;
    int xCentral;
    int larguraCampo = 340;

    public TelaLogin() {
        setTitle("Barber Shop - Login");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.height * 0.85); // Usa 85% da altura da tela do usuário
        int width = (int) (height * 0.56); // Mantém a proporção vertical
        setSize(width, height);
        setLocationRelativeTo(null);

        LoginController controller = new LoginController(this);
        // Cria o painel personalizado com o fundo
        PainelFundoBarbearia painel = new PainelFundoBarbearia();
        painel.setLayout(null);
        add(painel);

        xCentral = (width - larguraCampo) / 2; // Centraliza o campo de texto horizontalmente   
        int yInicial = (int) (height * 0.50);
        int espacamento = 55;

        JLabel lblTitulo = new JLabel("LOGIN", SwingConstants.CENTER); // Centraliza o texto no JLabel
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 26)); // Fonte grande e elegante
        lblTitulo.setForeground(Color.BLACK); // Texto branco para contrastar com o fundo

        width = (int) (height * 0.56); // Recuperando a largura para o setBounds
        lblTitulo.setBounds(0, yInicial - 50, width, 40); 
        painel.add(lblTitulo);

        // --- Campo Usuário ---
        JLabel lblUsuario = new JLabel("E-mail");
        lblUsuario.setForeground(new Color(150, 150, 150)); // Texto branco
        lblUsuario.setFont(new Font("Serif", Font.BOLD, 14)); // Fonte elegante
        lblUsuario.setBounds(xCentral, yInicial, larguraCampo, 20); // Posiciona
        painel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(xCentral, yInicial + 20, larguraCampo,35); // Posiciona
        txtUsuario.setBackground(new Color(230, 230, 230));
        txtUsuario.setBorder(null); // Remove a borda padrão para um visual limpo
        painel.add(txtUsuario);

        // --- Campo Senha ---
        int ySenha = yInicial + espacamento;
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(new Color(150, 150, 150));
        lblSenha.setFont(new Font("Serif", Font.BOLD, 14));
        lblSenha.setBounds(xCentral, ySenha, larguraCampo, 20);
        painel.add(lblSenha);

        txtSenha = new JPasswordField(); // Campo específico para senhas
        txtSenha.setBounds(xCentral, ySenha + 20, larguraCampo, 35);
        txtSenha.setBackground(new Color(230, 230, 230));
        txtSenha.setBorder(null);
        painel.add(txtSenha);

        // --- Botão Entrar ---
        int yEntrar = ySenha + espacamento + 10;
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(xCentral, yEntrar, larguraCampo, 50);
        btnEntrar.setBackground(new Color(30, 30, 30)); // Cinza claro
        btnEntrar.setForeground(Color.WHITE); // Texto preto
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setFocusPainted(false); // Remove a borda de foco ao clicar
        painel.add(btnEntrar);

        btnEntrar.addActionListener(e -> {
        controller.entrarNoSistema();
        });
        


         // --- Botão Cadastrar ---
        int yCadastrar = yEntrar + 55;
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(xCentral, yCadastrar, larguraCampo, 50);
        btnCadastrar.setBackground(new Color(30, 30, 30)); // Cinza claro
        btnCadastrar.setForeground(Color.WHITE); // Texto preto
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCadastrar.setFocusPainted(false); // Remove a borda de foco ao clicar
        painel.add(btnCadastrar);
    
        // Ação do botão Cadastrar para abrir a tela de cadastro
        btnCadastrar.addActionListener(e -> {
           controller.abrirTelaCadastro();
            this.dispose(); // Fecha a tela de login
        });

          
    }

    public JTextField getTxtUsuario() {
    return txtUsuario;
    }

    public JPasswordField getTxtSenha() {
    return txtSenha;
    }   

    public static void main(String[] args) {
        new TelaLogin().setVisible(true);
    }
}
