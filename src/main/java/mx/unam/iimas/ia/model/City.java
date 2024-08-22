package mx.unam.iimas.ia.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    private int id;
    private City parent;
    private Map<City, Integer> frontier;
    private CityProperty property;

    public City(CityProperty property){
        this.property = property;
        frontier = new HashMap<>();
    }

    public boolean addBorderCity(City city, Integer weight){
        //TODO ADD A WAY TO CHECK IF A CITY ALREADY WAS INSERTED
        if (frontier.get(city)!=null){
            return false;
        }

        frontier.put(city,weight);
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getParent() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
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

    public int getOptimizationFunction(int weight){
        return weight+this.getHeuristic();
    }
}
