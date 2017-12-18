package netgloo.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 
 * @author Miloš Davitković
 *
 */
@Entity
@Table(name = "frame")
public class Frame implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 4345629985870301199L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	Integer ordinalNumber;
	Integer firstThrow;
	Integer secondThrow;
	Integer frameScore;
	Integer currentPlayerScore;

	public Frame() {
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

	public Integer getFirstThrow() {
	    if(firstThrow != null)
	        return firstThrow;
	    else
	        return 0;
	}

	public void setFirstThrow(Integer firstThrow) {
		this.firstThrow = firstThrow;
	}

	public Integer getSecondThrow() {
		if(secondThrow != null)
	        return secondThrow;
		else
		    return 0;
	}

	public void setSecondThrow(Integer secondThrow) {
		this.secondThrow = secondThrow;
	}

    public Integer getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(Integer frameScore) {
        this.frameScore = frameScore;
    }

    public Integer getCurrentPlayerScore() {
        return currentPlayerScore;
    }

    public void setCurrentPlayerScore(Integer currentPlayerScore) {
        this.currentPlayerScore = currentPlayerScore;
    }
}
