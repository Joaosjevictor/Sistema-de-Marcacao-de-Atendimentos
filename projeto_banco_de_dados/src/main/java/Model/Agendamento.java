package Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date data;
    private boolean status = false;


    public Agendamento() {

    }

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, boolean status) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/mm/yyyy  HH:mm").parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.status = false;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
