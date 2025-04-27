import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
public class Season implements Iterable<Episode>{
    List<Episode> episodes=new LinkedList<>();

    void addEpisode(Episode e){
        episodes.add(e);
    }
    Episode getElementByIndex(int index){
        return episodes.get(index);
    }
    public int getSize(){
        return episodes.size();
    }

    public Iterator<Episode> iterator(){
        return new SeasonIterator(this);
    }

}