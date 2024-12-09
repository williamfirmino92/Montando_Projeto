package Api.ApiDoProjeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Api.ApiDoProjeto.model.contato.ContatoModel;
import Api.ApiDoProjeto.model.contato.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/fale-conosco")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public String carregaPaginaAjuda(Model model) {
        model.addAttribute("contato", new ContatoModel());
        return "ajuda";
    }

    // Método para listagem das mensagens cadastradas
    // @GetMapping("/listagem-mensagens")
    // public String carregarPaginaListagem(Model model) {
    // model.addAttribute("contatos", repository.findAll());
    // return "atendente/listar_mensagens";
    // }

    // Método que grava as informações das mensagens
    @PostMapping
    public String salvarContato(ContatoModel contato) {
        repository.save(contato);
        return "redirect:/fale-conosco";
    }

}
