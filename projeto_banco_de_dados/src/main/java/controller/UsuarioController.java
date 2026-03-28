package controller;

import javax.swing.JOptionPane;

import model.Usuario;
import view.TelaCadastro;

public class UsuarioController {

    private final TelaCadastro view;

    public UsuarioController(TelaCadastro view) {
        this.view = view; // Quando o controller nasce, ele se liga a uma tela
    }

    public void salvarNovoUsuario() {
        // 1. Coleta
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();
        String senha = new String(view.getTxtSenha().getPassword());

    // 2. Validação simples (Antes de usarmos o Hibernate)
    if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
        return; // Para a execução aqui se houver erro
    }

    // 3. Transformação: Cria o objeto Usuario (O seu Model!)
    // Aqui usamos o construtor que você criou na classe Usuario
    // Como ainda não temos o ID do banco, passamos 0 ou null
    Usuario novoUsuario = new Usuario(0, "João", "01/01/2000", "123.456.789-00", "joao@gmail.com", "87 9 999-999", "senha", "cliente");

    // 4. Feedback (Enquanto não temos o DAO)
    System.out.println("Objeto pronto para o Hibernate: " + novoUsuario.toString());
    
    JOptionPane.showMessageDialog(view, "Usuário " + nome + " preparado para o banco!");
    }
}