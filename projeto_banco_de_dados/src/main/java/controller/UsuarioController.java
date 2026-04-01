package controller;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import dao.ClienteDAO;
import model.Usuario;
import model.Cliente;
import view.TelaCadastro;

public class UsuarioController {

    private final TelaCadastro view;

    public UsuarioController(TelaCadastro view) {
        this.view = view; // Quando o controller nasce, ele se liga a uma tela
    }

    public void salvarNovoUsuario() {
    // 1. Coleta os dados da View usando os Getters que você criou
    String nome = view.getTxtNome().getText();
    String email = view.getTxtEmail().getText();
    String senha = new String(view.getTxtSenha().getPassword());

    // 2. Validação básica: os campos estão vazios?
    // (O telefone com máscara nunca está vazio, mas podemos checar o nome)
    if (nome.trim().isEmpty() || email.trim().isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos!");
        return;
    }

   

    try {
        Usuario novoUsuario = new Usuario(0, nome, email, senha, "cliente");
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(novoUsuario);
    
        Cliente novoCliente = new Cliente(0, nome, email, "Endereço Padrão");
        ClienteDAO cDao = new ClienteDAO();
        cDao.salvar(novoCliente);
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