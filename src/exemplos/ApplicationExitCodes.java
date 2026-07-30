package exemplos;

public class ApplicationExitCodes {

	    /*
	     * Códigos de retorno (Exit Codes)
	     *
	     * Convenção utilizada:
	     *
	     *   0  = Sucesso
	     *   1  = Erro genérico não tratado
	     *   2  = Argumentos inválidos informados na linha de comando
	     *   3  = Arquivo de configuração não encontrado
	     *
	     * Códigos específicos da aplicação:
	     *
	     *   30157   = Falha de autenticação do usuário
	     *   22547   = Usuário bloqueado ou inativo
	     *   545487  = Erro ao conectar ao banco de dados
	     *   1149874 = Timeout durante comunicação com serviço externo
	     *   987654  = Chave de API inválida
	     *   888111  = Falha ao processar pagamento
	     *   450021  = Recurso solicitado não encontrado
	     *   701015  = Falha na validação de dados obrigatórios
	     *   920330  = Limite de requisições excedido (Rate Limit)
	     *   777777  = Erro interno de processamento
	     *   600100  = Falha ao gravar arquivo em disco
	     *   998001  = Operação cancelada pelo usuário
	     *
	     * Observações:
	     *
	     * - 0 sempre indica sucesso.
	     * - Valores diferentes de 0 indicam falha.
	     * - É recomendável documentar todos os códigos
	     *   utilizados pela aplicação.
	     * - Sistemas de monitoramento e scripts podem
	     *   reagir automaticamente de acordo com o código.
	     */

	    public static void main(String[] args) {

	        try {

	            boolean bancoDisponivel = false;

	            if (!bancoDisponivel) {

	                System.err.println(
	                    "Falha ao conectar ao banco de dados."
	                );

	                System.exit(545487);
	            }

	            System.out.println("Processamento concluído com sucesso.");

	            System.exit(0);

	        } catch (Exception ex) {

	            System.err.println(
	                "Erro inesperado: " + ex.getMessage()
	            );

	            System.exit(1);
	        }
	    }
	}