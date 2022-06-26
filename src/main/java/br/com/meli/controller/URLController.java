package br.com.meli.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.model.URL;
import br.com.meli.service.URLService;
import br.com.meli.service.URLServiceImpl;

@RestController
@RequestMapping("/url")
public class URLController {
	
	@Autowired
	private URLServiceImpl URLService;
	
	@GetMapping
	public List<URL> obterTodos() {
		return URLService.obterTodas();

	}
	
	@GetMapping("{codigo}")
	public URL obterPorCodigo(@PathVariable String codigo) {
		return URLService.obterPorCodigo(codigo);

	}
	
	@PostMapping("/encurtar")
	public URL encurtar(@RequestBody URL uRL) {
		try {
			return URLService.encurtar(uRL);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@GetMapping("/range")
	public List<URL> obterURLPorRangeDataCriacao(
			@RequestParam("de") LocalDateTime de, 
			@RequestParam("ate") LocalDateTime ate){
		
		return URLService.obterURLPorRangeDataCriacao(de, ate);
	}
	
}
