package netgloo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Miloš Davitković
 *
 */
@Entity
@Table(name = "game")
public class Game implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 4345629985870301199L;

    private static final Logger LOG = Logger.getLogger(Game.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String dateOfGame;
    @OneToMany(targetEntity=Player.class)
    @JsonIgnore
	List<Player> players;


	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addPlayer(Player player) {
        if(players == null)
			players = new ArrayList<>();
        if(players.size() > 6)
            throw new IllegalArgumentException("Maximal number of players is 6");
		players.add(player);
    }


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(String dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        if(players.size() > 6)
            throw new IllegalArgumentException("Maximal number of players is 6");
        else
            this.players = players;
    }
}
