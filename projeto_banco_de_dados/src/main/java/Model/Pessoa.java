package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @Column(nullable = false, length = 100)
    protected String nome;

    @Column(nullable = false)
    protected Date dataNascimento;
    
    @Column(nullable = false, unique = true, length = 14)
    protected String cpf;

    @Column(nullable = false, unique = true, length = 100)
    protected String email;

    @Column(nullable = false, unique = true, length = 20)
    protected String telefone;

    public Pessoa() {

    }

    public Pessoa(int id, String nome, String dataNascimento, String cpf, String email, String telefone) {
        this.id = 0;
        this.nome = nome;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

}
