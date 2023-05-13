package com.fdxsoft.apirest.services;

import com.fdxsoft.apirest.models.UsuarioModelo;
import com.fdxsoft.apirest.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    public ArrayList<UsuarioModelo> obtenerUsuarios(){
        return (ArrayList<UsuarioModelo>)usuarioRepositorio.findAll();
    }

    public UsuarioModelo guardarUsuario(UsuarioModelo usuarioModelo){
        return usuarioRepositorio.save(usuarioModelo);
    }

    public Optional<UsuarioModelo> obtenerPorId(Long id){
        return usuarioRepositorio.findById(id);
    }

    public ArrayList<UsuarioModelo> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepositorio.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepositorio.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
