package org.serratec.Animes.repository;

import java.util.List;

import org.serratec.Animes.model.Animes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimesRepository extends JpaRepository<Animes, Long> {
	List<Animes> findByNomeIgnoreCase(String nome);

	List<Animes> findByEpisodios(int episodios);
}
