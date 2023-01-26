/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johnmoyano.ExamenPracticoM5b.service;

import com.johnmoyano.ExamenPracticoM5b.entity.Producto;
import com.johnmoyano.ExamenPracticoM5b.repositori.ProductoRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Jon
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements Productoservicio {
    
    @Autowired
    ProductoRepositori productoRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }

    public Producto buscarCliente(String cedula) {
        return productoRepository.buscarCliente(cedula);
    }
    
    public Producto ModificarCliente(@RequestBody Producto cli,@PathVariable String codigo){
        return productoRepository.save(cli);
    }

    @Override
    public void delete(Long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
