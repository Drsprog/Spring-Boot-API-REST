package com.drscode.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drscode.apirest.apirest.Entities.Producto;
import com.drscode.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: "+ id));
    }
    

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detalleProducto) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: "+id));
        
        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
          Producto producto = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: "+id));
        
        productoRepository.delete(producto);

        return "El producto con el ID "+ id + " fue eliminado correctamente";
    }
}