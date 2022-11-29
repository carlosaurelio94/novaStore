package com.tienda.tienda_de_ropa;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.util.Map;
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
		};
	}
}
