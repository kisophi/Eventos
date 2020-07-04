package com.akira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akira.model.Evento;
import com.akira.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	
	@RequestMapping("/")
	public String home() {
		return "evento/index";
	}
	
	//Encaminha para pagina Form de Cadastro de evento
	@RequestMapping(value = "/salvar",method = RequestMethod.GET)
	public String paginaSalvar() {
		return "evento/formSalvar";
	}
	
	//Salva os dados da tela de cadastro
	@RequestMapping(value = "/salvar",method = RequestMethod.POST)
	public String salvar(Evento e) {
		er.save(e);
		return "evento/formSalvar";
	}
	
}
