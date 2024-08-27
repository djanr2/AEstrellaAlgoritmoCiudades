package mx.unam.iimas.ia.model;

public class Path implements Comparable<Path>{

    private City parent;
    private City destiny;
    private int cost;

    private Path parentPath;

    public Path(City parent, City destiny, int cost, Path parentPath){
        this.parent = parent;
        this.destiny = destiny;
        this.cost = cost;
        this.parentPath = parentPath;
    }

    public City getParent() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    public City getDestiny() {
        return destiny;
    }

    public void setDestiny(City destiny) {
        this.destiny = destiny;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int addCost(int cost) {
        return this.cost += cost;
    }

    public Path getParentPath() {
        return parentPath;
    }

    public void setParentPath(Path parentPath) {
        this.parentPath = parentPath;
    }

    @Override
    public String toString(){
        return "{"+parent.getName()+"->"+cost+"->"+destiny.getName()+"}";
    }

    @Override
    public int compareTo(Path o) {
        return o.cost < this.cost ? 1 : -1;
    }

}
