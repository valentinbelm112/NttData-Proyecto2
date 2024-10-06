package com.microservicios.cliente.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    @NotNull(message = "El nombre no puede se de tipo null")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "apellido", length = 100)
    @NotNull(message = "El nombre no puede se de tipo null")
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Column(name = "dni", unique = true, length = 8)
    @NotNull(message = "El nombre no puede se de tipo null")
    @NotBlank(message = "El DNI no puede estar vacío")
    private String dni;

    @Column(name = "email", unique = true, length = 100)
    @Email(message = "El email esta con formato no valido")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", length = 255)
    private String direccion;

    public ClienteEntity() {

    }


}