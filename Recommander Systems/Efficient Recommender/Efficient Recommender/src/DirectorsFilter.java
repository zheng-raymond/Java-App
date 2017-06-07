
public class DirectorsFilter implements Filter {
	private String myDirector;
	
	public DirectorsFilter(String director){
		myDirector = director;
	}
	
	@Override
	public boolean satisfies(String id) {
		String[] directors = MovieDatabase.getDirector(id).split(",");
		for(String d : directors){
			//really important line here
			d = d.trim();
			if(myDirector.contains(d)){
				return true;
			}
		}
		return false;
	}

}