package controller;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import model.Usuario;
import view.TelaCadastro;

public class UsuarioController {

    private final TelaCadastro view;

    public UsuarioController(TelaCadastro view) {
        this.view = view; // Quando o controller nasce, ele se liga a uma tela
    }

    public void salvarNovoUsuario() {
    // 1. Coleta os dados da View usando os Getters que você criou
    String nome = view.getTxtNome().getText();
    String telefone = view.getTxtTelefone().getText();
    String email = view.getTxtEmail().getText();
    String senha = new String(view.getTxtSenha().getPassword());

    // 2. Validação básica: os campos estão vazios?
    // (O telefone com máscara nunca está vazio, mas podemos checar o nome)
    if (nome.trim().isEmpty() || email.trim().isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos!");
        return;
    }

    // 3. Cria o objeto Model 
    // Como CPF e Data não estão na tela, passamos valores fixos para o teste
    Usuario novoUsuario = new Usuario(
        0, 
        nome, 
        "01/01/2000",   // Data padrão
        "000.000.000-00", // CPF padrão
        email, 
        telefone, 
        senha, 
        "cliente"       // Nível de acesso padrão
    );

    try {
        // 4. Chama o DAO para gravar no PostgreSQL
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(novoUsuario);

        // 5. SUCESSO: Feedback e volta para o Login como você planejou
        JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso! Faça seu login.");
        
        // Navegação: fecha o cadastro e abre o login
        view.dispose();
        new view.TelaLogin().setVisible(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(view, "Erro ao cadastrar: " + e.getMessage());
        e.printStackTrace();
    }
    }
}   