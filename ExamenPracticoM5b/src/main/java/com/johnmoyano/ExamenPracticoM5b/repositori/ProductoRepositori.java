/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.johnmoyano.ExamenPracticoM5b.repositori;

import com.johnmoyano.ExamenPracticoM5b.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jon
 */
public interface ProductoRepositori extends JpaRepository<Producto, Integer>{
    
     @Query(value = "Select * from producto c where c.codigo = :codigo", nativeQuery = true)
    public Producto buscarCliente(String codigo);
}
