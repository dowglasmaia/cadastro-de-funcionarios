package com.maia.mvcplus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String Salvar(Departamento departamento, RedirectAttributes attr) {
		servives.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento Inserido com Sucesso!");
		return "redirect:/departamentos/cadastrar";
	}

	// Pre Editar - retorna para a pagina de casdastra com o Objeto Instaciado no
	// corpo
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", servives.buscarPorId(id));
		return "departamento/cadastro";
	}

	// Editar - executa ação ao clicar no butão de editar
	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes attr) {
		servives.editar(departamento);
		attr.addFlashAttribute("success", "Departamento Editado com Sucesso!");
		return "redirect:/departamentos/cadastrar";
	}

	// Excluir com Condicional, de Verificação se ja tem cargos vinculado ao
	// Departamento
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (servives.departamentoTemCargo(id)) {
			model.addAttribute("fail", "Departamento Não Pode ser Removido. Possui Cargo(s) Vinculados" );
		}else {
			servives.excluir(id);
			model.addAttribute("success", "Departamento Removido Com Sucesso!" );
		}	
		return listar(model);  // poderia ser feito assim tbm.   "redirect:/departamento/listar";
	}
	
}
