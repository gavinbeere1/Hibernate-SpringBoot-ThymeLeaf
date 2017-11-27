package BackUp.SongCA.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String playlistPId;
	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Set<Tracks> tracks;
	
	public Playlist()
	{
		
	}

	public Playlist(Long id, String playlistPId) {
		super();
		this.id = id;
		this.playlistPId = playlistPId;
		this.name = name;
//		this.track = track;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaylistPId() {
		return playlistPId;
	}

	public void setPlaylistPId(String playlistPId) {
		this.playlistPId = playlistPId;
	}

	public Set<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Tracks> tracks) {
		this.tracks = tracks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	

}
