package exercicios19082026parte0.oo.exercicio1;

public class Main {

	public static void main(String[] args) {
		
		carregarAutor();
		
		IngressoVIP helenaIngressoVipLuanSantana = new IngressoVIP(2);
		
		helenaIngressoVipLuanSantana.toString();
		helenaIngressoVipLuanSantana.imprimeTipo();
		helenaIngressoVipLuanSantana.imprimeValor();
		helenaIngressoVipLuanSantana.valorTotal();
		
		
		
		System.out.println("\n\n");
		
		
		
		IngressoCamaroteInferior helenaIngressoCamaroteInferiorLuanSantana = new IngressoCamaroteInferior(2);
		
		helenaIngressoCamaroteInferiorLuanSantana.toString();
		helenaIngressoCamaroteInferiorLuanSantana.imprimeTipo();
		helenaIngressoCamaroteInferiorLuanSantana.imprimeValor();
		helenaIngressoCamaroteInferiorLuanSantana.valorTotal();
		
		
		
		System.out.println("\n\n");
		
		
		
		IngressoCamaroteSuperior helenaIngressoCamaroteSuperiorLuanSantana = new IngressoCamaroteSuperior(2);
		
		helenaIngressoCamaroteSuperiorLuanSantana.toString();
		helenaIngressoCamaroteSuperiorLuanSantana.imprimeTipo();
		helenaIngressoCamaroteSuperiorLuanSantana.imprimeValor();
		helenaIngressoCamaroteSuperiorLuanSantana.valorTotal();
		
		
		
		System.out.println("\n\n");
		
		
		
		IngressoNormal helenaIngressoNormalLuanSantana = new IngressoNormal();
		
		helenaIngressoNormalLuanSantana.toString();
		helenaIngressoNormalLuanSantana.imprimeTipo();
		helenaIngressoNormalLuanSantana.imprimeValor();
		helenaIngressoNormalLuanSantana.valorTotal();
		
		
	}
	
	public static void carregarAutor() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("--------------------------------------------------------------------------------");
	}
}
