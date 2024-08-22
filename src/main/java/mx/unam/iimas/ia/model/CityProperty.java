package mx.unam.iimas.ia.model;

public enum CityProperty {

    ARAD(366),
    BUCHAREST(0),
    CRAIOVA(160),
    DOBRETA(242),
    EFORIE(161),
    FAGARAS(178),
    GIURGIU(77),
    HIRSOVA(151),
    IASI(226),
    LUGOJ(244),
    MEHADIA(241),
    NEAMT(234),
    ORADEA(380),
    PITESTI(98),
    RIMNICU_VILCEA(193),
    SIBIU(253),
    TIMISOARA(329),
    URZICENI(80),
    VASLUI(199),
    ZERIND(374);

    private int heuristic;

    CityProperty(int heuristic){
        this.heuristic = heuristic;
    }

    public int getHeuristic() {
        return heuristic;
    }


}
