package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BD_USUARIO")
public class Usuario extends Pessoa {
    
    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = false, length = 20)
    private String nivelAcesso;

    public Usuario() {

    }

    public Usuario(int id, String nome, String email, String senha, String nivelAcesso) {
        super(id, nome, email);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "Usuario [senha=" + senha + ", nivelAcesso=" + nivelAcesso + ", id=" + id + ", nome=" + nome + ", dataNascimento=" 
            + ", email=" + email + "]";  

    }           

    

}
