import java.util.List;
import java.util.LinkedList;
public class Season{
    List<Episode> episodes=new LinkedList<>();

    void addEpisode(Episode e){
        episodes.add(e);
    }
    Episode getElementById(int index){
        return episodes.get(index);
    }
    public int getSize(){
        return episodes.size();
    }

}
