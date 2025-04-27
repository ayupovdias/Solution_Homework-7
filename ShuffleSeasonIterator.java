import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class ShuffleSeasonIterator implements EpisodeIterator{
    List<Episode> episodes=new ArrayList<>();

    private Season season;
    private int index;
    public ShuffleSeasonIterator(Season season){
        this.season=season;
        for(int i=0;i<season.getSize();i++){
             episodes.add(season.getElementByIndex(i));
        }
        Collections.shuffle(episodes);

    }
    public boolean hasNext(){
        return index<episodes.size();
    }
    public Episode next(){
        return episodes.get(index++);
    }

}