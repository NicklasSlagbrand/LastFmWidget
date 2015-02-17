package de.umass.lastfm;




import java.util.ArrayList;
import de.umass.lastfm.Artist;


public class Methods {

	


	
	private static ArrayList<Artist> artistNames = new ArrayList<Artist>(); // list over artistNames
	
	public static ArrayList<Track> chart2 = new ArrayList<Track>(); // holds tracks
	
	private static ArrayList<Track> chart3 = new ArrayList<Track>(); // holds tracks
	
	
	private static String key = "c9fe17b0011d8ba602c269c692f3a077";  // API key 
    														
   										
	


	
	
	public static ArrayList <Artist> getTopArtist (String c){  // get the 10 top Artist for a country
		
		artistNames = (ArrayList<Artist>) Geo.getTopArtists(c, key);
           
		ArrayList <Artist> Artists = new ArrayList <Artist>();
		
		Artist one = artistNames.get(0); 
		Artist two = artistNames.get(1);
		Artist tree = artistNames.get(2);
		Artist four = artistNames.get(3);
		Artist five = artistNames.get(4);
		Artist six = artistNames.get(5);
		Artist seven = artistNames.get(6);
		Artist eight = artistNames.get(7);
		Artist nine = artistNames.get(8);
		Artist ten = artistNames.get(9);
		
		Artists.add(one);
		Artists.add(two);
		Artists.add(tree);
		Artists.add(four);
		Artists.add(five);
		Artists.add(six);
		Artists.add(seven);
		Artists.add(eight);
		Artists.add(nine);
		Artists.add(ten);
		
		
			
			
		return Artists;		
		
	}
		
	
	
	
	

	public static ArrayList <Track> getTopArtistAndSongs(String c, int pos) {  // get top 10 songs from a top 10 artist

		artistNames = (ArrayList<Artist>) Geo.getTopArtists(c, key);   

    
		@SuppressWarnings("static-access")
		ArrayList<Track> aTrack = (ArrayList<Track>) artistNames.get(pos).getTopTracks(artistNames.get(pos).getName(), key); 

		Track one = aTrack.get(0);    // get top 5
		Track two = aTrack.get(1);
		Track tree = aTrack.get(2);
		Track four = aTrack.get(3);
		Track five = aTrack.get(4);
		Track six = aTrack.get(5);
		Track seven = aTrack.get(6);
		Track eight = aTrack.get(7);
		Track nine = aTrack.get(8);
		Track ten = aTrack.get(9);

		
		
		ArrayList <Track> top10 = new ArrayList <Track>();  
		
		top10.add(one);
		top10.add(two);    
		top10.add(tree);
		top10.add(four);
		top10.add(five);
		top10.add(six);
		top10.add(seven);
		top10.add(eight);
		top10.add(nine);
		top10.add(ten);
		
		return top10;
	}
	
