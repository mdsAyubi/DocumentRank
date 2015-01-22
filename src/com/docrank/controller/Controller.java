package com.docrank.controller;

import java.util.ArrayList;
import java.util.List;

import com.docrank.gcs.GoogleCustomSearcher;
import com.docrank.keyphrase.KeyphraseExtractor;
import com.docrank.preprocessor.TextPreprocessor;
import com.docrank.webtextextractor.WebTextController;

public class Controller {

String inputDocument;
int documentRank;


public Controller(String inputDocument)
{
	this.inputDocument=inputDocument;
	
}


public int getFinalDocumentRank()
{
	//////////////////////////////////////////
	List<String> keyPhrases=null;
	KeyphraseExtractor kpe=new KeyphraseExtractor();
	keyPhrases=kpe.getKeyphrases(inputDocument);
	
	//////////////////////////////////////////
	List<String> setOfUrls=null;
	GoogleCustomSearcher gcs=new GoogleCustomSearcher(keyPhrases);
	setOfUrls=gcs.getSetOfUrls();
	
	//////////////////////////////////////////
	List<String> extractedText=null;
	WebTextController wbt=new WebTextController(setOfUrls);
	extractedText=wbt.getExtractedTexts();
	
	
	TextPreprocessor tp=new TextPreprocessor();
	List<String> cleanedText=new ArrayList<String>();
	for(String text:extractedText)
	{
		cleanedText.add(tp.getPreprocessedText(text));
	}
	
	////////////////////////////////////////
	
	

	return documentRank;
}


}
