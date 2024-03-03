package com.greglixandrao.screenmatchspring.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double rating;
    private LocalDate releaseDay;

    public Episode(Integer seasonNumber,DataEpisode dataEpisode ) {
        this.season = seasonNumber;
        this.title = dataEpisode.title();
        this.episodeNumber = dataEpisode.epsiodeNumber();
        try {
            this.rating = Double.valueOf(dataEpisode.rating());
        } catch (NumberFormatException err) {
            this.rating = 0.0;
        }
        try {
            this.releaseDay = LocalDate.parse(dataEpisode.releaseDay());
        } catch (DateTimeParseException err) {
            this.releaseDay = null;
        }
    }

   public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(LocalDate releaseDay) {
        this.releaseDay = releaseDay;
    }

    @Override
    public String toString() {
        return "Temporada = " + season +
                ", Título = " + title + '\'' +
                ", Numero do episódio = " + episodeNumber +
                ", Avaliação = " + rating +
                ", Data de Lançamento = " + releaseDay;
    }
}
