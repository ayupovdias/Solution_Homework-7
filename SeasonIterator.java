import java.util.Iterator;
public class SeasonIterator implements EpisodeIterator, Iterator<Episode>{
    private Season season;
    private int index;
    public SeasonIterator(Season season){
        this.season=season;

    }
    public boolean hasNext(){
        return index<season.getSize();
    }
    public Episode next(){
        return season.getElementByIndex(index++);
    }
}