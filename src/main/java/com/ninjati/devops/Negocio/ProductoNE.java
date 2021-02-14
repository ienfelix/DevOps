package com.ninjati.devops.Negocio;

import java.util.List;

import com.google.common.collect.Lists;
import com.ninjati.devops.Interfaz.ProductoIN;
import com.ninjati.devops.Modelo.ProductoMO;
import com.ninjati.devops.Repositorio.ProductoRE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoNE implements ProductoIN {
    @Autowired
    private ProductoRE _productoRE;

    @Override
    public List<ProductoMO> ListarProductos() {
        return Lists.newArrayList(_productoRE.findAll());
    }

    @Override
    public ProductoMO ConsultarProducto(long id) {
        return _productoRE.findById(id).orElseThrow();
    }

    @Override
    public ProductoMO CrearProducto(ProductoMO productoMO) {
        return _productoRE.save(productoMO);
    }

    @Override
    public ProductoMO EditarProducto(ProductoMO productoMO) {
        return _productoRE.save(productoMO);
    }

    @Override
    public void EliminarProducto(long id) {
        _productoRE.deleteById(id);
    }
}
