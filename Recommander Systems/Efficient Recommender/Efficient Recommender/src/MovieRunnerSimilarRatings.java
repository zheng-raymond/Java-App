import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {
	public void printAverageRatings (){
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		FourthRatings fr = new FourthRatings();
		System.out.println(RaterDatabase.getRaters().size() + " raters loaded");
		System.out.println(MovieDatabase.size() + " movies loaded");
		int min = 35;
		ArrayList<Rating> sorted = fr.getAverageRatings(min);
		Collections.sort(sorted);
		for(Rating r: sorted){
			System.out.println(r.getValue() + "   " + MovieDatabase.getTitle(r.getItem ()));
		}
		System.out.println("There are " +  sorted.size() + " movies with at least " + min + " ratings");
	}
	
	public void  printAverageRatingsByYearAfterAndGenre(){
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		
		AllFilters af = new AllFilters();
		String genre = "Drama";
		GenreFilter gf = new GenreFilter(genre);
		int year = 1990;
		YearAfterFilter yaf = new YearAfterFilter(year);
		af.addFilter(gf);
		af.addFilter(yaf);
		
		FourthRatings fr= new FourthRatings();
		ArrayList<Rating> result =fr.getAverageRatingsByFilter(8, af);
		Collections.sort(result);
		System.out.println("found "+ result.size() + " movies that are after year " + year + " and have genre " + genre );
		for(Rating r: result){
			System.out.println(r.getValue() + "  " + MovieDatabase.getYear(r.getItem()) +"  " + MovieDatabase.getTitle(r.getItem()));
			System.out.println("        " + MovieDatabase.getGenres(r.getItem()));
		}
	}
	
	public void printSimilarRatings(){
		FourthRatings fr = new FourthRatings();
		//read data into two database
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		String id = "71";
		int numSimilarRaters = 20;
		int minimalRater = 5;
		ArrayList<Rating> result = fr.getSimilarRatings(id, numSimilarRaters, minimalRater);
		for(Rating r : result){
			System.out.println(r.getItem() + "  "  + MovieDatabase.getTitle(r.getItem()) + "   " + r.getValue());
			//System.out.println(MovieDatabase.getGenres(r.getItem()));
		}
	}
	
	public void printSimilarRatingsByGenre(){
		FourthRatings fr = new FourthRatings();
		//read data into two database
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		String id = "964";
		GenreFilter filter = new GenreFilter("Mystery");
		int numSimilarRaters = 20;
		int minimalRater = 5;
		ArrayList<Rating> result = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRater, filter);
		for(Rating r : result){
			System.out.println(r.getItem() + "  "  + MovieDatabase.getTitle(r.getItem()) + "   " + r.getValue());
			System.out.println(MovieDatabase.getGenres(r.getItem()));
		}

	}
	
	public void printSimilarRatingsByDirector(){
		FourthRatings fr = new FourthRatings();
		//read data into two database
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		String id = "120";
		DirectorsFilter filter = new DirectorsFilter( "Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
		int numSimilarRaters = 10;
		int minimalRater = 2;
		ArrayList<Rating> result = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRater, filter);
		for(Rating r : result){
			System.out.println(r.getItem() + "  "  + MovieDatabase.getTitle(r.getItem()) + "   " + r.getValue());
			System.out.println(MovieDatabase.getDirector(r.getItem()));
		}

	}
	
	//not working ...
	public void printSimilarRatingsByGenreAndMinutes(){
		FourthRatings fr = new FourthRatings();
		//read data into two database
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		String id = "168";
		MinutesFilter ml = new MinutesFilter(80,160);
		String genre  = "Drama";
		GenreFilter fl = new GenreFilter(genre);
		int numSimilarRaters = 10;
		int minimalRater = 3;
		
		AllFilters al = new AllFilters();
		al.addFilter(fl);
		al.addFilter(ml);

		ArrayList<Rating> result = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRater, al);
		for(Rating r : result){
			System.out.println(r.getItem() + "  "  + MovieDatabase.getTitle(r.getItem()) + "   " + r.getValue());
			System.out.println(MovieDatabase.getMinutes(r.getItem()));
		}
	}
	
	public void printSimilarRatingsByYearAfterAndMinutes(){
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize("ratedmoviesfull.csv");
		RaterDatabase.initialize("ratings.csv");
		int year = 1975;
		YearAfterFilter yaf = new YearAfterFilter(year);
		int min = 70;
		int max = 200;
		MinutesFilter mf = new MinutesFilter(min,max);
		AllFilters al = new AllFilters();
		al.addFilter(mf);
		al.addFilter(yaf);
		
		String id = "314";
		int numSimilarRaters = 10;
		int minimalRater = 5;
		ArrayList<Rating> result = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRater, al);
		for(Rating r : result){
			System.out.println(r.getItem() + "  "  + MovieDatabase.getTitle(r.getItem()) + "   " + r.getValue());
			System.out.println(MovieDatabase.getMinutes(r.getItem()));
		}
		
	}
}

