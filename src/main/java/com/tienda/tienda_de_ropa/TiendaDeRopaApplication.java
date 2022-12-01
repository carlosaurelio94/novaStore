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

			Producto producto32 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Brasil/frenteBrasil_ejttca.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Brasil/AtrasBrasil_tdkppe.png"), "Camiseta Brasil ", 5, 120.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto32);

			Producto producto6 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Camerun/frenteCamerun-removebg-preview_la2txt.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748009/Camisetas%20del%20mundial/Camerun/atrasCamerun-removebg-preview_lwocxf.png"), "Camiseta Camerun", 15, 100.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto6);

			Producto producto7 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Canada/adelanteCanada_kq9g1p.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Canada/Sin_t%C3%ADtulo-1-removebg-preview_szfoig.png"), "Camiseta Canada", 15, 100.00, List.of( "S", "M", "L"));
			productoRepository.save(producto7);

			Producto producto8 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Corea_Del_Sur/frenteCorea-removebg-preview_mbkxi2.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748010/Camisetas%20del%20mundial/Corea_Del_Sur/atrasCorea_ravj6s.png"), "Camiseta Corea del Sur", 15, 100.00, List.of( "XS","S", "M", "L"));
			productoRepository.save(producto8);

			Producto producto9 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669823717/Camisetas%20del%20mundial/Costa_Rica/image-removebg-preview_-_2022-11-30T125433.000_mfxyud.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748011/Camisetas%20del%20mundial/Costa_Rica/Sin_t%C3%ADtulo-2-removebg-preview_1_nnw3bv.png"), "Camiseta Costa Rica", 15, 100.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
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

			Producto producto20 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Iran/frenteIran-removebg-preview_sbuntl.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Iran/espaldaIran-removebg-preview_uqqyuu.png"), "Camiseta Iran", 25, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto20);

			Producto producto21 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748017/Camisetas%20del%20mundial/Japon/frenteJapon-removebg-preview_hmqup6.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748016/Camisetas%20del%20mundial/Japon/espaldaJapon-removebg-preview_bll3gf.png"), "Camiseta Japon ", 10, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto21);

			Producto producto22 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748003/Camisetas%20del%20mundial/Marruecos/frenteMarruecos-removebg-preview_t68nx4.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748003/Camisetas%20del%20mundial/Marruecos/espaldaMarruecos-removebg-preview_dijmkl.png"), "Camiseta Marruecos ", 15, 90.00, List.of( "XS", "S", "M", "L"));
			productoRepository.save(producto22);

			Producto producto23 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748004/Camisetas%20del%20mundial/Mexico/frenteMexico-removebg-preview_pvxz7w.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748003/Camisetas%20del%20mundial/Mexico/espaldaMexico-removebg-preview_yipqjl.png"), "Camiseta Mexico ", 25, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto23);

			Producto producto24 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748003/Camisetas%20del%20mundial/Polonia/frentePolonia-removebg-preview_rcpbht.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748003/Camisetas%20del%20mundial/Polonia/espaldaPolonia-removebg-preview_ixk4vm.png"), "Camiseta Polonia ", 15, 100.00, List.of( "XXL"));
			productoRepository.save(producto24);

			Producto producto25 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748004/Camisetas%20del%20mundial/Portugal/frentePortugal-removebg-preview_s9xm1b.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748004/Camisetas%20del%20mundial/Portugal/espaldaPortugal-removebg-preview_jgzpnl.png"), "Camiseta Portugal", 10, 120.00, List.of( "XS", "S", "M", "L"));
			productoRepository.save(producto25);

			Producto producto26 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748005/Camisetas%20del%20mundial/Qatar/frenteQatar-removebg-preview_ideqxv.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748004/Camisetas%20del%20mundial/Qatar/espaldaQatar-removebg-preview_fyufht.png"), "Camiseta Qatar", 30, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto26);

			Producto producto27 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748006/Camisetas%20del%20mundial/Senegal/frenteSenegal-removebg-preview_s5sgbp.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748005/Camisetas%20del%20mundial/Senegal/espaldaSenegal-removebg-preview_yekvlu.png"), "Camiseta Senegal ", 15, 100.00, List.of( "XS", "S"));
			productoRepository.save(producto27);

			Producto producto28 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748005/Camisetas%20del%20mundial/Serbia/frenteSerbia-removebg-preview_v461ow.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748005/Camisetas%20del%20mundial/Serbia/espaldaSerbia-removebg-preview_mkgxgp.png"), "Camiseta Serbia", 25, 80.00, List.of( "L", "XL", "XXL"));
			productoRepository.save(producto28);

			Producto producto29 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748006/Camisetas%20del%20mundial/Suiza/frenteSuiza-removebg-preview_qhm0qi.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748005/Camisetas%20del%20mundial/Suiza/espaldaSuiza-removebg-preview_qkldlh.png"), "Camiseta Suiza ", 15, 90.00, List.of("XL", "XXL"));
			productoRepository.save(producto29);

			Producto producto30 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748007/Camisetas%20del%20mundial/Tunez/frenteTunez-removebg-preview_cbrlxh.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748005/Camisetas%20del%20mundial/Tunez/espaldaTunez-removebg-preview_ywmkbc.png"), "Camiseta Tunez ", 15, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto30);

			Producto producto31 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748007/Camisetas%20del%20mundial/Uruguay/frenteUruguay-removebg-preview_t9hwny.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669748007/Camisetas%20del%20mundial/Uruguay/espaldaUruguay-removebg-preview_nqd7cx.png"), "Camiseta Uruguay ", 15, 120.00, List.of(  "M", "L", "XL"));
			productoRepository.save(producto31);

			Producto producto33 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861514/Zapatillas/LITE%20RACER%20CLN%202.0/image-removebg-preview_77_jhaery.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861514/Zapatillas/LITE%20RACER%20CLN%202.0/image-removebg-preview_78_rbdvir.png"), "Zapatilla LITE RACER CLN 2.0  ", 10, 50.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto33);

			Producto producto34 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861487/Accesorios/Ball%20pump/image-removebg-preview_17_x8vsps.png"), "Inflador Nike", 5, 20.00, List.of( "XS"));
			productoRepository.save(producto34);

			Producto producto35 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861489/Accesorios/Bottle/image-removebg-preview_19_hs4stk.png"), "Botella Nike", 5, 15.00, List.of( "XS"));
			productoRepository.save(producto35);

			Producto producto36 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861492/Accesorios/Gloves/image-removebg-preview_21_uvlitb.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861489/Accesorios/Gloves/image-removebg-preview_20_gho10i.png"), "Guantes Deportivos", 5, 25.00, List.of( "XS"));
			productoRepository.save(producto36);

			Producto producto37 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861497/Accesorios/Headbands/image-removebg-preview_25_lczf5e.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861497/Accesorios/Headbands/image-removebg-preview_24_w6zuoz.png"), "Vinchas deportivas  ", 15, 10.00, List.of( "XS"));
			productoRepository.save(producto37);

			Producto producto38 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861500/Accesorios/Skull%20wrap/image-removebg-preview_26_e9fa83.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861500/Accesorios/Skull%20wrap/image-removebg-preview_27_zdakxq.png"), "Cinta cabeza", 8, 15.00, List.of( "XS"));
			productoRepository.save(producto38);

			Producto producto39 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861494/Pelotas/Pelota%20Basquet/Nike%20Standard%208P%20colores/image-removebg-preview_57_ya9azi.png"), "Pelota basquet Nike Standard 8P Multicolor", 5, 50.00, List.of( "XS"));
			productoRepository.save(producto39);

			Producto producto40 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861501/Pelotas/Pelota%20Basquet/Nike%20Standard%208P%20Naranja/elite-championship-8p-basketball-hjNbR5_wynvgm.png"), "Pelota basquet Nike Standard 8P Naranja", 5, 45.00, List.of( "XS"));
			productoRepository.save(producto40);

			Producto producto41 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861494/Pelotas/Pelota%20Basquet/Nike%20Standard%208p%20Violeta/image-removebg-preview_58_ur53qc.png"), "Pelota basquet Nike Standard 8p Violeta", 5, 60.00, List.of( "XS"));
			productoRepository.save(producto41);

			Producto producto42 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861494/Pelotas/Pelota%20Rugby/Nike%20Vapor%2024%207%20Gris/vapor-24-7-football-g7JXx1_mapmug.png"), "Pelota rugby Nike Vapor 24 7 gris ", 10, 40.00, List.of( "XS"));
			productoRepository.save(producto42);

			Producto producto43 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861494/Pelotas/Pelota%20Rugby/Nike%20Vapor%2024%207%20verde/image-removebg-preview_59_y1sdak.png"), "Pelota rugby Nike Vapor 24 7 verde  ", 8, 35.00, List.of( "XS"));
			productoRepository.save(producto43);

			Producto producto44 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861495/Pelotas/Pelotas%20Futbol/MINIPELOTA%20ARGENTUM%2022/image-removebg-preview_60_bbp6q4.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861495/Pelotas/Pelotas%20Futbol/MINIPELOTA%20ARGENTUM%2022/image-removebg-preview_61_esbqaw.png"), "Minipelota Argentum 22 edición boca ", 15, 60.00, List.of( "XS"));
			productoRepository.save(producto44);

			Producto producto45 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861496/Pelotas/Pelotas%20Futbol/MINIPELOTA%20UCL%20VOID/image-removebg-preview_63_d1xxzf.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861496/Pelotas/Pelotas%20Futbol/MINIPELOTA%20UCL%20VOID/image-removebg-preview_62_r4lsar.png"), "Minipelota UCL void ", 15, 60.00, List.of( "XS"));
			productoRepository.save(producto45);

			Producto producto46 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861497/Pelotas/Pelotas%20Futbol/PELOTA%20AL%20RIHLA%20CLUB/image-removebg-preview_64_qkq3uc.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861497/Pelotas/Pelotas%20Futbol/PELOTA%20AL%20RIHLA%20CLUB/image-removebg-preview_65_lc3hon.png"), "Pelota Al Rihla Club", 15, 80.00, List.of( "XS"));
			productoRepository.save(producto46);

			Producto producto47 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861498/Pelotas/Pelotas%20Futbol/PELOTA%20AL%20RIHLA%20PRO/image-removebg-preview_68_yqomm5.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861498/Pelotas/Pelotas%20Futbol/PELOTA%20AL%20RIHLA%20PRO/image-removebg-preview_69_ve3jtg.png"), "Pelota Al Rihla Pro", 2, 200.00, List.of( "XS"));
			productoRepository.save(producto47);

			Producto producto48 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861499/Pelotas/Pelotas%20Futbol/PELOTA%20CLUB%20ARGENTINA/Minipelota_Argentum_22_Blanco_HE3789_02_standard_hover-removebg-preview_lacimf.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861498/Pelotas/Pelotas%20Futbol/PELOTA%20CLUB%20ARGENTINA/image-removebg-preview_70_mzzh75.png"), "Minipelota Argentum 22 ", 5, 50.00, List.of( "XS"));
			productoRepository.save(producto48);

			Producto producto49 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861499/Raqueta%20Tenis/Raqueta%20wilson%20amarilla/image-removebg-preview_71_bcmip6.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861500/Raqueta%20Tenis/Raqueta%20wilson%20amarilla/image-removebg-preview_72_fig6ac.png"), "Raqueta Wilson amarilla", 5, 100.00, List.of( "XS"));
			productoRepository.save(producto49);

			Producto producto50 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861500/Raqueta%20Tenis/Raqueta%20wilson%20roja%20negra/image-removebg-preview_73_tmlstc.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861500/Raqueta%20Tenis/Raqueta%20wilson%20roja%20negra/image-removebg-preview_74_nlatxo.png"), "Raqueta Wilson Roja y Negra", 5, 100.00, List.of( "XS"));
			productoRepository.save(producto50);

			Producto producto51 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861509/Short/SHORT%20TITULAR%20BOCA%20JUNIORS%2022%2023/image-removebg-preview_1_r0pchu.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861509/Short/SHORT%20TITULAR%20BOCA%20JUNIORS%2022%2023/image-removebg-preview_2_ht2gar.png"), "Short titular Boca Juniors 22 23", 10, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto51);

			Producto producto52 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861510/Short/SHORTS%20DE%20LOCAL%20FC%20BAYERN%2022%2023/image-removebg-preview_3_ahyk7v.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861510/Short/SHORTS%20DE%20LOCAL%20FC%20BAYERN%2022%2023/image-removebg-preview_4_tqm3ez.png"), "Short Fc Bayern 22 23", 15, 100.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto52);

			Producto producto53 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861511/Short/SHORTS%20DE%20TITULAR%20JUVENTUS%2022%2023/image-removebg-preview_5_y6isus.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861511/Short/SHORTS%20DE%20TITULAR%20JUVENTUS%2022%2023/image-removebg-preview_6_k1a1ow.png"), "Short titular Juventos", 15, 120.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto53);

			Producto producto54 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861512/Short/SHORTS%20LOCAL%20AJAX%20AMSTERDAM%2022%2023/image-removebg-preview_7_vesvsz.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861513/Short/SHORTS%20LOCAL%20AJAX%20AMSTERDAM%2022%2023/image-removebg-preview_8_w2nexp.png"), "Short local Ajax 22 23", 15, 90.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto54);

			Producto producto55 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861513/Short/SHORTS%20TITULAR%20ARGENTINA%2021/image-removebg-preview_9_gfuyyk.png", "https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861512/Short/SHORTS%20TITULAR%20ARGENTINA%2021/image-removebg-preview_10_gxxc6x.png"), "Short titular Argentina 21", 15, 70.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto55);

			Producto producto56 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861513/Short/SHORTS%20UNIFORME%20DE%20TITULAR%20MANCHESTER%20UNITED%2022%2023/image-removebg-preview_12_cmdeqz.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861513/Short/SHORTS%20UNIFORME%20DE%20TITULAR%20MANCHESTER%20UNITED%2022%2023/image-removebg-preview_13_xv6i9m.png"), "Short titular Mancheste United 22 23", 15, 120.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto56);

			Producto producto57 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861513/Short/SHORTS%20VISITANTE%20RIVER%20PLATE%2020%2021/image-removebg-preview_14_slly5b.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861513/Short/SHORTS%20VISITANTE%20RIVER%20PLATE%2020%2021/image-removebg-preview_15_cagqky.png"), "Short River Plate 20 21", 15, 80.00, List.of( "XS", "S", "M", "L", "XL", "XXL"));
			productoRepository.save(producto57);

			Producto producto58 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861515/Zapatillas/ZAPATILLAS%20DURAMO%20SL/image-removebg-preview_81_nrmsat.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861515/Zapatillas/ZAPATILLAS%20DURAMO%20SL/image-removebg-preview_83_rz2sop.png"), "Zapatillas Duramo SL", 15, 50.00, List.of( "XS"));
			productoRepository.save(producto58);

			Producto producto59 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861516/Zapatillas/ZAPATILLAS%20GALAXAR%20RUN/image-removebg-preview_87_acqhkf.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861516/Zapatillas/ZAPATILLAS%20GALAXAR%20RUN/image-removebg-preview_86_nbdvim.png"), "Zapatillas Galaxar run", 15, 60.00, List.of( "XS"));
			productoRepository.save(producto59);

			Producto producto60 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861517/Zapatillas/ZAPATILLAS%20GALAXY%206/image-removebg-preview_88_qekrw8.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861517/Zapatillas/ZAPATILLAS%20GALAXY%206/image-removebg-preview_91_m1q2m5.png"), "Zapatilla Galaxy 6", 15, 50.00, List.of( "XS"));
			productoRepository.save(producto60);

			Producto producto61 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861519/Zapatillas/ZAPATILLAS%20SUPERNOVA%2B/image-removebg-preview_93_zy4nqw.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861519/Zapatillas/ZAPATILLAS%20SUPERNOVA%2B/image-removebg-preview_96_c08up1.png"), "Zapatillas Supernova+", 10, 70.00, List.of( "XS"));
			productoRepository.save(producto61);

			Producto producto62 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861521/Zapatillas/ZAPATILLAS%20ULTRABOOST%2022/image-removebg-preview_99_lx2zqm.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861521/Zapatillas/ZAPATILLAS%20ULTRABOOST%2022/image-removebg-preview_97_wd5n2l.png"), "Zapatillas Ultraboost 22", 15, 65.00, List.of( "XS"));
			productoRepository.save(producto62);

			Producto producto63 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861522/Zapatillas/ZAPATLLAS%20RUN%20FALCON%202.0/image-removebg-preview_-_2022-11-28T105422.874_dflxsj.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861522/Zapatillas/ZAPATLLAS%20RUN%20FALCON%202.0/image-removebg-preview_-_2022-11-28T124518.496_mvmeqn.png"), "Zapatillas Run Falcon 2.0", 15, 80.00, List.of( "XS"));
			productoRepository.save(producto63);

			Producto producto64 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861502/Botines/BOTINES%20COPA%20SENSE.3%20SIN%20CORDONES%20TERRENO%20FIRME/image-removebg-preview_30_t1wkxn.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861502/Botines/BOTINES%20COPA%20SENSE.3%20SIN%20CORDONES%20TERRENO%20FIRME/image-removebg-preview_31_h1i5ht.png"), "Botines Adidas copa Sense 3 sin Cordones", 15, 150.00, List.of( "XS"));
			productoRepository.save(producto64);

			Producto producto65 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861503/Botines/BOTINES%20COPA%20SENSE.3%20TERRENO%20FIRME/image-removebg-preview_-_2022-11-28T124654.063_womkhv.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861503/Botines/BOTINES%20COPA%20SENSE.3%20TERRENO%20FIRME/image-removebg-preview_-_2022-11-28T124643.548_x0bbxc.png"), "Botines Adidas Copa sense 3 Terreno Firme", 15, 150.00, List.of( "XS"));
			productoRepository.save(producto65);

			Producto producto66 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861505/Botines/BOTINES%20PREDATOR%20EDGE.1%20LOW%20TERRENO%20FIRME/image-removebg-preview_32_tucx2t.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861505/Botines/BOTINES%20PREDATOR%20EDGE.1%20LOW%20TERRENO%20FIRME/image-removebg-preview_35_dztn4e.png"), "Botines Adidas Predator edge 1 low", 15, 150.00, List.of( "XS"));
			productoRepository.save(producto66);

			Producto producto67 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861507/Botines/BOTINES%20PREDATOR%20EDGE.3%20SIN%20CORDONES%20C%C3%89SPED%20ARTIFICIAL/image-removebg-preview_36_bfpoig.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861507/Botines/BOTINES%20PREDATOR%20EDGE.3%20SIN%20CORDONES%20C%C3%89SPED%20ARTIFICIAL/image-removebg-preview_37_zemqub.png"), "Botines Adidas Predator edge 3 sin cordones", 15, 80.00, List.of( "XS"));
			productoRepository.save(producto67);

			Producto producto68 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861508/Botines/BOTINES%20PREDATOR%20EDGE.4%20MULTITERRENO/image-removebg-preview_39_ycj6vl.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861488/Botines/BOTINES%20PREDATOR%20EDGE.4%20MULTITERRENO/image-removebg-preview_42_yecjyd.png"), "Botines Adidas predator edge 4", 15, 80.00, List.of( "XS"));
			productoRepository.save(producto68);

			Producto producto69 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861489/Botines/BOTINES%20X%20SPEEDPORTAL.3%20TERRENO%20FIRME/image-removebg-preview_43_tivsrd.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861490/Botines/BOTINES%20X%20SPEEDPORTAL.3%20TERRENO%20FIRME/image-removebg-preview_46_ntwzbo.png"), "Botines Adidas x Speedportal 3", 15, 95.00, List.of( "XS"));
			productoRepository.save(producto69);

			Producto producto70 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669871222/Botines/BOTINES%20X%20SPEEDPORTAL.4%20MULTITERRENO/image-removebg-preview_-_2022-12-01T020643.318_xedi5o.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861491/Botines/BOTINES%20X%20SPEEDPORTAL.4%20MULTITERRENO/image-removebg-preview_49_ojhy3n.png"), "Botines Adidas x Speedportal 4", 15, 90.00, List.of( "XS"));
			productoRepository.save(producto70);

			Producto producto71 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861492/Botines/Nike%20Vapor%20Edge%20Pro%20360/image-removebg-preview_51_j2jl6n.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861492/Botines/Nike%20Vapor%20Edge%20Pro%20360/image-removebg-preview_53_tddigx.png"), "Nike Vapor Edge Pro 360 ", 15, 150.00, List.of( "XS"));
			productoRepository.save(producto71);

			Producto producto72 = new Producto(List.of("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861493/Botines/Nike%20Zoom%20Mercurial%20Superfly%209%20Elite%20FG/image-removebg-preview_55_qsafal.png","https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669861493/Botines/Nike%20Zoom%20Mercurial%20Superfly%209%20Elite%20FG/image-removebg-preview_56_m4al72.png"), "Nike Zoom Mercurial Superfly 9 Elite", 15, 120.00, List.of( "XS"));
			productoRepository.save(producto72);

			// Cliente admin = new Cliente("Sebas", "Granados", "loquesea@gmail.com", passwordEnconder.encode("1234"), 0);
		};
	}
}
