public class SeasonIterator {
    private Season season;
    private int index;
    public SeasonIterator(Season season){
        this.season=season;
    }
    public boolean hasNext(){
        return index>season.getSize();
    }
    public Episode next(){
        return season.getElementById(index++);
    }
}
