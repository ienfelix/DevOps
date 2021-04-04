package com.ninjati.devops.Controlador;

import java.util.List;

import javax.validation.Valid;

import com.ninjati.devops.Modelo.ProductoMO;
import com.ninjati.devops.Negocio.ProductoNE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ResponseBody
@RequestMapping("Producto")
public class ProductoController {
    
    @Autowired
    private ProductoNE _productoNE;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String Get() {
        return "Ok";
    }

    @GetMapping(path = "ListarProductos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoMO> ListarProductos() {
        return _productoNE.ListarProductos();
    }

    @GetMapping(path = "ConsultarProducto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoMO ConsultarProducto(@PathVariable long id) {
        return _productoNE.ConsultarProducto(id);
    }

    @PostMapping(path = "CrearProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoMO CrearProducto(@Valid @RequestBody ProductoMO productoMO) {
        return _productoNE.CrearProducto(productoMO);
    }

    @PutMapping(path = "EditarProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoMO EditarProducto(@Valid @RequestBody ProductoMO productoMO) {
        return _productoNE.EditarProducto(productoMO);
    }

    @DeleteMapping(path = "EliminarProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> EliminarProducto(@RequestParam long id) {
        _productoNE.EliminarProducto(id);
        return new ResponseEntity<String>(String.valueOf(id), HttpStatus.OK);
    }
}
