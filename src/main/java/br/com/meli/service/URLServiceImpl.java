package br.com.meli.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.model.URL;
import br.com.meli.repository.URLRepository;

@Service
public class URLServiceImpl implements URLService {

	@Autowired
	private URLRepository uRLRepository;
	
	@Override
	public List<URL> obterTodas() {
		return uRLRepository.findAll();
	}

	@Override
	public URL obterPorCodigo(String codigo) {
		return uRLRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("URL com código "+codigo+" não existe"));

	}

	@Override
	public URL encurtar(URL uRL) {
		try {
			String codigo = Base64.getEncoder().encodeToString(Long.valueOf(System.currentTimeMillis()).toString().getBytes());
			uRL.setUrlEncurtada("bit.ly");
			uRL.setCodigo(codigo);
			uRL.setDataCriacao(LocalDateTime.now());
			return uRLRepository.save(uRL);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public List<URL> obterURLPorNome(String codigo) {
		return uRLRepository.findByCodigo(codigo);
	}

	@Override
	public List<URL> obterURLPorRangeDataCriacao(LocalDateTime de, LocalDateTime ate) {
		return uRLRepository.obterURLPorRangeDeDataCriacao(de, ate);
	}

}
