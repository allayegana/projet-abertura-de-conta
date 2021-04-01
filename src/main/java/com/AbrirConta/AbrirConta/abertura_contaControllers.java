package com.AbrirConta.AbrirConta;


import antlr.ASTNULLType;
import com.AbrirConta.Repository.aberturaContaRepository;
import com.AbrirConta.models.Abertura_conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Configuration
public class abertura_contaControllers {


    @Autowired
    private aberturaContaRepository ar;

    @GetMapping("/index")
    public String index(){
        return "templates/index";
    }


    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String form() {
        return "/index";
    }

    @RequestMapping(value = "/index", method=RequestMethod.POST)
    public String form(Abertura_conta abertura_conta) {
        ar.save(abertura_conta);
        return "redirect:/index";
    }


    @RequestMapping("/aberura_contas")
    public ModelAndView listarabertura_contas(){
        ModelAndView mv = new ModelAndView("listar");

        Iterable<Abertura_conta> abertura_contas = ar.findAll();
        mv.addObject("abertura_contas","abertura_contas");
        return mv;

    }
  }

