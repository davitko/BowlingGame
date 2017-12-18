package netgloo.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;

/**
 * 
 * @author Miloš Davitković
 *
 */
@Entity
@Table(name = "player")
public class Player implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 4345629985870301199L;

    private static final Logger LOG = Logger.getLogger(Player.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String dateOfPlaying;
	Integer ordinalNumber;
	String name;
    @OneToMany(targetEntity=Frame.class)
    @JsonIgnore
	List<Frame> frames;
    @OneToOne
    Frame extraFrame;
	Integer score;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
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

	public Integer getOrdinalNumber() {
		return ordinalNumber;
	}

	public void setOrdinalNumber(Integer ordinalNumber) {
		this.ordinalNumber = ordinalNumber;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
        if(frames.size() > 11)
            throw new IllegalArgumentException("Maximal number of frames is 10 plus Bonus Frame for a Strike of Spare in Last Frame");
        else
		    this.frames = frames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDateOfPlaying() {
		return dateOfPlaying;
	}

	public void setDateOfPlaying(String dateOfPlaying) {
		this.dateOfPlaying = dateOfPlaying;
	}

    public Frame getExtraFrame() {
        return extraFrame;
    }

    public void setExtraFrame(Frame extraFrame) {
        this.extraFrame = extraFrame;
    }
}
