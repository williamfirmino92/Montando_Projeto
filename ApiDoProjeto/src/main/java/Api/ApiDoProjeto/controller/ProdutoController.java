package Api.ApiDoProjeto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import Api.ApiDoProjeto.model.produto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrar (@RequestBody @Valid DadosCadastroProduto dados){
        repository.save(new ProdutoModel(dados));
    }
    @GetMapping("/listar")
    public List<ProdutoModel> listar(){
        return repository.findAll();
    }
    @PutMapping
    @Transactional
    public void Atualizar (@RequestBody DadosAtualizarProduto dados){
        ProdutoModel produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
