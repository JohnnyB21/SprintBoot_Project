package com.promineotech.jeep.jeepsales;
import static org.assertj.core.api.Assertions.assertThat;
import com.promineotech.JeepModel;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchJeepTest extends FetchJeepTestSupport {

	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
		//Given: a valid model, trim, & URI
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = 
			String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
		System.out.println(uri);

		//When: a connection is made to the URI
		ResponseEntity<Jeep> response =
		getRestTemplate().getForEntity(uri, Jeep.class);

		//Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
