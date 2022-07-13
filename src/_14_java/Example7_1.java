package _14_java;

import java.util.ArrayList;
import java.util.List;

public class Example7_1 {
    static class Country {
        String continent;
        int population;

        public Country(String continent, int population) {
            this.continent = continent;
            this.population = population;
        }

        public String getContinent() {
            return continent;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static int getPopulation(List<Country> countries, String continent) {
        /*return countries.stream().filter(country -> {
            return country.getContinent().equals(continent);
        }).map(c -> c.getPopulation()).reduce(0, (a, b) -> a + b);*/
        return countries.stream().map(country -> country.getContinent().equals(continent) ? country.getPopulation() : 0)
                .reduce(0, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        Country country;
        country = new Country("North America", 3000000);
        countries.add(country);
        country = new Country("South America", 1000000);
        countries.add(country);
        int population = getPopulation(countries, "South America");
        System.out.println(population);
    }
}
