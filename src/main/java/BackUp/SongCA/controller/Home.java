package BackUp.SongCA.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.sound.midi.Track;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import BackUp.SongCA.model.Library;
import BackUp.SongCA.model.Playlist;
import BackUp.SongCA.model.Tracks;
import BackUp.SongCA.model.User;
import BackUp.SongCA.repository.LibraryRepository;
import BackUp.SongCA.repository.PlaylistRepository;
import BackUp.SongCA.repository.TracksRepository;
import BackUp.SongCA.repository.UserRepository;



@Controller
public class Home {
	
	  @Autowired
	    UserRepository userRepository;
	  
	  @Autowired
		 TracksRepository tracksRepository;
	  
	  @Autowired
		PlaylistRepository playlistRepository;
	  
	  @Autowired
		LibraryRepository libraryRepository;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String index(User user) {
		return "index";
	}

	@RequestMapping(value = "/parsetracks", method = RequestMethod.POST)
	public String addNewTrack(@Valid User user, Library library, Track track, Model model) throws ParserConfigurationException, SAXException, IOException {
		
	

	    	 
//	    club.setClubName(clubDetails.getClubName());
//        club.setClubAddress(clubDetails.getClubAddress());
//        club.setLevel(clubDetails.getLevel());
//
//        Club updatedClub = clubRepository.save(club);
//        return ResponseEntity.ok(updatedClub);
	    	 
//	        try {
				Library lib = new Library();
				
				user.setLibrary(lib);
				//(update user in the db
				Tracks addtracks = new <Set>Tracks();
				
				
		
	            File inputFile = new File("ITunes Music Library2.xml");
//	            File inputFile = new File("new.xml");
	            DocumentBuilderFactory dbFactory
	                    = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(inputFile);
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :"
	                    + doc.getDocumentElement().getNodeName());
	            NodeList nList = doc.getElementsByTagName("dict");
	            System.out.println("----------------------------");
	            
	            
	           
	            
	            
	            for(int i=0;i<nList.getLength();i++){
	            	 Tracks test = new  Tracks();
	            	
	            	Node b =nList.item(i);
	                System.out.println("\nCurrent Element : " + b.getNodeName());
	                if (b.getNodeType() == Node.ELEMENT_NODE) {
	                    Element eElement = (Element) b;
//			               System.out.println("Dict : "
//			                       + eElement
//			                       .getElementsByTagName("dict")
//			                       .item(0)
//			                       .getTextContent());

	                    //Gets the track ID
	                    System.out.println("Key Track ID: "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(0)
	                            .getTextContent());
	                    System.out.println("Track ID : "
	                            + eElement
	                            .getElementsByTagName("integer")
	                            .item(0)
	                            .getTextContent());

	                    //Gets song name
	                    System.out.println("Key name : "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(1)
	                            .getTextContent());
	                    System.out.println("Song name : "
	                            + eElement
	                            .getElementsByTagName("string")
	                            .item(0)
	                            .getTextContent());

	                    //Gets artist name
	                    System.out.println("Key artist : "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(2)
	                            .getTextContent());
	                    System.out.println("String artist : "
	                            + eElement
	                            .getElementsByTagName("string")
	                            .item(1)
	                            .getTextContent());

	                    //Gets album artist
	                    System.out.println("Album artist : "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(3)
	                            .getTextContent());
	                    System.out.println("String name : "
	                            + eElement
	                            .getElementsByTagName("string")
	                            .item(2)
	                            .getTextContent());

	                    //Gets album name
	                    System.out.println("Key album name : "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(4)
	                            .getTextContent());
	                    System.out.println("String name : "
	                            + eElement
	                            .getElementsByTagName("string")
	                            .item(3)
	                            .getTextContent());

	                    //Gets persistent id
	                    System.out.println("Key persistent: "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(4)
	                            .getTextContent());
	                    System.out.println("String name : "
	                            + eElement
	                            .getElementsByTagName("string")
	                            .item(3)
	                            .getTextContent());


//	                    //Gets array
	                    System.out.println("Key Playlist : "
	                            + eElement
	                            .getElementsByTagName("key")
	                            .item(5)
	                            .getTextContent());
	                   /* System.out.println("dict name : "
	                            + eElement
	                            .getElementsByTagName("dict")
	                            .item(0)
	                            .getTextContent());*/
	                    
	                    
	                    test.setName(eElement
	                            .getElementsByTagName("string")
	                            .item(0)
	                            .getTextContent());
	                    test.setArtist(eElement
	                            .getElementsByTagName("string")
	                            .item(2)
	                            .getTextContent());
	                    test.setAlbum(eElement
	                            .getElementsByTagName("string")
	                            .item(3)
	                            .getTextContent());
	                    test.setGenre("Bass");
	                    test.setTotalTime(55);
	                    test.setTrackCount(44);
	                    
	                   
	                    lib.addTrack(test);
	                   
	                    tracksRepository.save(test);
	                }
	            }
	            
