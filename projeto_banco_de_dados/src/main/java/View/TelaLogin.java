package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Barber Shop - Login");
        setSize(400, 550); // Ajuste para o tamanho da sua imagem
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        // Cria o painel personalizado com o fundo
        PainelFundoBarbearia painel = new PainelFundoBarbearia();
        add(painel);

        // --- Campo Usuário ---
        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setForeground(Color.WHITE); // Texto branco
        lblUsuario.setFont(new Font("Serif", Font.BOLD, 14)); // Fonte elegante
        lblUsuario.setBounds(100, 180, 200, 20); // Posiciona
        painel.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 200, 200, 30); // Posiciona
        txtUsuario.setBorder(null); // Remove a borda padrão para um visual limpo
        painel.add(txtUsuario);

        // --- Campo Senha ---
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Serif", Font.BOLD, 14));
        lblSenha.setBounds(100, 240, 200, 20);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField(); // Campo específico para senhas
        txtSenha.setBounds(100, 260, 200, 30);
        txtSenha.setBorder(null);
        painel.add(txtSenha);

        // --- Botão Entrar ---
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(100, 310, 200, 40);
        btnEntrar.setBackground(new Color(200, 200, 200)); // Cinza claro
        btnEntrar.setForeground(Color.BLACK); // Texto preto
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setFocusPainted(false); // Remove a borda de foco ao clicar
        painel.add(btnEntrar);
    }

    public static void main(String[] args) {
        new TelaLogin().setVisible(true);
    }
}
