package dao;

import model.Agendamento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class AgendamentoDAO {

    // Método para salvar (Create)
    public void salvar(Agendamento agendamento) {
        Transaction transaction = null;
        // Abre uma sessão com o banco usando nosso Util
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Inicia a transação (ou tudo dá certo, ou nada é salvo)
            transaction = session.beginTransaction();
            
            session.persist(agendamento); // O Hibernate cuida do INSERT
            
            transaction.commit(); // Confirma a gravação
            System.out.println("Agendamento salvo com sucesso!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Cancela se der erro
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Agendamento agendamento = session.find(Agendamento.class, id);
        if (agendamento != null) {
            session.remove(agendamento); // Remove a linha do banco
        }
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        e.printStackTrace();
    }
    }
    // Método para listar todos (Read)
    public List<Agendamento> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL (Hibernate Query Language) - Usamos o nome da CLASSE, não da tabela
            return session.createQuery("from Agendamento", Agendamento.class).list();
        }
    }
}