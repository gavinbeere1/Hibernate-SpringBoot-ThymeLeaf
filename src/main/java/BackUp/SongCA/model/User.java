package BackUp.SongCA.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	private String username;
	private String password;
	private boolean online;
	
	@OneToOne
	private Library library;
	
	
	public User() {
		
	}

	


	public User(Long id, String username, String password, boolean online, Library library
			) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.online = online;
		this.library = library;
		
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}




	public Library getLibrary() {
		return library;
	}




	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
	
	
	
	
	
	

}
