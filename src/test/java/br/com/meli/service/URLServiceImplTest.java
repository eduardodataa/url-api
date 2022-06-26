package br.com.meli.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ActiveProfiles;

import br.com.meli.MongoConfig;
import br.com.meli.model.URL;
import br.com.meli.repository.URLRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;

@Import(MongoConfig.class)
@ActiveProfiles("test")
@SpringBootTest(classes = URLServiceImpl.class)
@EnableMongoRepositories(basePackageClasses = URLRepository.class)
public class URLServiceImplTest {
	
	@Autowired
	private URLService urlService;
	
	@Value("url.urlOriginal")
	private String urlOriginal;
	
	@Autowired
	private MongodExecutable mongoExecutable;

	@BeforeEach
	void setUp() throws IOException {
		mongoExecutable.start();
	}

	@AfterEach
	void tearDown() {
		mongoExecutable.stop();
	}

	
	@Test
	@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
	@DisplayName("Teste persistir URL")
	void testEncurtar() {
		var url = URL.builder().urlOriginal(urlOriginal).build();
		var urlRetorno = urlService.encurtar(url);
		assertThat(urlRetorno.getId(), notNullValue());
	}
	
	@Test
	void testObterTodas() {
		fail("Not yet implemented");
	}

	@Test
	void testObterPorCodigo() {
		fail("Not yet implemented");
	}

	@Test
	void testObterURLPorNome() {
		fail("Not yet implemented");
	}

	@Test
	void testObterURLPorRangeDataCriacao() {
		fail("Not yet implemented");
	}

}
