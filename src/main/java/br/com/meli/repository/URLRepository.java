package br.com.meli.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.meli.model.URL;

public interface URLRepository extends MongoRepository<URL, String> {

//	@Query("{ $and [ { 'idade': { $gte: ?0 , $lte: ?1} } ]}")
	@Query("{ $and: [ { 'data': { $gte: ?0 } }, { 'idade': { $lte: ?1} } ]}")
	public List<URL> obterURLPorRangeDeDataCriacao(LocalDateTime de, LocalDateTime ate);

	public List<URL> findByCodigo(String codigo);

}
