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



			System.out.println("Servidor iniciado! a");

			Producto producto1 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669746933/Camisetas%20del%20mundial/Alemania/camisetas-adidas-alemania-2022-1-removebg-preview_cd0yqr.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669746933/Camisetas%20del%20mundial/Alemania/camisetas-adidas-alemania-2022-2-removebg-preview_a01no4.png"), "Camiseta Alemania", 15, 120.00, List.of("XS", "S"));
			productoRepository.save(producto1);

			Producto producto2 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748008/Camisetas%20del%20mundial/Arabia_Saudita/image-removebg-preview_75_di5tcx.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748007/Camisetas%20del%20mundial/Arabia_Saudita/image-removebg-preview_76_icrm3k.png"), "Camiseta Arabia Saudita", 15, 80.00, List.of("XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto2);

			Producto producto3 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748007/Camisetas%20del%20mundial/Argentina/frenteArgentina-removebg-preview_srfiaw.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748007/Camisetas%20del%20mundial/Argentina/image-removebg-preview_igill3.png"), "Camiseta Argentina", 5, 120.00, List.of( "S", "M"));
			productoRepository.save(producto3);

			Producto producto4 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Australia/frenteAustralia-removebg-preview_zqolea.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748008/Camisetas%20del%20mundial/Australia/atrasAustralia-removebg-preview_cjoirk.png"), "Camiseta Australia", 15, 100.00, List.of("XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto4);

			Producto producto5 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Belgica/frenteBelgica-removebg-preview_qcivga.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Belgica/atrasBelgica-removebg-preview_sd9txy.png"), "Camiseta Belgica", 10, 120.00, List.of("XL", "XXL"));
			productoRepository.save(producto5);

			Producto producto6 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Camerun/frenteCamerun-removebg-preview_la2txt.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Camerun/atrasCamerun-removebg-preview_lwocxf.png"), "Camiseta Camerun", 15, 100.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto6);

			Producto producto7 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Canada/adelanteCanada_kq9g1p.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Canada/Sin_t%C3%ADtulo-1-removebg-preview_szfoig.png"), "Camiseta Canada", 15, 100.00, List.of( "S", "M", "L"));
			productoRepository.save(producto7);

			Producto producto8 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Corea_Del_Sur/frenteCorea-removebg-preview_mbkxi2.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Corea_Del_Sur/atrasCorea_ravj6s.png"), "Camiseta Corea del Sur", 15, 100.00, List.of( "XS","S", "M", "L"));
			productoRepository.save(producto8);

			Producto producto9 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Costa_Rica/frenteCostaRica-removebg-preview_acockd.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Costa_Rica/Sin_t%C3%ADtulo-2-removebg-preview_1_nnw3bv.png"), "Camiseta Costa Rica", 15, 100.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto9);

			Producto producto10 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Croacia/frenteCroacia-removebg-preview_1_gwxzcg.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Croacia/atrasCroacia-removebg-preview_xz02oi.png"), "Camiseta Croacia", 15, 120.00, List.of( "S", "M", "L"));
			productoRepository.save(producto10);

			Producto producto11 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748012/Camisetas%20del%20mundial/Dinamarca/frenteDinamarca-removebg-preview_mjibia.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748012/Camisetas%20del%20mundial/Dinamarca/atrasDinamarca-removebg-preview_a4g4c2.png"), "Camiseta Dinamarca", 15, 80.00, List.of( "XS", "S", "M", "L", "XL"));
			productoRepository.save(producto11);

			Producto producto12 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748012/Camisetas%20del%20mundial/Ecuador/frenteEcuador-removebg-preview_lfjvek.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748012/Camisetas%20del%20mundial/Ecuador/atrasEcuador-removebg-preview_gyxirl.png"), "Camiseta Ecuador", 5, 80.00, List.of( "S", "M", "L"));
			productoRepository.save(producto12);

			Producto producto13 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748013/Camisetas%20del%20mundial/Espa%C3%B1a/frenteEspa%C3%B1a-removebg-preview_y9iwpw.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748013/Camisetas%20del%20mundial/Espa%C3%B1a/atrasEspa%C3%B1a-removebg-preview_jhzsdo.png"), "Camiseta España", 10, 120.00, List.of( "XS", "S", "M"));
			productoRepository.save(producto13);

			Producto producto14 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748013/Camisetas%20del%20mundial/Estados_Unidos/frenteEstadosUnidos2-removebg-preview_psusdb.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748013/Camisetas%20del%20mundial/Estados_Unidos/atrasEstadosUnidos-removebg-preview_bgrysi.png"), "Camiseta Estados Unidos", 25, 80.00, List.of("XL", "XXL"));
			productoRepository.save(producto14);

			Producto producto15 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748014/Camisetas%20del%20mundial/Francia/frenteFrancia-removebg-preview_kmitwk.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748014/Camisetas%20del%20mundial/Francia/atrasFrancia-removebg-preview_bfebuv.png"), "Camiseta Francia", 15, 120.00, List.of( "XS", "S"));
			productoRepository.save(producto15);

			Producto producto16 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748014/Camisetas%20del%20mundial/Gales/frenteGales2-removebg-preview_vygn9p.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748014/Camisetas%20del%20mundial/Gales/atrasGales-removebg-preview_uiva9v.png"), "Camiseta Gales", 15, 100.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto16);

			Producto producto17 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748015/Camisetas%20del%20mundial/Ghana/frenteghana-removebg-preview_ulzpcu.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748015/Camisetas%20del%20mundial/Ghana/atrasGhana-removebg-preview_jiijis.png"), "Camiseta Ghana", 15, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto17);

			Producto producto18 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748015/Camisetas%20del%20mundial/Holanda/frenteHolanda-removebg-preview_mhuwsr.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748015/Camisetas%20del%20mundial/Holanda/atrasHolanda-removebg-preview_kyx27o.png"), "Camiseta Holanda", 15, 120.00, List.of( "XS", "S", "M"));
			productoRepository.save(producto18);

			Producto producto19 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Inglaterra/frenteInglaterra-removebg-preview_bxb8sz.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Inglaterra/atrasInglaterra-removebg-preview_bn15xl.png"), "Camiseta Inglaterra", 10, 120.00, List.of("XL", "XXL"));
			productoRepository.save(producto19);

			Producto producto20 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Iran/frenteIran-removebg-preview_sbuntl.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Iran/espaldaIran-removebg-preview_uqqyuu.png"), "Camiseta Iran", 15, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto20);

			Producto producto21 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748017/Camisetas%20del%20mundial/Japon/frenteJapon-removebg-preview_hmqup6.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Japon/espaldaJapon-removebg-preview_bll3gf.png"), "Camiseta Japon ", 15, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto21);

			// Cliente admin = new Cliente("Sebas", "Granados", "loquesea@gmail.com", passwordEnconder.encode("1234"), 0);
		};
	}
}
