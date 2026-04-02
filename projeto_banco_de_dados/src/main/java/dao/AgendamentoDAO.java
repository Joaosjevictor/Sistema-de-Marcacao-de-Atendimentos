package dao;

import model.Agendamento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class AgendamentoDAO {

    public void salvar(Agendamento agendamento) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(agendamento); 
            
            transaction.commit(); 
            System.out.println("Agendamento salvo com sucesso!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); 
            e.printStackTrace();
        }
    }

    public Agendamento buscarPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Agendamento.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizar(Agendamento agendamento) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             transaction = session.beginTransaction();
        
            session.merge(agendamento);
        
            transaction.commit();
            System.out.println("Agendamento atualizado com sucesso!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public boolean deletar(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Agendamento agendamento = session.find(Agendamento.class, id);
            if (agendamento != null) {
                session.remove(agendamento); 
                transaction.commit();
                return true;
            }

             return false; 

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
         e.printStackTrace();
            return false;
        }
    }

    public List<Agendamento> listarPorCliente(int clienteId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             return session.createQuery("FROM Agendamento WHERE cliente.id = :cId", Agendamento.class)
                    .setParameter("cId", clienteId)
                    .list();
        }
    }
}