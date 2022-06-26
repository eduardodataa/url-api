package br.com.meli.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.meli.model.URL;

public interface URLService {

	public List<URL> obterTodas(); 
	public URL obterPorCodigo(String codigo) ; 
	public URL encurtar(URL uRL) ; 
	public List<URL> obterURLPorRangeDataCriacao(LocalDateTime de, LocalDateTime ate);

}
