package org.serratec.Animes.dto;

import java.time.LocalDate;

import org.serratec.Animes.model.Animes;

public record AnimesDto(Long id, String nome, int episodios, LocalDate datadelancamento) {

	public Animes toEntity() {
		Animes animes = new Animes();
		animes.setId(this.id);
		animes.setNome(this.nome);
		animes.setEpisodios(this.episodios);
		animes.setDatadelancamento(this.datadelancamento);
		return animes;
	}

	public static AnimesDto toDto(Animes animes) {
		return new AnimesDto(animes.getId(), animes.getNome(), animes.getEpisodios(), animes.getDatadelancamento());
	}

}
