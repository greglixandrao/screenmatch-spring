package com.greglixandrao.screenmatchspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeries(
        @JsonAlias("Title")
        String titulo,

        @JsonAlias("totalSeasons")
        Integer totalTemporada,
        @JsonAlias("imdbRating")
        String avaliacao) {
}
