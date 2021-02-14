package com.ninjati.devops.Interfaz;

import java.util.List;

import com.ninjati.devops.Modelo.ProductoMO;

public interface ProductoIN {
    List<ProductoMO> ListarProductos();
    ProductoMO ConsultarProducto(long id);
    ProductoMO CrearProducto(ProductoMO productoMO);
    ProductoMO EditarProducto(ProductoMO productoMO);
    void EliminarProducto(long id);
}
