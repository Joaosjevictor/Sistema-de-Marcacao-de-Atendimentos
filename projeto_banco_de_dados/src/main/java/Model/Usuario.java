package Model;

public class Usuario extends Pessoa {
    private String senha;
    private String nivelAcesso;

    public Usuario() {

    }

    public Usuario(int id, String nome, String dataNascimento, String cpf, String email, String telefone, String senha, String nivelAcesso) {
        super(id, nome, dataNascimento, cpf, email, telefone);
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
        return "Usuario [senha=" + senha + ", nivelAcesso=" + nivelAcesso + ", id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf 
            + ", email=" + email + ", telefone=" + telefone + "]";  

    }           

    

}
