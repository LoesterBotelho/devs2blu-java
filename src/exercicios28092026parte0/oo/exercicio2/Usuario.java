package exercicios28092026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Usuario {

    private final Long id;
    private final String nome;
    private final String email;
    private final Perfil perfil;
    private final StatusUsuario status;
    private final BigDecimal salario;
    private final String cidade;

    public Usuario(
            Long id,
            String nome,
            String email,
            Perfil perfil,
            StatusUsuario status,
            BigDecimal salario,
            String cidade) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.status = status;
        this.salario = salario;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public StatusUsuario getStatus() {
        return status;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", perfil=" + perfil +
                ", status=" + status +
                ", salario=" + salario +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}