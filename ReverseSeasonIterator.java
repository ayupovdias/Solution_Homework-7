public class ReverseSeasonIterator implements EpisodeIterator{
   private Season season;
   private int index;
   public ReverseSeasonIterator(Season season){
       this.season=season;
       this.index=season.getSize()-1;
   }
   public boolean hasNext(){
       return index>-1;
   }
   public Episode next(){
       return season.getElementById(index--);
   }
}
