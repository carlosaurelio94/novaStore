package com.tienda.tienda_de_ropa;

import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TiendaDeRopaApplication {

	@Autowired
	private PasswordEncoder passwordEnconder;

	public static void main(String[] args) {
		SpringApplication.run(TiendaDeRopaApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(
			ClienteRepository clienteRepository,
			ProductoRepository productoRepository,
			ContactoRepository contactoRepository,
			GiftCardRepository giftCardRepository,
			ClienteProductoRepository clienteProductoRepository,
			TransaccionRepository transaccionRepository
	) {
		return args -> {
			Cliente clientePruebas = new Cliente("Carlos", "Rodriguez", "carlos@gmail.com", passwordEnconder.encode("1234"),0);
			clienteRepository.save(clientePruebas);
		};
	}
}
