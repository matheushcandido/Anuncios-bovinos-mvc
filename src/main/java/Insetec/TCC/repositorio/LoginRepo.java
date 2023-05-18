package Insetec.TCC.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import Insetec.TCC.models.Usuario;



public interface LoginRepo extends CrudRepository<Usuario, Integer> {

    @Query(value="select * from usuario where email = :email and senha = :senha", nativeQuery = true)
    public Usuario Login(String email, String senha);
    
}
