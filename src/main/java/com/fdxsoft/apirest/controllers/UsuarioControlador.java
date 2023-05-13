package com.fdxsoft.apirest.controllers;

import com.fdxsoft.apirest.models.UsuarioModelo;
import com.fdxsoft.apirest.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping
    public ArrayList<UsuarioModelo> obtenerUsuarios(){
        return usuarioServicio.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModelo guardarUsuario(@RequestBody UsuarioModelo usuarioModelo){
        return usuarioServicio.guardarUsuario(usuarioModelo);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModelo> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioServicio.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModelo> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServicio.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok= this.usuarioServicio.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id = " + id;
        } else {
            return "NO se pudo elimiar el usuario con id = " + id;
        }
    }
}