	public static String [] getGenreTrack (String c){  // get genre for top 10 tracks from a country
		
		ArrayList <Tag> genre = new ArrayList <Tag>();
		String [] genra2 = new String [10];
		ArrayList<Track> chart = (ArrayList<Track>) Geo.getTopTracks(c, key);
		
		try {
			for(int i = 0; i <10; i++){
				
				String artist2 = chart.get(i).getArtist();
				
				
				ArrayList<Tag> chart2 = (ArrayList<Tag>) Artist.getTopTags(artist2, key);
			
				Tag one = chart2.get(0);
				Tag two = chart2.get(1);
				Tag tree = chart2.get(2);
				Tag four = chart2.get(3);
				Tag five = chart2.get(4);
				Tag six = chart2.get(5);
				Tag seven = chart2.get(6);
				Tag eight = chart2.get(7);
				Tag nine = chart2.get(8);
				Tag ten = chart2.get(9);
			
				genre = new ArrayList <Tag>();
				
				genre.add(one);
				genre.add(two);
				genre.add(tree);
				genre.add(four);
				genre.add(five);
				genre.add(six);
				genre.add(seven);
				genre.add(eight);
				genre.add(nine);
				genre.add(ten);
			
				genra2[i]=genre.get(0).getName().toString();
			
			
			}
		} catch (Exception e) {
			System.out.println("något gick fel med att hämta track genre");
			e.printStackTrace();
		}
		return genra2;	
}
	

@SuppressWarnings("static-access")
public static String[] getGenreArtist (String c){ // get genre for top 10 artists
		
		ArrayList <Tag> chart2 = new ArrayList <Tag>();
		
		String [] genra = new String [10];
		
		artistNames = (ArrayList<Artist>) Geo.getTopArtists(c, key);
        
		ArrayList <Artist> Artists = new ArrayList <Artist>();
		
		Artist one = artistNames.get(0); 
		Artist two = artistNames.get(1);
		Artist tree = artistNames.get(2);
		Artist four = artistNames.get(3);
		Artist five = artistNames.get(4);
		Artist six = artistNames.get(5);
		Artist seven = artistNames.get(6);
		Artist eight = artistNames.get(7);
		Artist nine = artistNames.get(8);
		Artist ten = artistNames.get(9);
		
		Artists.add(one);
		Artists.add(two);
		Artists.add(tree);
		Artists.add(four);
		Artists.add(five);
		Artists.add(six);
		Artists.add(seven);
		Artists.add(eight);
		Artists.add(nine);
		Artists.add(ten);
	
		for(int i = 0; i <Artists.size(); i++){
			
			
			
			chart2 = (ArrayList<Tag>) Artists.get(i).getTopTags(Artists.get(i).getName(),key);
		
			
			
	        genra[i] = chart2.get(0).getName().toString(); 
	        
	        
			
			}
		
		
		
		return genra;	
}





public static ArrayList<Track> getTopTracks (String s){ //get top 10 tracks from a country
	
chart2 = (ArrayList<Track>) Geo.getTopTracks(s, key);
	
   

    Track one = chart2.get(0);   
	Track two = chart2.get(1);
	Track tree = chart2.get(2);
	Track four = chart2.get(3);
	Track five = chart2.get(4);
	Track six = chart2.get(5);
	Track seven = chart2.get(6);
	Track eight = chart2.get(7);
	Track nine = chart2.get(8);
	Track ten = chart2.get(9);

	
	
	ArrayList <Track> songs = new ArrayList <Track>();  
	
	songs.add(one);
	songs.add(two);    
	songs.add(tree);
	songs.add(four);
	songs.add(five);
	songs.add(six);
	songs.add(seven);
	songs.add(eight);
	songs.add(nine);
	songs.add(ten);
	
	return songs;
	
	
	
}

public static ArrayList<String> getTopTrackAname (String s){ // get the top 10 tracks artist
	
	chart3 = (ArrayList<Track>) Geo.getTopTracks(s, key);
	//aName = (ArrayList<Artist>) Geo.getTopArtists(c, key);
	
	String art1 = chart3.get(0).getArtist();
	String art2 = chart3.get(1).getArtist();
	String art3 = chart3.get(2).getArtist();
	String art4 = chart3.get(3).getArtist();
	String art5 = chart3.get(4).getArtist();
	String art6 = chart3.get(5).getArtist();
	String art7 = chart3.get(6).getArtist();
	String art8 = chart3.get(7).getArtist();
	String art9 = chart3.get(8).getArtist();
	String art10 = chart3.get(9).getArtist();
	System.out.println(art9);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	ArrayList<String> artister = new ArrayList();
	
	artister.add(art1);
	artister.add(art2);
	artister.add(art3);
	artister.add(art4);
	artister.add(art5);
	artister.add(art6);
	artister.add(art7);
	artister.add(art8);
	artister.add(art9);
	artister.add(art10);
	
	return artister;
	
	
		}


	
}

