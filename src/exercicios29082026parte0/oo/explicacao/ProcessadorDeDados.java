package exercicios29082026parte0.oo.explicacao;

public class ProcessadorDeDados {

	public static void analisar(String texto, int divisor) {
		// 1. Pode lançar NullPointerException
		if (texto == null) {
			throw new NullPointerException("O texto fornecido está nulo!");
		}

		// 2. Pode lançar ArithmeticException
		if (divisor == 0) {
			throw new ArithmeticException("Tentativa de divisão por zero!");
		}

		// 3. Pode lançar ArrayIndexOutOfBoundsException (Herdeira de
		// IndexOutOfBoundsException)
		if (texto.length() > 10) {
			throw new ArrayIndexOutOfBoundsException("Tamanho do texto excedeu o limite do array simulado!");
		}

		System.out.println("Texto processado com sucesso: " + texto.toUpperCase());
	}

	public static void main(String[] args) {
		// Teste alterando os parâmetros abaixo para testar cada exceção herdada:
		// Ex: (null, 2) -> NullPointerException
		// Ex: ("Java", 0) -> ArithmeticException
		// Ex: ("Texto muito longo com mais de dez caracteres", 2) ->
		// ArrayIndexOutOfBoundsException

		// -------------------------------------------------------------
		
		// SIMULANDO ERRO : 1
		// [Capturado no Catch Específico] Erro: O texto fornecido está nulo!
		// String textoTeste = null; 

		// SIMULANDO ERRO : 3
		// [Capturado no Catch de Hierarquia Superior] Erro de Índice: Tamanho do texto excedeu o limite do array simulado!
		// String textoTeste = "1234567891123456";
		
		// SIMULANDO CORRETAMENTE
		String textoTeste = "Java POO";
		
		// -------------------------------------------------------------
		// SIMULANDO ERRO : 2
		// [Capturado no Catch Específico] Erro: Tentativa de divisão por zero!
		// int divisorTeste = 0;
		
		// SIMULANDO CORRETAMENTE		
		int divisorTeste = 2;
		
		// -------------------------------------------------------------

		try {
			
			System.out.println("Iniciando processamento...");
			analisar(textoTeste, divisorTeste);

		} catch (NullPointerException e) {
			System.out.println("[Capturado no Catch Específico] Erro: " + e.getMessage());

		} catch (ArithmeticException e) {
			System.out.println("[Capturado no Catch Específico] Erro: " + e.getMessage());

		} catch (IndexOutOfBoundsException e) {
			// Captura IndexOutOfBoundsException e sua subclasse
			// ArrayIndexOutOfBoundsException
			System.out.println("[Capturado no Catch de Hierarquia Superior] Erro de Índice: " + e.getMessage());

		} catch (RuntimeException e) {
			// Captura qualquer outra RuntimeException genérica que tenha escapado
			System.out.println("[Capturado no Catch Genérico Runtime] Erro: " + e.getMessage());

		} finally {
			// O bloco finally sempre executa, havendo ou não exceção
			System.out.println("Operação finalizada. Recursos liberados.\n");
		}
	}
}