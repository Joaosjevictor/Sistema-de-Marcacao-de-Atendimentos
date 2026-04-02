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
        int height = (int) (screenSize.height * 0.85);
        int width = (int) (height * 0.56); 
        setSize(width, height);
        setLocationRelativeTo(null);

        LoginController controller = new LoginController(this);

        PainelFundoBarbearia painel = new PainelFundoBarbearia();
        painel.setLayout(null);
        add(painel);

        xCentral = (width - larguraCampo) / 2;   
        int yInicial = (int) (height * 0.50);
        int espacamento = 55;

        JLabel lblTitulo = new JLabel("LOGIN", SwingConstants.CENTER); 
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 26)); 
        lblTitulo.setForeground(Color.BLACK); 

        width = (int) (height * 0.56); 
        lblTitulo.setBounds(0, yInicial - 50, width, 40); 
        painel.add(lblTitulo);

        // --- Campo Usuário ---
        JLabel lblUsuario = new JLabel("E-mail");
        lblUsuario.setForeground(new Color(150, 150, 150)); 
        lblUsuario.setFont(new Font("Serif", Font.BOLD, 14)); 
        lblUsuario.setBounds(xCentral, yInicial, larguraCampo, 20); 
        painel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(xCentral, yInicial + 20, larguraCampo,35); 
        txtUsuario.setBackground(new Color(230, 230, 230));
        txtUsuario.setBorder(null); 
        painel.add(txtUsuario);

        // --- Campo Senha ---
        int ySenha = yInicial + espacamento;
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(new Color(150, 150, 150));
        lblSenha.setFont(new Font("Serif", Font.BOLD, 14));
        lblSenha.setBounds(xCentral, ySenha, larguraCampo, 20);
        painel.add(lblSenha);

        txtSenha = new JPasswordField(); 
        txtSenha.setBounds(xCentral, ySenha + 20, larguraCampo, 35);
        txtSenha.setBackground(new Color(230, 230, 230));
        txtSenha.setBorder(null);
        painel.add(txtSenha);

        // --- Botão Entrar ---
        int yEntrar = ySenha + espacamento + 10;
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(xCentral, yEntrar, larguraCampo, 50);
        btnEntrar.setBackground(new Color(30, 30, 30));
        btnEntrar.setForeground(Color.WHITE); 
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setFocusPainted(false); 
        painel.add(btnEntrar);

        btnEntrar.addActionListener(e -> {
        controller.entrarNoSistema();
        });
        


         // --- Botão Cadastrar ---
        int yCadastrar = yEntrar + 55;
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(xCentral, yCadastrar, larguraCampo, 50);
        btnCadastrar.setBackground(new Color(30, 30, 30)); 
        btnCadastrar.setForeground(Color.WHITE); 
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCadastrar.setFocusPainted(false);
        painel.add(btnCadastrar);
    
        btnCadastrar.addActionListener(e -> {
           controller.abrirTelaCadastro();
            this.dispose(); 
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
