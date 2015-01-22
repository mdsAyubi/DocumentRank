package com.docrank.gcs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Search {

	List<String> urls;

    String key="AIzaSyBtaHxogAjJxxcpPaAc-DqQ-02RNsjt8Zc";
/*
	public static void main(String[] args) throws Exception 
	{

	    String key="AIzaSyBtaHxogAjJxxcpPaAc-DqQ-02RNsjt8Zc";
	    String qry="Android Operating System";
	    URL url = new URL(
	            "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ qry + "&alt=json");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");
	    BufferedReader br = new BufferedReader(new InputStreamReader(
	            (conn.getInputStream())));

	    String output;
	    StringBuilder result=new StringBuilder();
	    System.out.println("Output from Server .... \n");
	    while ((output = br.readLine()) != null)
	    {
	
	    	result.append(output);

	    	if(output.contains("\"link\": \"")){                
	            String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
	            System.out.println(link);       //Will print the google search links
	        }     
	
	    }
        System.out.println(result.toString());       //Will print the google result
	    
	    conn.disconnect();                              
	}

*/

	public List<String> getUrls(String query,String startIndex)throws Exception
	{
	    //String qry="Android%20Operating%20System";
	    
	    
	    String cleanedQuery=cleanQueryForSearch(query);
	    
	    
	    //URL url = new URL("https://www.googleapis.com/customsearch/v1?key="+key+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ cleanedQuery + "&alt=json");
	    

	    URL url = new URL("https://www.googleapis.com/customsearch/v1?key="+key+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ cleanedQuery +"&start="+startIndex+ "&alt=json");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");
	    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	    String output;
	    StringBuilder result=new StringBuilder();
	    System.out.println("Output from Server .... \n");
	    
	    urls=new ArrayList<String>();
	    while ((output = br.readLine()) != null)
	    {
	
	    	result.append(output);
	
	    	if(output.contains("\"link\": \""))
	    	{                
	            String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
	            //System.out.println(link);       //Will print the google search links
	            urls.add(link);
	    	}     
	
	    }
        System.out.println(result.toString());       //Will print the google result
	    
        
        
	    conn.disconnect();                              
	
	    return urls;
	}

private String cleanQueryForSearch(String query)
{
	String cleanQuery="";
	
	if(!query.contains(" "))
	{
		cleanQuery=query;
		System.out.print("Cleaned Single Keyword Query"+cleanQuery);
	}
	else
	{
		StringTokenizer st=new StringTokenizer(query," ");
		StringBuilder q=new StringBuilder();
		while(true)
		{
			q.append(st.nextToken());
			
			if(st.hasMoreTokens())
			q.append("%20");
			else break;
		}
		cleanQuery=q.toString();
		System.out.print("Cleaned Multi Keyword Query"+cleanQuery);
		
	}
	
	
	
	return cleanQuery;
}
	
	
	
public static void main(String...argv)throws Exception
{
	Search s=new Search();
	List<String> urls=s.getUrls("Android","1");
	
	for(String temp:urls)
	{
		System.out.println(temp);
	}
	
	urls=s.getUrls("Android", "11");
	for(String temp:urls)
	{
		System.out.println(temp);
	}
	
}




}



