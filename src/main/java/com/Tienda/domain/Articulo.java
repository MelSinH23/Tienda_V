package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idArticulo;
    private Long idCategoria;
    
    private String descripcion;
    private String detalle;
    private boolean activo;
    private double precio;
    private int existencias;
    
    public Articulo() {
    }

    public Articulo(Long idCategoria, String descripcion, String detalle, boolean activo, double precio, int existencias) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.activo = activo;
        this.precio = precio;
        this.existencias = existencias;
    }

    
    
    
}
