import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class Series {
    List<Season> seasons=new ArrayList<>();
    void addSeason(Season s){
        seasons.add(s);
    }
    public int getSize(){
        return seasons.size();
    }
    public Season getSeasonByIndex(int index){
        return seasons.get(index);
    }
}