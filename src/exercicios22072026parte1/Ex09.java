package exercicios22072026parte1;

public class Ex09 {

    private char letra;

    public Ex09() {
    }

    public Ex09(char letra) {
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    
    public boolean isVogal() {
        char letra = Character.toLowerCase(this.letra);

        char[] vogais = {
                'a', 'á', 'à', 'â', 'ã',
                'e', 'é', 'è', 'ê',
                'i', 'í', 'ì', 'î',
                'o', 'ó', 'ò', 'ô', 'õ',
                'u', 'ú', 'ù', 'û', 'ü'
        };
        
        for (char vogal : vogais) {
            if (letra == vogal) {
                return true;
            }
        }
        return false;
    }
       
    public boolean isConsoante() {

        char letra = Character.toLowerCase(this.letra);

        char[] consoantes = {
            'b','c','d','f','g',
            'h','j','k','l','m',
            'n','p','q','r','s',
            't','v','w','x','y','z'
        };

        for (char consoante : consoantes) {
            if (letra == consoante) {
                return true;
            }
        }

        return false;
    }
    
    public String getClassificacao() {

        if (!Character.isLetter(this.letra)) {
            return "Caractere inválido.";
        }

        if (isVogal()) {
            return "Vogal";
        }

        return "Consoante";
    }

    @Override
    public String toString() {
        return "Ex09 [letra=" + this.getLetra()
                + ", classificacao=" + this.getClassificacao()
                + "]";
    }

}