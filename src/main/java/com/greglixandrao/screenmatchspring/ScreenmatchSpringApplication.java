package com.greglixandrao.screenmatchspring;

import com.greglixandrao.screenmatchspring.model.DataSeries;
import com.greglixandrao.screenmatchspring.service.APIConsumption;
import com.greglixandrao.screenmatchspring.service.DataConversion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchSpringApplication.class, args);
    }

    String url = "https://www.omdbapi.com/?apikey=" +  System.getenv("API_KEY") + "&t=the+office";

    @Override
    public void run(String... args) throws Exception {
        var consumption = new APIConsumption();
        var json = consumption.getData(url);

        System.out.println(json);
        DataConversion conversion = new DataConversion();
        DataSeries dataSeries = conversion.getData(json, DataSeries.class);
        System.out.println(dataSeries);

    }
}
