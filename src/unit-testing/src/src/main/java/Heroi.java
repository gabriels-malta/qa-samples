public class Heroi {
    private final byte NIVEL_MAXIMO = 5;
    private final String HABILIDADE_INDISPONIVEL = "Você ainda não aprendeu essa habilidade";
    private final String HABILIDADE_UTILIZADA = "Você usou sua habilidade ";

    private final String nome;
    private byte nivel;
    private final boolean habilidadePrimaria;
    private boolean habilidadeSecundaria;
    private boolean habilidadeEspecial;

    public Heroi(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.habilidadePrimaria = true;
    }

    public byte getNivel() {
        return this.nivel;
    }

    public void aumentarNivel() {
        if (permiteSubirNivel()) {
            this.nivel += 1;
            this.habilitarProximaHabilidade();
        }
    }

    private void habilitarProximaHabilidade() {
        if (this.getNivel() == 3) {
            this.habilidadeSecundaria = true;
        }

        if (this.getNivel() == NIVEL_MAXIMO) {
            this.habilidadeEspecial = true;
        }
    }

    public boolean permiteSubirNivel() {
        return (this.getNivel() + 1) <= NIVEL_MAXIMO;
    }

    public String usarHabilidadePrimaria() {
        return HABILIDADE_UTILIZADA + "primária";
    }

    public String usarHabilidadeSecundaria() throws Exception {
        if (this.getNivel() < 3)
            throw new Exception(HABILIDADE_INDISPONIVEL);

        return HABILIDADE_UTILIZADA + "secundária";
    }

    public String usarHabilidadeEspecial() throws Exception {
        if (this.getNivel() != NIVEL_MAXIMO)
            throw new Exception(HABILIDADE_INDISPONIVEL);

        return HABILIDADE_UTILIZADA + "especial";
    }

    public byte quantoAteHabilidadeEspecial() {
        return (byte) (NIVEL_MAXIMO - this.getNivel());
    }
}

