package com.tienda.tienda_de_ropa;

import com.tienda.tienda_de_ropa.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaDeRopaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaDeRopaApplication.class, args);
	}

	public CommandLineRunner initData(
			ClienteRepository clienteRepository,
			ProductoRepository productoRepository,
			ContactoRepository contactoRepository,
			GiftCardRepository giftCardRepository,
			ClienteProductoRepository clienteProductoRepository,
			TransaccionRepository transaccionRepository
	) {
		return args -> {

		};
	}
}
