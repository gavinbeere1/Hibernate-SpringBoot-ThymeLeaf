package BackUp.SongCA.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Tracks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String artist;
	private String album;
	private String genre;
	private int totalTime;
	private int trackCount;
	
	
	public Tracks() {
	
	}


	public Tracks(Long id, String name, String artist, String album,
			String genre, int totalTime, int trackCount) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.totalTime = totalTime;
		this.trackCount = trackCount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}


	public int getTrackCount() {
		return trackCount;
	}


	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}



	
	
	
	

}
