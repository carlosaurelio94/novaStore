package com.tienda.tienda_de_ropa;

import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TiendaDeRopaApplication {

	@Autowired
	private PasswordEncoder passwordEnconder;

	public static void main(String[] args) {
		SpringApplication.run(TiendaDeRopaApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("https://nova-bank-production-45f5.up.railway.app/").allowedMethods("*").allowedHeaders("*");
//			}
//		};
//	}

	@Bean
	public CommandLineRunner initData(
			ClienteRepository clienteRepository,
			ProductoRepository productoRepository,
			ContactoRepository contactoRepository,
			GiftCardRepository giftCardRepository,
			CompraRepository compraRepository
	) {
		return args -> {
			System.out.println("Servidor iniciado!");
		};
	}
}
