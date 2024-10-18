package org.serratec.Animes.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.Animes.dto.AnimesDto;
import org.serratec.Animes.service.AnimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animes")
public class AnimesController {
	@Autowired
	private AnimesService servico;

	@GetMapping
	public List<AnimesDto> obterTodos() {
		return servico.obterTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AnimesDto> obterPorId(@PathVariable Long id) {
		Optional<AnimesDto> dto = servico.obterPorId(id);
		if (!dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}

	@GetMapping("/nome/{nome}")
	public List<AnimesDto> obterPorNome(@PathVariable String nome) {
		return servico.obterPorNome(nome);
	}

	@GetMapping("/episodios/{episodios}")
	public List<AnimesDto> obterPorEpisodio(@PathVariable int episodios) {
		return servico.obterPorEpisodio(episodios);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AnimesDto adicionarAnime(@RequestBody AnimesDto dto) {
		return servico.salvarAnime(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AnimesDto> alterarAnime(@PathVariable Long id, @RequestBody AnimesDto dto) {
		Optional<AnimesDto> animeAlterado = servico.alterarAnime(id, dto);

		if (!animeAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(animeAlterado.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaAnime(@PathVariable Long id) {
		if (!servico.apagarAnime(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
