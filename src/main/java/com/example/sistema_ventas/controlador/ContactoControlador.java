package com.example.sistema_ventas.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_ventas.modelo.Contacto;
import com.example.sistema_ventas.servicio.ContactoServicio;

@RestController
@RequestMapping("/api/contactos")
public class ContactoControlador {

    @Autowired
    private ContactoServicio contactoServicio;

    // Crear un nuevo contacto
    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoServicio.crearContacto(contacto);
    }

    // Obtener todos los contactos
    @GetMapping
    public List<Contacto> obtenerContactos() {
        return contactoServicio.obtenerContactos();
    }

    // Obtener un contacto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Contacto> obtenerContactoPorId(@PathVariable String id) {
        Optional<Contacto> contactoOpt = contactoServicio.obtenerContactoPorId(id);
        return contactoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un contacto
    @PutMapping("/{id}")
    public ResponseEntity<Contacto> actualizarContacto(@PathVariable String id, @RequestBody Contacto contacto) {
        Optional<Contacto> contactoOpt = contactoServicio.obtenerContactoPorId(id);
        if (contactoOpt.isPresent()) {
            Contacto contactoExistente = contactoOpt.get();
            contactoExistente.setNombre(contacto.getNombre());
            contactoExistente.setTelefono(contacto.getTelefono());
            contactoExistente.setCorreoElectronico(contacto.getCorreoElectronico());
            contactoExistente.setEmpresaId(contacto.getEmpresaId());
            Contacto contactoActualizado = contactoServicio.actualizarContacto(contactoExistente);
            return ResponseEntity.ok(contactoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un contacto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable String id) {
        contactoServicio.eliminarContacto(id);
        return ResponseEntity.noContent().build();
    }
}
