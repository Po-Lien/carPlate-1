package idv.cpl.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CarPlate1Application {

	private static final Logger log = LoggerFactory.getLogger(CarPlate1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(CarPlate1Application.class, args);
		log.debug(
				"\n----------------------------------------------------------------------\n\t"
						+ "Application '{}' is running!\n"
						+ "----------------------------------------------------------------------",
				CarPlate1Application.class.getSimpleName());
	}

}
