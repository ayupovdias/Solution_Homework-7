import java.util.List;
import java.util.ArrayList;
public class Series {
    List<Season> seasons=new ArrayList<>();
    void addSeason(Season s){
        seasons.add(s);
    }
    public int getSize(){
      return seasons.size();
    }
}
