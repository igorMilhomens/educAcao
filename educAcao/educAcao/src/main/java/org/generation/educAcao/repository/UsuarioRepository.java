package org.generation.educAcao.repository;

import java.util.List;

import org.generation.educAcao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	public List<Usuario> findAllByEmailContainingIgnoreCase( String email);
}
