package com.stats.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CounterMap {
	private Map<Integer, Integer> sequenceOfOutcomes = new ConcurrentHashMap<Integer, Integer>();
	private Map<Integer, String> outcomes = new ConcurrentHashMap<Integer, String>();
	
	public enum Status {
		WIN, LOSE
	}
	
	public void populateDefaultMap()
	{
		sequenceOfOutcomes.put(0, 0);
		sequenceOfOutcomes.put(1, 0);
		sequenceOfOutcomes.put(2, 0);
		sequenceOfOutcomes.put(3, 0);
		sequenceOfOutcomes.put(4, 0);
	}
	public void populateDefaultOutcome()
	{
		outcomes.put(0, "");
		outcomes.put(1, "");
		outcomes.put(2, "");
		outcomes.put(3, "");
		outcomes.put(4, "");
	}
	public void update(int reelIndex, Status curStatus)
	{
		switch(reelIndex)
		{
			case 0:
				if (addOrNot(curStatus))
					sequenceOfOutcomes.put(0, sequenceOfOutcomes.get(0)+1);
				break;
			case 1:
				if (addOrNot(curStatus))
					sequenceOfOutcomes.put(1, sequenceOfOutcomes.get(1)+1);
				break;
			case 2:
				if (addOrNot(curStatus))
					sequenceOfOutcomes.put(2, sequenceOfOutcomes.get(2)+1);
				break;
			case 3:
				if (addOrNot(curStatus))
					sequenceOfOutcomes.put(3, sequenceOfOutcomes.get(3)+1);
				break;
			case 4:
				if (addOrNot(curStatus))
					sequenceOfOutcomes.put(4, sequenceOfOutcomes.get(4)+1);
				break;				
		}
	}
	
	private boolean addOrNot(Status st){
		boolean result = false;
		switch(st)
		{
			case WIN:
				result = false;
				break;
			case LOSE:				
				result = true;
				break;						
		}
		return result;
	}
	
	public void addOutcome(Integer index, Status st){
		String old = null;
		switch(st)
		{
			case WIN:
				old = outcomes.get(index);
				outcomes.put(index,old+"W");
				break;
			case LOSE:				
				old = outcomes.get(index);
				outcomes.put(index,old+"L");
				break;						
		}
		
	}

}
