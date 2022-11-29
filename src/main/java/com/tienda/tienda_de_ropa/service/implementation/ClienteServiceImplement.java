package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import com.tienda.tienda_de_ropa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public List<ClienteDTO> getClientesDTO() {
        return clienteRepository.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO clienteDTO(long id) {
        return clienteRepository.findById(id).map(cliente -> new ClienteDTO(cliente)).orElse(null);
    }

    @Override
    public Cliente findByCorreo(String correo) {
        return clienteRepository.findByCorreo(correo);
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente encontrarPorId(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public void enviarCorreoVerificacion(Cliente cliente, String sitioURL) throws MessagingException, UnsupportedEncodingException {
        String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido() + "!";
        String asunto = "Verifique su registro en Nova Store!";
        String remitente = "Nova Store Team";
        String contenido = "<p>Hola, " + nombreCompleto + ".</p>";
        contenido += "<p>Para verificar su cuenta haga click en el link de abajo</p>";
        String linkVerficacion = sitioURL + "/api/verificacion?token=" + cliente.getToken();
        contenido += "<a  href=\"" + linkVerficacion + "\" >Link</a>";
        contenido += "<p>Muchas gracias,<br>Nova Store Team</p>";

        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper ayuda = new MimeMessageHelper(mensaje);

        ayuda.setFrom("novastore2809@gmail.com", remitente);
        ayuda.setTo(cliente.getCorreo());
        ayuda.setSubject(asunto);
        ayuda.setText(contenido, true);

        mailSender.send(mensaje);
    }

    @Override
    public boolean verificacion(String token) {
        Cliente cliente = clienteRepository.findByToken(token);

        if (cliente == null || cliente.isHabilitado()) {
            return false;
        } else {
            cliente.setToken(null);
            cliente.setHabilitado(true);
            clienteRepository.save(cliente);
            return true;
        }
    }
}






















