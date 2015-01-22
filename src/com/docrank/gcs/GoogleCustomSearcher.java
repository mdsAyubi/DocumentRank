package com.docrank.gcs;

import java.util.ArrayList;
import java.util.List;

public class GoogleCustomSearcher {

	List<String> keyPhraseList;
	List<String> setOfUrls;
	
	
	public GoogleCustomSearcher(List<String> keyPhraseList)
	{
		this.keyPhraseList=keyPhraseList;
		setOfUrls=new ArrayList<String>();
	}
	
	public List<String> getSetOfUrls()
	{
		
		Search searcher=new Search();
		List<String> tempUrls=new ArrayList<String>();
		
try{
		
		
		for(String query:keyPhraseList)
		{
			tempUrls=searcher.getUrls(query, "1");
			//for(String url:tempUrls) setOfUrls.add(url);
				
				setOfUrls.addAll(tempUrls);
				
			tempUrls=searcher.getUrls(query, "2");
			//for(String url:tempUrls) setOfUrls.add(url);
				setOfUrls.addAll(tempUrls);
			
		}
		
		
}catch(Exception e){System.out.println("Problem In Custom Search"+e);}
		
		
		
		return setOfUrls;
	}
	
	
	
	
}
