package com.api.vendedores_api_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.api.vendedores_api_spring_boot.dto.VendedorDto;
import com.api.vendedores_api_spring_boot.services.VendedorServices;

@RestController
@RequestMapping("/api/vendedores")


public class VendedorController {

    @Autowired
    private VendedorServices venSer;

    @PostMapping
    public ResponseEntity<VendedorDto> crearVen(@RequestBody VendedorDto dto) {
        return ResponseEntity.ok(venSer.crearVen(dto));
    }

    @GetMapping
    public ResponseEntity<List<VendedorDto>> listarVen() {
        return ResponseEntity.ok(venSer.listarVen());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDto> obtener(@PathVariable Integer ID_Vendedor) {
        return ResponseEntity.ok(venSer.buscarVen(ID_Vendedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDto> actualizar(@PathVariable Integer ID_Vendedor, @RequestBody VendedorDto dto) {
        return ResponseEntity.ok(venSer.actuaVen(ID_Vendedor, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer ID_Vendedor) {
        venSer.eliminarVen(ID_Vendedor);
        return ResponseEntity.noContent().build();
    }

}
