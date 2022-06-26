package br.com.meli.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
public class URL {
	
	@Id
	private String id; 
	
	private String urlEncurtada; 
	
	@Indexed(unique = true)
	private String codigo;
	
	private String urlOriginal;
	
	private LocalDateTime dataCriacao; 
	
	private LocalDateTime dataAtualizacao; 
	
	private LocalDateTime dataExclusao; 
	
}
