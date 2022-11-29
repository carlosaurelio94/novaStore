package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.ProductoDTO;
import com.tienda.tienda_de_ropa.models.*;
import com.tienda.tienda_de_ropa.repositories.OrdenCompraRepository;
import com.tienda.tienda_de_ropa.service.ClienteService;
import com.tienda.tienda_de_ropa.service.OrdenCompraService;
import com.tienda.tienda_de_ropa.service.ProductoService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    OrdenCompraService ordenCompraService;

    @Autowired
    OrdenCompraRepository ordenCompraRepository;

    @GetMapping("/productos")
    public List<ProductoDTO> traerTodos() {
        return productoService.traerTodos();
    }

    @PostMapping("/producto")
    public ResponseEntity<?> crearNuevoProducto(
            @RequestParam String URLImagen,
            @RequestParam String nombre,
            @RequestParam int stock,
            @RequestParam double precio,
            @RequestParam String talle
            ) {
        if (URLImagen.isEmpty()){
          return new ResponseEntity<>("El producto debe contener al menos una imagen", HttpStatus.FORBIDDEN);
        }
        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Falta el dato Nombre", HttpStatus.FORBIDDEN);
        }
        if (stock <= 0) {
            return new ResponseEntity<>("El stock no puede ser igual o menor a cero", HttpStatus.FORBIDDEN);
        }
        if (precio <= 0) {
            return new ResponseEntity<>("El precio del producto no puede ser igual o menor a cero", HttpStatus.FORBIDDEN);
        }

        Producto nuevoProducto = new Producto(List.of(URLImagen), nombre, stock, precio, List.of(talle));
        productoService.guardarProducto(nuevoProducto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PatchMapping("/agregar")
    public ResponseEntity<?> sumarProductos(
            Authentication autenticado,
            @RequestParam Long id
    )
    {
        Cliente clienteAutenticado = clienteService.findByCorreo(autenticado.getName());
        Carrito carrito = clienteAutenticado.getCarrito();
        Producto producto = productoService.productoPorId(id);
        boolean isOrdenCompra = carrito.getOrdenCompra().contains(producto);
        Set<OrdenCompra> ordenCompraSet = carrito.getOrdenCompra().stream()
                .filter(ordenCompra -> ordenCompra.getProducto().getNombre() == producto.getNombre()).collect(Collectors.toSet());
        OrdenCompra ordenCompra = ordenCompraSet.stream().findFirst().orElse(null);

        if(producto == null) {
            return new ResponseEntity<>("El producto no existe", HttpStatus.FORBIDDEN);
        }
        if(producto.getStock() == 0) {
            return new ResponseEntity<>("No quedan más unidades de este producto", HttpStatus.FORBIDDEN);
        }

        if (isOrdenCompra == false) {
        producto.setStock(producto.getStock() - 1);
        productoService.guardarProducto(producto);
        ordenCompraService.guardarOrdenCompra(new OrdenCompra(1, producto.getPrecio(), LocalDateTime.now(), carrito, producto));
        return new ResponseEntity<>("Este producto ha sido añadido al carrito", HttpStatus.ACCEPTED);
        }

        producto.setStock(producto.getStock() - 1);
        productoService.guardarProducto(producto);
        ordenCompra.setCantidad(ordenCompra.getCantidad() + 1);
        ordenCompra.setPrecio(producto.getPrecio() + producto.getPrecio());
        ordenCompraService.guardarOrdenCompra(ordenCompra);

        return new ResponseEntity<>("Este producto ha sido añadido al carrito", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/restar")
    public ResponseEntity<?> restarProductos(
            Authentication autenticado,
            @RequestParam Long id
    )
    {
        Cliente clienteAutenticado = clienteService.findByCorreo(autenticado.getName());
        Carrito carrito = clienteAutenticado.getCarrito();
        Producto producto = productoService.productoPorId(id);
        boolean isOrdenCompra = carrito.getOrdenCompra().contains(producto);
        Set<OrdenCompra> ordenCompraSet = carrito.getOrdenCompra().stream()
                .filter(ordenCompra -> ordenCompra.getProducto().getNombre().equals(producto.getNombre())).collect(Collectors.toSet());
        OrdenCompra ordenCompra = ordenCompraSet.stream().findFirst().orElse(null);

        if(producto == null) {
            return new ResponseEntity<>("El producto no existe", HttpStatus.FORBIDDEN);
        }
        if(producto.getStock() == 0) {
            return new ResponseEntity<>("No quedan más unidades de este producto", HttpStatus.FORBIDDEN);
        }
        if (isOrdenCompra == false) {
            return new ResponseEntity<>("Este producto no ha sido añadido al carrito", HttpStatus.ACCEPTED);
        }
        if (ordenCompra.getCantidad() == 0) {
            return new ResponseEntity<>("Este producto no ha sido añadido al carrito", HttpStatus.ACCEPTED);
        }

        producto.setStock(producto.getStock() + 1);
        productoService.guardarProducto(producto);
        ordenCompra.setCantidad(ordenCompra.getCantidad() - 1);
        ordenCompra.setPrecio(producto.getPrecio() - producto.getPrecio());
        ordenCompraService.guardarOrdenCompra(ordenCompra);

        return new ResponseEntity<>("Este producto ha sido añadido al carrito", HttpStatus.ACCEPTED);
    }

    /*
    @GetMapping("/prueba")
    public Producto prueba() {
        return new Producto("https://res.cloudinary.com/dqsq3fc1b/image/upload/v1669677008/kitten_mndwlu.png",
                "Gato", 1, 100.00, ProductoTalle.XL);
    }

    @PostMapping("/prueba")
    public ResponseEntity<?> prueba2(@RequestParam String foto) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dqsq3fc1b",
                "api_key", "459595897333933",
                "api_secret", "EQCJzwF3Xpdr1I09tY8KFfw8HUk",
                "secure", "true"));

        cloudinary.uploader().upload(new File("https://www.example.com/mysample.jpg"),
                ObjectUtils.asMap("public_id", "sample_woman"));

        return new ResponseEntity<>("das", HttpStatus.ACCEPTED);
    }
*/

}
