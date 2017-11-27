package BackUp.SongCA.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity
public class Library {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Set<Tracks> tracks;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Set<Playlist> playlist;;

	public Library(Long id) {
		super();
		this.id = id;
	}
	
	public Library() {
		
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Tracks> tracks) {
		this.tracks = tracks;
	}

	public Set<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Set<Playlist> playlist) {
		this.playlist = playlist;
	}

	
	 public void addTrack(Tracks t){
	    	tracks.add(t);
	 }
	    
	
}
