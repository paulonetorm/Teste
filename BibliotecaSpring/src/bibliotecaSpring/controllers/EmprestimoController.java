package bibliotecaSpring.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import bibliotecaSpring.daos.AlunoDAO;
import bibliotecaSpring.daos.EmprestimoDAO;
import bibliotecaSpring.daos.LivroDAO;
import bibliotecaSpring.models.Aluno;
import bibliotecaSpring.models.Emprestimo;
import bibliotecaSpring.models.Livro;

@Controller
public class EmprestimoController {
	
	@RequestMapping("/emprestimo/formE")
	public ModelAndView listarAL() {
		AlunoDAO alunoDAO = new AlunoDAO();
		LivroDAO livroDAO = new LivroDAO();
		List<Aluno> listaA = alunoDAO.getLista();
		List<Livro> listaL = livroDAO.getLista();
		ModelAndView model = new ModelAndView("emprestimo/formE");
		model.addObject("alunos", listaA);
		model.addObject("livros", listaL);
		return model;
	}
	
	@PostMapping("/emprestimo")
	public String inserir(Emprestimo emprestimo) {
		System.out.println("Chamou o m�todo de adicionar");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.inserir(emprestimo);
		return "redirect:/emprestimo";
	}
	
	@GetMapping("/emprestimo") 
	public ModelAndView listar() {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getLista();
		ModelAndView model = new ModelAndView("emprestimo/listaE");
		model.addObject("emprestimo", lista);
		return model;
	}

	@RequestMapping("/emprestimo/devolucao")
	public String devolver(Long id) {
		System.out.println("Chamou devolver");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		Emprestimo e = emprestimoDAO.getEmprestimoByID(id);
		
		emprestimoDAO.devolucao(e);
		return "redirect:../emprestimo/";
}
}