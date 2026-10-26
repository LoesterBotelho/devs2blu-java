package exercicios25102026parte0.oo.exercicio1;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String id, String nome, String telefone, String email) {
        super(id, nome, telefone);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.email = email;
    }
}