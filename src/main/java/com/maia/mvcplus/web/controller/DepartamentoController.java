package com.maia.mvcplus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maia.mvcplus.domain.Departamento;
import com.maia.mvcplus.interfaces.DepartamentoServices;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoServices servives;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", servives.buscarTodos());
		return "departamento/lista";
	}

	// Salvar
	@PostMapping("/salvar")
	public String Salvar(Departamento departamento) {
		servives.salvar(departamento);
		return "redirect:/departamentos/cadastrar";
	}

	// Pre Editar - retorna para a pagina de casdastra com o Objeto Instaciado no corpo
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", servives.buscarPorId(id));
		return "departamento/cadastro";
	}
	
	//Editar - executa ação ao clicar no butão de editar
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		servives.editar(departamento);
		return "redirect:/departamentos/cadastrar";
	}

}
