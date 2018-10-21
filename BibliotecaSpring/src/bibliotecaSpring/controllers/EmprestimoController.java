package bibliotecaSpring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaSpring.daos.EmprestimoDAO;
import bibliotecaSpring.models.Emprestimo;

@Controller
public class EmprestimoController {
	
	@RequestMapping("/emprestimo/formE")
	public String form() {
		System.out.println("Chamou o formE emprestimo");
		return "emprestimo/formE";
	}
	
	@PostMapping("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println(emprestimo);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.inserir(emprestimo);
		return "emprestimo/emprestimoOk";
	}
	
	@GetMapping("/emprestimo") 
	public ModelAndView listar() {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getLista();
		ModelAndView model = new ModelAndView("emprestimo/listaE");
		model.addObject("emprestimo", lista);
		return model;
	}

}
