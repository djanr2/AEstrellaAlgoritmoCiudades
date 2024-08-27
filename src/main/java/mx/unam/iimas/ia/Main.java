package mx.unam.iimas.ia;

import mx.unam.iimas.ia.model.*;

import java.util.*;

import static mx.unam.iimas.ia.model.CityProperty.*;

public class Main {
    private static City origin;
    private static City destiny;
    private static Map<CityProperty, City> cities; //<-- Cities to visit.
    private static PriorityQueue<Path> paths;
        public static void main(String[] args) {
            paths = new PriorityQueue<>();
            getConfiguredTree(cities, /*Origin*/ ARAD, /*Destiny*/ BUCHAREST);
            Path solution = searchBestPath(origin, null);
            printSolution(solution);
        }
    private static void explore(City exploringCity, Path accumulate){
        //System.out.println("Exploring "+ exploringCity.getName());
        cities.remove(exploringCity.getProperty());
        for (Map.Entry<City, Integer> entry : exploringCity.getFrontier().entrySet()) {
            if(cities.get(entry.getKey().getProperty())!=null){//<-just visit cities unexplored
                City borderCity = (City)entry.getKey();
                Path p = new Path(exploringCity, cities.get(borderCity.getProperty()),((accumulate!=null)?accumulate.getCost():0)+ getCost(borderCity, exploringCity), accumulate);
                paths.add(p);
                p.setParentPath(accumulate);
            }
        }
    }
    private static Path searchBestPath(City exploringCity, Path path){
            Path p= null;
            explore(exploringCity, path);
            if(exploringCity.getProperty()==destiny.getProperty()){
                return path;
            }
            //System.out.println(paths);
            while (!paths.isEmpty()) {
               p = paths.poll();
                return searchBestPath(p.getDestiny(), p);
            }
            return null;
    }
    private static int getCost(City borderCityHeuristic, City exploringCity){
        return borderCityHeuristic.getHeuristic()+exploringCity.getFrontier().get(borderCityHeuristic);
        //return exploringCity.getFrontier().get(borderCityHeuristic);
    }
    private static void getConfiguredTree(Map<CityProperty, City> m_cities, CityProperty cp_origin, CityProperty cp_destiny){

        m_cities = new HashMap<>();

        City arad = new City(ARAD);
        City bucharest = new City(BUCHAREST);
        City craiova = new City(CRAIOVA);
        City dobreta = new City(DOBRETA);
        City eforie  = new City(EFORIE);
        City fagaras = new City(FAGARAS);
        City giurgiu = new City(GIURGIU);
        City hirsova = new City(HIRSOVA);
        City iasi    = new City(IASI);
        City lugoj   = new City(LUGOJ);
        City mehadia = new City(MEHADIA);
        City neamt   = new City(NEAMT);
        City oradea  = new City(ORADEA);
        City pitesti = new City(PITESTI);
        City rimnicu_vilcea = new City(RIMNICU_VILCEA);
        City sibiu     = new City(SIBIU);
        City timisoara = new City(TIMISOARA);
        City urziceni  = new City(URZICENI);
        City vaslui    = new City(VASLUI);
        City zerind    = new City(ZERIND);

        arad.addBorderCity(timisoara, 118);
        arad.addBorderCity(sibiu,140);
        arad.addBorderCity(zerind,75);
        m_cities.put(ARAD, arad);

        zerind.addBorderCity(arad,75);
        zerind.addBorderCity(oradea,71);
        m_cities.put(ZERIND, zerind);

        timisoara.addBorderCity(arad,118);
        timisoara.addBorderCity(lugoj,111);
        m_cities.put(TIMISOARA, timisoara);

        oradea.addBorderCity(zerind,71);
        oradea.addBorderCity(sibiu,151);
        m_cities.put(ORADEA, oradea);

        sibiu.addBorderCity(oradea,151);
        sibiu.addBorderCity(arad,140);
        sibiu.addBorderCity(fagaras,99);
        sibiu.addBorderCity(rimnicu_vilcea, 80);
        m_cities.put(SIBIU, sibiu);

        lugoj.addBorderCity(timisoara,111);
        lugoj.addBorderCity(mehadia, 70);
        m_cities.put(LUGOJ, lugoj);

        mehadia.addBorderCity(lugoj,70);
        mehadia.addBorderCity(dobreta,75);
        m_cities.put(MEHADIA, mehadia);

        dobreta.addBorderCity(mehadia, 75);
        dobreta.addBorderCity(craiova, 120);
        m_cities.put(DOBRETA, dobreta);

        fagaras.addBorderCity(sibiu,99);
        fagaras.addBorderCity(bucharest,211);
        m_cities.put(FAGARAS, fagaras);

        rimnicu_vilcea.addBorderCity(sibiu,80);
        rimnicu_vilcea.addBorderCity(pitesti, 97);
        rimnicu_vilcea.addBorderCity(craiova,146);
        m_cities.put(RIMNICU_VILCEA, rimnicu_vilcea);

        craiova.addBorderCity(rimnicu_vilcea, 146);
        craiova.addBorderCity(pitesti,138);
        craiova.addBorderCity(dobreta,120);
        m_cities.put(CRAIOVA, craiova);

        pitesti.addBorderCity(rimnicu_vilcea,97);
        pitesti.addBorderCity(craiova,138);
        pitesti.addBorderCity(bucharest, 101);
        m_cities.put(PITESTI, pitesti);

        bucharest.addBorderCity(fagaras,211);
        bucharest.addBorderCity(pitesti,101);
        bucharest.addBorderCity(giurgiu,90);
        bucharest.addBorderCity(urziceni, 85);
        m_cities.put(BUCHAREST, bucharest);

        giurgiu.addBorderCity(bucharest, 90);
        m_cities.put(GIURGIU, giurgiu);

        urziceni.addBorderCity(bucharest, 85);
        urziceni.addBorderCity(hirsova, 98);
        urziceni.addBorderCity(vaslui,142);
        m_cities.put(URZICENI, urziceni);

        hirsova.addBorderCity(urziceni,98);
        hirsova.addBorderCity(eforie,86);
        m_cities.put(HIRSOVA, hirsova);

        eforie.addBorderCity(hirsova,86);
        m_cities.put(EFORIE, eforie);

        vaslui.addBorderCity(urziceni, 142);
        vaslui.addBorderCity(iasi,92);
        m_cities.put(VASLUI, vaslui);

        iasi.addBorderCity(vaslui,92);
        iasi.addBorderCity(neamt,87);
        m_cities.put(IASI, iasi);

        neamt.addBorderCity(iasi,87);
        m_cities.put(NEAMT, neamt);

        cities = m_cities;
        origin = cities.get(cp_origin);
        destiny = cities.get(cp_destiny);
    }
    private static void printSolution(Path p){
            List<Path> s = new ArrayList<>();
            while (p!=null){
                s.add(p);
                p=p.getParentPath();
            }
            Collections.reverse(s);
        System.out.println(s);
    }
}
