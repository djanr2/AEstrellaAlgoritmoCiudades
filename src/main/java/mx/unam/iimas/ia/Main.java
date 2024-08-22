package mx.unam.iimas.ia;


import mx.unam.iimas.ia.model.*;

import java.util.Map;

import static mx.unam.iimas.ia.model.CityProperty.RIMNICU_VILCEA;

public class Main {

    private static City origin;
    private static City destiny;

    public static void main(String[] args) {

        getConfigureTree();

        for (Map.Entry<City, Integer> set :
                destiny.getFrontier().entrySet()) {
            System.out.println(set.getKey().getName()+ " = " +set.getValue());
        }

    }




    private static void getConfigureTree(){

        City arad = new City(CityProperty.ARAD);
        City bucharest = new City(CityProperty.BUCHAREST);
        City craiova = new City(CityProperty.CRAIOVA);
        City dobreta = new City(CityProperty.DOBRETA);
        City eforie  = new City(CityProperty.EFORIE);
        City fagaras = new City(CityProperty.FAGARAS);
        City giurgiu = new City(CityProperty.GIURGIU);
        City hirsova = new City(CityProperty.HIRSOVA);
        City iasi    = new City(CityProperty.IASI);
        City lugoj   = new City(CityProperty.LUGOJ);
        City mehadia = new City(CityProperty.MEHADIA);
        City neamt   = new City(CityProperty.NEAMT);
        City oradea  = new City(CityProperty.ORADEA);
        City pitesti = new City(CityProperty.PITESTI);
        City rimnicu_vilcea = new City(RIMNICU_VILCEA);
        City sibiu     = new City(CityProperty.SIBIU);
        City timisoara = new City(CityProperty.TIMISOARA);
        City urziceni  = new City(CityProperty.URZICENI);
        City vaslui    = new City(CityProperty.VASLUI);
        City zerind    = new City(CityProperty.ZERIND);

        arad.addBorderCity(timisoara, 118);
        arad.addBorderCity(sibiu,140);
        arad.addBorderCity(zerind,75);

        zerind.addBorderCity(arad,75);
        zerind.addBorderCity(oradea,71);

        timisoara.addBorderCity(arad,118);
        timisoara.addBorderCity(lugoj,111);

        oradea.addBorderCity(zerind,71);
        oradea.addBorderCity(sibiu,151);

        sibiu.addBorderCity(oradea,151);
        sibiu.addBorderCity(arad,140);
        sibiu.addBorderCity(fagaras,99);
        sibiu.addBorderCity(rimnicu_vilcea, 80);

        lugoj.addBorderCity(timisoara,111);
        lugoj.addBorderCity(mehadia, 70);

        mehadia.addBorderCity(lugoj,70);
        mehadia.addBorderCity(dobreta,75);

        dobreta.addBorderCity(mehadia, 75);
        dobreta.addBorderCity(craiova, 120);

        fagaras.addBorderCity(sibiu,99);
        fagaras.addBorderCity(bucharest,211);

        rimnicu_vilcea.addBorderCity(sibiu,80);
        rimnicu_vilcea.addBorderCity(pitesti, 97);
        rimnicu_vilcea.addBorderCity(craiova,146);

        craiova.addBorderCity(rimnicu_vilcea, 146);
        craiova.addBorderCity(pitesti,138);
        craiova.addBorderCity(dobreta,120);

        pitesti.addBorderCity(rimnicu_vilcea,97);
        pitesti.addBorderCity(craiova,138);
        pitesti.addBorderCity(bucharest, 101);

        bucharest.addBorderCity(fagaras,211);
        bucharest.addBorderCity(pitesti,101);
        bucharest.addBorderCity(giurgiu,90);
        bucharest.addBorderCity(urziceni, 85);

        giurgiu.addBorderCity(bucharest, 90);

        urziceni.addBorderCity(bucharest, 85);
        urziceni.addBorderCity(hirsova, 98);
        urziceni.addBorderCity(vaslui,142);

        hirsova.addBorderCity(urziceni,98);
        hirsova.addBorderCity(eforie,86);

        eforie.addBorderCity(hirsova,86);

        vaslui.addBorderCity(urziceni, 142);
        vaslui.addBorderCity(iasi,92);

        iasi.addBorderCity(vaslui,92);
        iasi.addBorderCity(neamt,87);

        neamt.addBorderCity(iasi,87);

        origin = arad;
        destiny = bucharest;

    }

}
