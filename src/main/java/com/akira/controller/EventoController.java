package com.akira.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	// Encaminha para pagina Form de Cadastro de evento
	@RequestMapping(value = "/salvar", method = RequestMethod.GET)
	public String paginaSalvar() {
		return "evento/formSalvar";
	}

	// Salva os dados da tela de cadastro
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Evento e) {
		er.save(e);
		return "redirect:/listaEventos";
	}

	// Salva os dados da tela de cadastro
	@RequestMapping("/listaEventos")
	public String listaEventos(Model model) {
		List<Evento> eventos = er.findAll();
		model.addAttribute("eventos", eventos);
		return "evento/lista";
	}

	// Exluir Evento pelo ID
	@RequestMapping("/exclui/{id}")
	public String excluirEvento(@PathVariable("id") Integer eventoid) {
		er.deleteById(eventoid);
		return "redirect:/listaEventos";
	}

	// Editar Evento
	@RequestMapping("/edita/{id}")
	public String editaEvento(@PathVariable("id") Integer eventoid, Model model) {
		Optional<Evento> evento = er.findById(eventoid);
		
		model.addAttribute("evento", evento);
		return "evento/edita";
	}
	


}
