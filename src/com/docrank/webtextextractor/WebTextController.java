package com.docrank.webtextextractor;

import java.util.ArrayList;
import java.util.List;

public class WebTextController {

List<String> setOfUrls;
List<String> extractedTexts;

public WebTextController(List<String> setOfUrls)
{
	this.setOfUrls=setOfUrls;
	extractedTexts=new ArrayList<String>();
}


public List<String> getExtractedTexts()
{
	
	WebPageTextExtractor web=new WebPageTextExtractor();
	
	for(String url:setOfUrls)
	{
		System.out.println("URL"+url);
		extractedTexts.add(web.extractText(url));
	}
	
	
	return extractedTexts;
}




}
