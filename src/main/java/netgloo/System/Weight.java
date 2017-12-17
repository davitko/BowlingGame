package netgloo.System;

import org.springframework.stereotype.Controller;

@Controller
public class Weight {

	public Integer Bulevar = 3;
	public Integer NormalStreet = 1;
	public Integer LinePerDirection = 1;
	public Integer Unpaved = -2;
	public Integer RoughRoad = -1;
	public Integer ExcellentAsphalt = 3;
	public Integer AverageAspaht = 1;
	//	public Integer ResultWeight = ;

	
	
	/**
	 * 
	 * @param streetType - Bulevar or NormalStreet
	 * @param numberOfLines
	 * @param roadQuality - Unpaved or RoughRoad or ExcellentAsphalt
	 */
	public Integer calculateWeitght(String streetType, Integer LinePerDirection, String roadQuality) {
		Integer ResultWeight = 0;
		switch (streetType) {
		case "Bulevar":  ResultWeight += Bulevar;
		break;
		case "NormalStreet": ResultWeight += NormalStreet;
		break;
		default: ResultWeight += NormalStreet;
		break;
		}
		
		ResultWeight += LinePerDirection;
		
		switch (roadQuality) {
		case "Unpaved":  ResultWeight += Unpaved;
		break;
		case "RoughRoad": ResultWeight += RoughRoad;
		break;
		case "ExcellentAsphalt": ResultWeight += ExcellentAsphalt;
		break;
		default: ResultWeight += AverageAspaht;
		break;
		}
		
		return ResultWeight;
	}



	public Weight() {
		super();
		// TODO Auto-generated constructor stub
	}

}
