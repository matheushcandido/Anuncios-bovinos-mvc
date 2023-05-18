package Insetec.TCC.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import Insetec.TCC.models.Usuario;

public interface UsuariosRepo extends CrudRepository<Usuario, Integer> {
    
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from usuario where id = :id", nativeQuery = true)
    public boolean exist(int id);

}
