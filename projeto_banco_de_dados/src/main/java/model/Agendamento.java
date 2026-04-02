package model;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "BD_AGENDAMENTOS")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;
    
    @Column(nullable = false)
    private float valor;
    
    @Column(nullable = false)
    private LocalDateTime data;
    
    @Column(nullable = false, length = 10)
    private boolean status = false;


    public Agendamento() {

    }

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, boolean status) {
        this.id = 0;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.data = LocalDateTime.parse(data, parser);
        } catch (java.time.format.DateTimeParseException e) {
        System.err.println("Erro: Formato de data inválido! Use dd/MM/yyyy HH:mm");
        e.printStackTrace();
        }
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setDataHora(String dataStr) {
        try {
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.data = LocalDateTime.parse(dataStr, parser);
        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("Erro ao converter data no Update: " + e.getMessage());
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agendamento [id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", valor=" + valor + ", data=" + data + ", status=" + status + "]";
    }   





    
}
