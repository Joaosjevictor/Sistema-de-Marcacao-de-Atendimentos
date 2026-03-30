package app;

import view.TelaCadastro;
import model.Servico;
import dao.ServicoDAO;
import util.HibernateUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Inicia o Hibernate e cria as tabelas
            System.out.println("Conectando ao banco...");
            HibernateUtil.getSessionFactory().openSession();
            
            // 2. Garante que exista pelo menos um serviço para o teste
            popularServicoInicial();

            // 3. Abre a tela de Cadastro
            java.awt.EventQueue.invokeLater(() -> {
                new TelaCadastro().setVisible(true);
            });
            
        } catch (Exception e) {
            System.err.println("Erro crítico ao iniciar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void popularServicoInicial() {
        ServicoDAO dao = new ServicoDAO();
        List<Servico> servicos = dao.listarTodos();
        
        // Se não houver nenhum serviço, cria o primeiro
        if (servicos.isEmpty()) {
            System.out.println("Criando serviço inicial de teste...");
            Servico teste = new Servico(0, "Corte de Cabelo", 35.00);
            dao.salvar(teste);
        }
    }
}