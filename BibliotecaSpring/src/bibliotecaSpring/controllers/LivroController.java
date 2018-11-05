package bibliotecaSpring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaSpring.daos.AlunoDAO;
import bibliotecaSpring.daos.LivroDAO;
import bibliotecaSpring.models.Aluno;
import bibliotecaSpring.models.Livro;

@Controller
public class LivroController {
	
	@RequestMapping("/livro/formL")
	public String form() {
		System.out.println("Chamou o formL livro");
		return "livro/formL";
	}
	
	@PostMapping("/livro")
	public String adicionar(Livro livro) {
		System.out.println(livro);
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.inserir(livro);
		return "redirect:livro";
	}
	
	@GetMapping("/livro") 
	public ModelAndView listar() {
		LivroDAO livroDAO = new LivroDAO();
		List<Livro> lista = livroDAO.getLista();
		ModelAndView model = new ModelAndView("livro/listaL");
		model.addObject("livro", lista);
		return model;
	}
	
	@RequestMapping("/livro/remover")
	public String remover(Livro livro) {
		System.out.println("Chamou o metodo remover livro");
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.remover(livro);
		return "redirect:../livro/";
	}

}
