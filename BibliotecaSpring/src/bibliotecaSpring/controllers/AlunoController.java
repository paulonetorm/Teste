package bibliotecaSpring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaSpring.daos.AlunoDAO;
import bibliotecaSpring.models.Aluno;

@Controller
public class AlunoController {
	
	@RequestMapping("/aluno/formA")
	public String form() {
		System.out.println("Chamou o formA aluno");
		return "aluno/formA";
	}
	
	@PostMapping("/aluno")
	public String adicionar(Aluno aluno) {
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(aluno);
		return "aluno/alunoOK";
	}
	
	@GetMapping("/aluno") 
	public ModelAndView listar() {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.getLista();
		ModelAndView model = new ModelAndView("aluno/listaA");
		model.addObject("aluno", lista);
		return model;
	}

}
