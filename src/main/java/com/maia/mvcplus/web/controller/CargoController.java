package com.maia.mvcplus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maia.mvcplus.domain.Cargo;
import com.maia.mvcplus.domain.Departamento;
import com.maia.mvcplus.interfaces.CargoServices;
import com.maia.mvcplus.interfaces.DepartamentoServices;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoServices cgServices;

	@Autowired
	private DepartamentoServices dpServices;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cgServices.buscarTodos());
		return "cargo/lista";
	}

	// Controller Salvar
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cgServices.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo Salvo Com Sucesso!");
		return "redirect:/cargos/cadastrar";
	}

	/*
	 * Pre Editar - retorna para a pagina de casdastra com o Objeto Instaciado no
	 * corpo
	 */
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cgServices.buscarPorId(id));
		return "cargo/cadastro";
	}

	// Editar - executa ação ao clicar no butão de editar
	@PostMapping("/editar")
	public String editar(Cargo cargo, RedirectAttributes attr) {
		cgServices.editar(cargo);
		attr.addFlashAttribute("success", "Departamento Editado com Sucesso!");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(cgServices.cargoTemFuncionarios(id)) {
			attr.addFlashAttribute("fail", "Cargo não pode ser excluido. Tem Funcionario(s) vinculados. ");
		}else {
			cgServices.excluir(id);
			attr.addFlashAttribute("success", "Cargo excluido com Sucesso!");
		}
		return "redirect:/cargos/listar";
	}
	

	// Listar Departamentos para o ComboBox da Pagina
	@ModelAttribute("departamentos") // variavel declarado no th:field da combobox
	private List<Departamento> listarDepartamentos() {
		return dpServices.buscarTodos();
	}
}
