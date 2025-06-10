package com.api.vendedores_api_spring_boot.services;

import com.api.vendedores_api_spring_boot.models.Vendedor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendedores_api_spring_boot.dto.VendedorDto;
import com.api.vendedores_api_spring_boot.repository.VendedorRepository;

@Service

public class VendedorServices {

    @Autowired

    private VendedorRepository venRep;

    private Vendedor toEntity(VendedorDto dto)

    { 
        Vendedor ven = new Vendedor();
        ven.setID_Vendedor(dto.getID_Vendedor());
        ven.setSucursal(dto.getSucursal());
        return ven;
    }

    private VendedorDto toDto(Vendedor ven)

    {
        VendedorDto dto = new VendedorDto();
        dto.setID_Vendedor(ven.getID_Vendedor());
        dto.setSucursal(ven.getSucursal());
        return dto;
    }

    public VendedorDto crearVen (VendedorDto dto)

    {
        Vendedor ven = toEntity(dto);
        Vendedor savedVendedor = venRep.save(ven);
        return toDto(savedVendedor);
    }

    public List <VendedorDto> listarVen()
    {
        return venRep.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public VendedorDto buscarVen(Integer ID_Vendedor)
    {
        Vendedor ven = venRep.findById(ID_Vendedor).orElseThrow(() -> new RuntimeException("Vendedor no encontrado."));
        return toDto(ven);
    }

    public VendedorDto actuaVen(Integer ID_Vendedor, VendedorDto dto)
    {
        Vendedor venExi = venRep.findById(ID_Vendedor)
        .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + ID_Vendedor));

        venExi.setSucursal(dto.getSucursal());

        return toDto(venRep.save(venExi));
    }

    public void eliminarVen(Integer ID_Vendedor)
    {
        venRep.deleteById(ID_Vendedor);
    }
}
