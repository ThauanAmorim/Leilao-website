
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/leilao")
public class LeilaoController {
    
    @Autowired
    private ProdutoArrematadoServiceImpl produto;
}
