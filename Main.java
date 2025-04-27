public class Main {
    public static void main(String[] args){
        Season season=new Season();
        season.addEpisode(new Episode("A usual day",12));
        season.addEpisode(new Episode("Morning", 1));
        season.addEpisode(new Episode("evening",2));
        season.addEpisode(new Episode("midnight",3));
        System.out.println(season.getSize());

        System.out.println(season.getElementByIndex(1));
        System.out.println(season.getElementByIndex(1).getTitle());
        System.out.println();
        EpisodeIterator normal=new SeasonIterator(season);
        while(normal.hasNext()){
            System.out.println(normal.next());
        }
        System.out.println();

        EpisodeIterator reverse=new ReverseSeasonIterator(season);
        while(reverse.hasNext()){
            System.out.println(reverse.next());
        }
        System.out.println();

        for(Episode e:season){
            System.out.println(e.getTitle());
        }
        System.out.println();

        EpisodeIterator episodeIterator=new ShuffleSeasonIterator(season);
        while(episodeIterator.hasNext()){
            System.out.println(episodeIterator.next().getRuntimeSec());
        }
    }
}
