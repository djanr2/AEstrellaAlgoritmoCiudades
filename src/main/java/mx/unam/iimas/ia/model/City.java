package mx.unam.iimas.ia.model;


import java.util.HashMap;

import java.util.Map;

public class City {
    private int id;
    private Map<City, Integer> frontier;
    private CityProperty property;
    private Map<City, City> explored;

    public City(CityProperty property){
        this.property = property;
        frontier = new HashMap<>();
        explored = new HashMap<>();
    }

    public void addBorderCity(City city, Integer weight){
        frontier.put(city,weight);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<City, Integer> getFrontier() {
        return frontier;
    }

    public int getHeuristic() {
        return this.property.getHeuristic();
    }

    public String getName(){
        return this.property.name();
    }

    public CityProperty getProperty() {
        return property;
    }
    public int getOptimizationFunction(int weight){
        return weight+this.getHeuristic();
    }

    public Map<City, City> getExplored() {
        return explored;
    }
    public void setExplored(City explored) {
        this.explored.put(explored, explored);
    }

}