	            libraryRepository.save(lib);

//	        } catch (ParserConfigurationException e) {
//	            e.printStackTrace();
//	        } catch (SAXException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
			return "uploadSuccess";
	    
		
		

		//this is code for a new user
//		user.setOnline(true);
//		userRepository.save(user);
//		
//		model.addAttribute("username", user.getUsername());
//		model.addAttribute("password", user.getPassword());
//	
//		return "result";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addNewPost(@Valid User user, Model model) {
		
		//error handling code goes here?
		
		
		

		//this is code for a new user
		user.setOnline(true);
		userRepository.save(user);
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
	
		return "result";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginUser(@Valid User user, Model model) {
		
		User exists = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		
		if ((exists.getUsername().equals(user.getUsername())) && (exists.getPassword().equals(user.getPassword())))
				{
			exists.setOnline(false);
			model.addAttribute("username", user.getUsername());
			model.addAttribute("password", user.getPassword());
			
			
				}
		
		else if((!exists.getUsername().equals(user.getUsername())) && (!exists.getPassword().equals(user.getPassword()))){
			
		return "redirect:/index";
		
		}
		
		return "result";
		
	}
	
	  @RequestMapping(value = "/fileUpload", method = RequestMethod.POST) 
	    public String importParse(@RequestParam("myFile") MultipartFile myFile) { 
	        
		  	//call method to parse xml file here (myFile)
//		  parseXmlfile(myFile);
		  
		  	
	         return "uploadSuccess"; 
	    } 
	  
	  @RequestMapping(value = "/parseplaylists", method = RequestMethod.POST)
		public String addNewPlaylist(@Valid Playlist playlist, Model model) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        ArrayList<Playlist> playlists = new ArrayList<>();
//        Playlist playlist;
        ArrayList<Integer> playlistTracks;
        File fXmlFile = new File("ITunes Music Library2.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
//        try {
        
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            String nameExpression = "//dict/key[. = 'Playlists']/following-sibling::*[1]/child::*";
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.compile(nameExpression).evaluate(doc, XPathConstants.NODESET);
        
            
            System.out.println("node list count is:" + nodeList.getLength());
            //System.out.println("playlist node list count is: " + playListNodeList.getLength());
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                playlistTracks = new ArrayList<>();
                playlist = new Playlist();
                Node playlistNode = nodeList.item(i);
                System.out.println(playlistNode.getNodeName());
                
                
                if (playlistNode.getNodeName().equals("dict")) {
                    System.out.println("Found dict---");
                    NodeList playlistsNode = playlistNode.getChildNodes();
                    for (int a = 0; a < playlistsNode.getLength(); a++) {
                        Node another = playlistsNode.item(a);
                        //System.out.println(another.getTextContent()+" here--");
                        if (another.getTextContent().equals("Name")) {
                            //System.out.println("Name: " + another.getNextSibling().getTextContent());
                            playlist.setName(another.getNextSibling().getTextContent());
                        } else if (another.getTextContent().equals("Playlist ID")) {
                            //System.out.println("Playlist ID: " + another.getNextSibling().getTextContent());
                            playlist.setId((long) Integer.parseInt(another.getNextSibling().getTextContent()));
                        } else if (another.getTextContent().equals("Playlist Persistent ID")) {
                            //System.out.println("Persistent ID: " + another.getNextSibling().getTextContent());
                            playlist.setPlaylistPId(another.getNextSibling().getTextContent());
                        } else if (another.getTextContent().equals("Playlist Items")) {
                            //System.out.println("Playlist Items: ");
                            NodeList items = another.getNextSibling().getNextSibling().getChildNodes();
                            //System.out.println(items.getLength()+"length");
                            for (int x = 0; x < items.getLength(); x++) {
                                Node xitem = items.item(x);
                                NodeList mostItems = xitem.getChildNodes();
                                for (int h = 0; h < mostItems.getLength(); h++) {
                                    Node something = mostItems.item(h);
                                    if (something.getTextContent().equals("Track ID")) {
                                        //System.out.println("Track id " + something.getNextSibling().getTextContent());
                                        playlistTracks.add(Integer.parseInt(something.getNextSibling().getTextContent()));
                                    }
                                }
                            }playlists.add(playlist);
                            playlistRepository.save(playlist);
                            
                        }
                    }
                }
            }
            System.out.println("Count is: " + playlists.size());
            for (Playlist p : playlists) {
                System.out.println(p.getName());
                System.out.println(p.getPlaylistPId());
                System.out.println("");
            }
//        } catch (ParserConfigurationException | IOException e) {
//            e.printStackTrace();
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
        return "uploadSuccess";
		  
	  }


}
