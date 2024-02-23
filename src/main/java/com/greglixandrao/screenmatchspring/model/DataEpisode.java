package com.greglixandrao.screenmatchspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(
        @JsonAlias("Title")
        String title,
        @JsonAlias("Episode")
        Integer epsiodeNumber,
        @JsonAlias("imdbRating")
        String rating,
        @JsonAlias("Released")
        String releaseDay) {
}
