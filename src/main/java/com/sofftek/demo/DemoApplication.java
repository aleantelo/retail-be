package com.sofftek.demo;



import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.TipoDeCliente;
import com.sofftek.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
