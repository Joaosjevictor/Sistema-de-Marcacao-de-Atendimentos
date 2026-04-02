package app;


import model.Servico;
import dao.ServicoDAO;
import util.HibernateUtil;


public class Main {
    public static void main(String[] args) {
        try {
            // 1. Inicia o Hibernate e cria as tabelas
            System.out.println("Conectando ao banco...");
            HibernateUtil.getSessionFactory().openSession().close();
            
            // 2. Garante que exista pelo menos um serviço para o teste
            popularServicoInicial();

            // 3. Abre a tela de Cadastro
            java.awt.EventQueue.invokeLater(() -> {
                new view.TelaLogin().setVisible(true);
            });
            
        } catch (Exception e) {
            System.err.println("Erro crítico ao iniciar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void popularServicoInicial() {
    ServicoDAO dao = new ServicoDAO();
    if (dao.listarTodos().isEmpty()) {
        System.out.println("Populando serviços iniciais...");
        
        dao.salvar(new Servico(0, "Corte de Cabelo", 25.00));
        dao.salvar(new Servico(0, "Barba", 15.00));
        dao.salvar(new Servico(0, "Cabelo + Barba", 40.00));
        
        System.out.println("Serviços criados com sucesso!");
        }
    }
}