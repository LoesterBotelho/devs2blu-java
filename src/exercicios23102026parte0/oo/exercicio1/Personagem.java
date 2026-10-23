package exercicios23102026parte0.oo.exercicio1;

public abstract class Personagem extends Entidade {

    private int nivel;
    private int forca;
    private int mana;
    private int experiencia;
    private final Inventario inventario = new Inventario();

    protected Personagem(
            Long id, String nome, int vida,
            int nivel, int forca, int mana) {
        super(id, nome, vida);

        if (nivel <= 0 || forca < 0 || mana < 0) {
            throw new IllegalArgumentException(
                    "Atributos inválidos");
        }

        this.nivel = nivel;
        this.forca = forca;
        this.mana = mana;
    }

    public int getNivel() {
        return nivel;
    }

    public int getForca() {
        return forca;
    }

    public int getMana() {
        return mana;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public boolean gastarMana(int quantidade) {
        if (quantidade < 0 || mana < quantidade) {
            return false;
        }

        mana -= quantidade;
        return true;
    }

    public void ganharExperiencia(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException(
                    "A experiência não pode ser negativa");
        }

        experiencia += quantidade;

        while (experiencia >= nivel * 100) {
            experiencia -= nivel * 100;
            nivel++;
            forca++;
            curar(20);
            System.out.println(getNome() + " subiu para o nível " + nivel);
        }
    }

    public int calcularDanoComArma() {
        return forca + inventario.armaEquipada()
                .map(Arma::getDano)
                .orElse(0);
    }

    public void executarHabilidade(
            Habilidade habilidade, Entidade alvo) {
        habilidade.executar(this, alvo);
    }
}