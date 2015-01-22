package com.docrank.keyphrase;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sharethis.textrank.TextRank;

public class KeyphraseExtractor {
	
	List<String> keyPhraseList;

	public List<String> getKeyphrases(String text)
	{
		String keyPhrases=null;
		
		
		try{
		
		keyPhrases=TextRank.getKeys(text);
		
		
		}catch(Exception e){System.out.println("Problem In KeyPhrase Extraction"+e);}
	
		
		StringTokenizer st=new StringTokenizer(keyPhrases,":");
		
		keyPhraseList=new ArrayList<String>();
		
		while(st.hasMoreTokens())
		{
			keyPhraseList.add(st.nextToken());
		}
		
		
		
		
		
		
		return keyPhraseList;
			
	}
	
	
	public static void main(String...args)
	{
	   String text="Compatibility of systems of linear constraints over the set of natural numbers. Criteria of compatibility of a system of linear Diophantine equations, strict inequations, and nonstrict inequations are considered. Upper bounds for components of a minimal set of solutions and algorithms of construction of minimal generating sets of solutions for all types of systems are given. These criteria and the corresponding algorithms for constructing a minimal supporting set of solutions can be used in solving all the considered types systems and systems of mixed types.";
    	KeyphraseExtractor kp=new KeyphraseExtractor();
    	
    	
    	List<String> kpa=kp.getKeyphrases(text);
    	
    	for(String temp:kpa)
    		System.out.println(temp);
    	
 	   
	   
	}
}
