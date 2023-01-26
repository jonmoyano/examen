/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johnmoyano.ExamenPracticoM5b.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jon
 */


@Setter
@Getter
@Entity
@Table(name ="/Producto")
public class Producto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @NotNull
    @Column(name = "descripcion")
    @Size(min = 5, max = 100)
    private String descripcion;

    @NotNull
    @Column(name = "cantidad")
    @Min(1)
    private Integer cantidad;

    @NotNull
    @Column(name = "precio")
    @Min(1)
    private Double precio;
}
