
public class Launch {

	public static void main(String[] args) {
		//FirstRatings fr = new FirstRatings();
		//fr.testLoadMovies();
		//fr.testLoadRaters();
		//MovieRunnerAverage mra = new MovieRunnerAverage();
		//mra.printAverageRatings();
		//mra.getAverageRatingOneMovie();
		MovieRunnerWithFilters mrwf = new MovieRunnerWithFilters();
		//mrwf.printAverageRatings();
		//mrwf.printAverageRatingsByYear();
		//mrwf.printAverageRatingsByGenre();
		//mrwf.printAverageRatingsByMinutes();
		//mrwf.printAverageRatingsByDirectors();
		//mrwf.printAverageRatingsByYearAfterAndGenre();
		//mrwf.printAverageRatingsByDirectorsAndMinutes ();
		MovieRunnerSimilarRatings mrsr = new MovieRunnerSimilarRatings();
		//mrsr.printAverageRatings();
		//mrsr.printAverageRatingsByYearAfterAndGenre();
		//mrsr.printSimilarRatings();
		//mrsr.printSimilarRatingsByGenre();
		//mrsr.printSimilarRatingsByDirector();
		//mrsr.printSimilarRatingsByGenreAndMinutes();
		mrsr.printSimilarRatingsByYearAfterAndMinutes();
		
		

	}

}
