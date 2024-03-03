package com.greglixandrao.screenmatchspring.main;

import com.greglixandrao.screenmatchspring.model.DataEpisode;
import com.greglixandrao.screenmatchspring.model.DataSeason;
import com.greglixandrao.screenmatchspring.model.DataSeries;
import com.greglixandrao.screenmatchspring.model.Episode;
import com.greglixandrao.screenmatchspring.service.APIConsumption;
import com.greglixandrao.screenmatchspring.service.DataConversion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final APIConsumption apiConsumption = new APIConsumption();

    private final DataConversion conversion = new DataConversion();
    private final String ADDRESS = "https://www.omdbapi.com/";
    private final String API_KEY = "?apikey=" + System.getenv("API_KEY");

    public void menu() {
        String url = ADDRESS + API_KEY + "&t=";

        System.out.println("Digite o nome da Série que deseja informações:");
        var seriesName = scanner.nextLine();
        var json = apiConsumption.getData(url + seriesName.replace(" ", "+"));

        DataSeries dataSeries = conversion.getData(json, DataSeries.class);

        System.out.println(dataSeries);

        List<DataSeason> seasons = new ArrayList<>();
        for (int i = 1; i <= dataSeries.totalTemporada(); i++) {
            json = apiConsumption.getData(url + seriesName.replace(" ", "+") + "&season=" + i);
            DataSeason dataSeason = conversion.getData(json, DataSeason.class);
            seasons.add(dataSeason);
        }
        seasons.forEach(System.out::println);

//      Método para substituir 2 for() usando Lambda
        seasons.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));

        List<DataEpisode> dataEpisodes = seasons.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 5 episódios:");
        dataEpisodes.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DataEpisode::rating).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episode> episodes = seasons.stream()
                .flatMap(t -> t.episodes().stream()
                .map(d -> new Episode(t.seasonNumber(), d))
                ).collect(Collectors.toList());

        episodes.forEach(System.out::println);
    }
}
