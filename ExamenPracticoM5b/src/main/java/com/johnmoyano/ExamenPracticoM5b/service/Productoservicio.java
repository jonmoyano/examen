/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.johnmoyano.ExamenPracticoM5b.service;

import com.johnmoyano.ExamenPracticoM5b.entity.Producto;

/**
 *
 * @author Jon
 */
public interface Productoservicio extends GenericService<Producto, Integer>{

    public void delete(Long codigo);
    
}
