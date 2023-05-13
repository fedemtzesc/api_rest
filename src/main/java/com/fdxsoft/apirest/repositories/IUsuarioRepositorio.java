package com.fdxsoft.apirest.repositories;

import com.fdxsoft.apirest.models.UsuarioModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUsuarioRepositorio extends CrudRepository<UsuarioModelo, Long> {
    public ArrayList<UsuarioModelo> findByPrioridad(Integer prioridad);

}
