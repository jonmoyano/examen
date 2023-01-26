/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johnmoyano.ExamenPracticoM5b.entity.controller;

import com.johnmoyano.ExamenPracticoM5b.entity.Producto;
import com.johnmoyano.ExamenPracticoM5b.service.Productoservicio;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jon
 */

@RestController
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private Productoservicio productoService;

    @GetMapping("/ProductList")
    public ResponseEntity<List<Producto>> obtenerLista() {
        try {
            return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createProducto")
    public ResponseEntity<?> createProduct (@Valid @RequestBody Producto pr, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(productoService.save(pr), HttpStatus.CREATED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readProduct (@PathVariable (value = "id") Integer codigo){
        Optional<Producto> oSong = Optional.ofNullable(productoService.findById(codigo));

        if (!oSong.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oSong);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct (@RequestBody Producto pro, @PathVariable (value = "codigo") Integer codigo) {
        Optional<Producto> pr = Optional.ofNullable(productoService.findById(codigo));
        if (!pr.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        pr.get().setDescripcion(pro.getDescripcion());
        pr.get().setPrecio(pro.getPrecio());
        pr.get().setCantidad(pro.getCantidad());
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(pr.get()));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable (value = "codigo") Integer codigo) {
        try {
            productoService.delete(codigo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar producto");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
