package com.tienda.tienda_de_ropa;

import com.tienda.tienda_de_ropa.models.Producto;

import java.util.List;

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
//			Dotenv dotenv = Dotenv.load();
//			Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
//			cloudinary.config.secure = true;
//			System.out.println(cloudinary.config.cloudName);
//
//			Map params1 = ObjectUtils.asMap(
//					"use_filename", true,
//					"unique_filename", false,
//					"overwrite", true
//			);
//
//			Map params2 = ObjectUtils.asMap(
//					"quality_analysis", true
//			);
//
//			System.out.println(
//					cloudinary.api().resource("foto_zifslc", params1));



			System.out.println("Servidor iniciado!");

			System.out.println("Servidor iniciado!");
			Producto producto1 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669746933/Camisetas%20del%20mundial/Alemania/camisetas-adidas-alemania-2022-1-removebg-preview_cd0yqr.png"), "Camiseta Alemania", 5, 100.00, List.of("XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto1);

			// Cliente admin = new Cliente("Sebas", "Granados", "loquesea@gmail.com", passwordEnconder.encode("1234"), 0);
		};
	}
}
