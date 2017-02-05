package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//in -> [[2, 1, 1, 2, ...], [...], [...], ...]
//out -> [[2112...], [...], [...], ...]
public class BarsToCodesTranslator {
	public ArrayList<Integer> translate(ArrayList<ArrayList<Integer>> groupedBars) {
		
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < groupedBars.size(); i++) {

			StringBuffer sb = new StringBuffer();

			for (int j = 0; j < groupedBars.get(i).size(); j++) {
				int value = groupedBars.get(i).get(j);
				sb.append(value);
			}

			result.add(Integer.parseInt(sb.toString()));
		}
		
		return result;
	}
	
}
