package org.serratec.Animes.service;

import java.util.List;
import java.util.Optional;

import org.serratec.Animes.dto.AnimesDto;
import org.serratec.Animes.model.Animes;
import org.serratec.Animes.repository.AnimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimesService {

	@Autowired
	private AnimesRepository repositorio;

	public List<AnimesDto> obterTodos() {
		return repositorio.findAll().stream().map(a -> AnimesDto.toDto(a)).toList();
	}

	public Optional<AnimesDto> obterPorId(Long id) {
		if (!repositorio.existsById(id)) {
			return Optional.empty();
		}
		return Optional.of(AnimesDto.toDto(repositorio.findById(id).get()));
	}

	public AnimesDto salvarAnime(AnimesDto dto) {
		Animes animesEntity = repositorio.save(dto.toEntity());
		return AnimesDto.toDto(animesEntity);
		// return PedidoDto.toDto(repositorio.save(dto.toEntity()));

	}

	public boolean apagarAnime(Long id) {
		if (!repositorio.existsById(id)) {
			return false;
		}
		repositorio.deleteById(id);
		return true;
	}

	public Optional<AnimesDto> alterarAnime(Long id, AnimesDto dto) {
		if (!repositorio.existsById(id)) {
			return Optional.empty();
		}
		Animes animesEntity = dto.toEntity();
		animesEntity.setId(id);
		repositorio.save(animesEntity);
		return Optional.of(AnimesDto.toDto(animesEntity));
	}

	public List<AnimesDto> obterPorEpisodio(int episodios) {
		List<Animes> animes = repositorio.findByEpisodios(episodios);
		return animes.stream().map(a -> AnimesDto.toDto(a)).toList();
	}

	public List<AnimesDto> obterPorNome(String nome) {
		List<Animes> animes = repositorio.findByNomeIgnoreCase(nome);
		return animes.stream().map(a -> AnimesDto.toDto(a)).toList();
	}

}
