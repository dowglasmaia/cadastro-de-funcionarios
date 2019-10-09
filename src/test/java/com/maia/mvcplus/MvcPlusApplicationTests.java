package com.maia.mvcplus;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maia.mvcplus.domain.Cargo;
import com.maia.mvcplus.domain.Departamento;
import com.maia.mvcplus.services.CargoServicesImpl;
import com.maia.mvcplus.services.DepartamentoServicesImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcPlusApplicationTests {

	@Autowired
	private CargoServicesImpl service;

	@Autowired
	private DepartamentoServicesImpl dpServ;

	@Test
	//@Ignore
	public void contextLoads() {
	}
	
	@Test
	//@Ignore
	public void salvarDepartamento() {
		Departamento dp = new Departamento();
		dp.setNome("TI-987");
		dpServ.salvar(dp);

	}

	//@Test
	//@Ignore
	public void salvarCargo() {
		Cargo cg = new Cargo();
		cg.setNome("Desenvolvedor Java Pleno");

		service.salvar(cg);

	}



}
