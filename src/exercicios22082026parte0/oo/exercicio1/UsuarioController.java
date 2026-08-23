package exercicios22082026parte0.oo.exercicio1;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    public void chamarServico() {
        usuarioService.saudacao();
    }
}