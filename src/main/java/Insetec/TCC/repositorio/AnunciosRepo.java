package Insetec.TCC.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Insetec.TCC.models.Anuncio;

public interface AnunciosRepo extends CrudRepository<Anuncio, Integer>{

    @Query(value="SELECT * FROM anuncio ORDER BY id DESC", nativeQuery = true)
    List<Anuncio> findAllByOrderByIdDesc();

}
