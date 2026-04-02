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
        this.view = view;
    }

    public void salvarNovoUsuario() {

        String nome = view.getTxtNome().getText();
        String email = view.getTxtEmail().getText();
        String senha = new String(view.getTxtSenha().getPassword());

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
            JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso! Faça seu login.");
        
            view.dispose();
            new view.TelaLogin().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}   