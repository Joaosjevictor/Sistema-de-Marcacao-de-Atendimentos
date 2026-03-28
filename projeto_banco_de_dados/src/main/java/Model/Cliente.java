package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BD_CLIENTE")
public class Cliente extends Pessoa {
    
    @Column(nullable = false, length = 255)
    private String endereco;

    public Cliente() {

    }

    public Cliente(int id, String nome, String dataNascimento, String cpf, String email, String telefone, String endereco) {
        super(id, nome, dataNascimento, cpf, email, telefone);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente [endereco=" + endereco + ", id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento
                + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + "]";
    }

    
    


}
