package org.generation.educAcao.repository;

import java.util.List;

import org.generation.educAcao.model.ComentarioPostagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentarioPostagemRepository extends JpaRepository<ComentarioPostagem, Long> {	
	public List<ComentarioPostagem> findAllByComentarioContainingIgnoreCase (String comentario); 
}

