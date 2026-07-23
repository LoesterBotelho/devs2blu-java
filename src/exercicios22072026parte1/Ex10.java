package exercicios22072026parte1;

public class Ex10 {

    private int ano;

    public Ex10() {
    }

    public Ex10(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isBissexto() {

//    	https://learn.microsoft.com/pt-br/troubleshoot/microsoft-365-apps/excel/determine-a-leap-year
//    	=IF(OR(MOD(A1,400)=0,AND(MOD(A1,4)=0,MOD(A1,100)<>0)),"Leap Year", "NOT a Leap Year")
//    	Passo 1: Se o ano for divisível por 4, vá para o passo 2. Se não, não é bissexto.
//    	Passo 2: Se o ano for divisível por 100, vá para o 
//    	passo 3. Se não, é bissexto.Passo 3: Se o ano for divisível por 400, é bissexto. Se não, não é
    	
        if (this.ano % 400 == 0) {
            return true;

        } else if ((this.ano % 4 == 0) 
                && (this.ano % 100 != 0)) {
            return true;

        } else {
            return false;
        }
    }

    public String getResultado() {

        if (this.isBissexto()) {
            return "Ano Bissexto";
        }

        return "Ano não é Bissexto";
    }

    @Override
    public String toString() {
        return "Ex10 [ano=" + this.getAno()
                + ", resultado=" + this.getResultado()
                + "]";
    }
}