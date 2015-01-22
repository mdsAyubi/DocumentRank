package com.docrank.pagerank;

public class PageRank {

	int N;
	double dampingFactor;
	double error;
	
	
	public PageRank(int numberOfDocs,double dampingFactor,double error)
	{
		this.N=numberOfDocs;
		this.dampingFactor=dampingFactor;
		this.error=error;
	}
	
	
	
	
	
	public double[] getPageRankScores(double[][] w)
	{
		double[] PR=new double[w.length];
		double[] oldPR=new double[w.length];
		double sumOfAllWeights=0.0;
		//Initialization
		for(int i=0;i<w.length;i++)
		PR[i]=1/(double)N; //or pr[i]=1/w.length;
		
		
		for(int i=0;i<w.length;i++)
		{
			for(int j=0;j<w[i].length;j++)
				sumOfAllWeights+=w[i][j];
		}
		
		do
		{
			double temp=0.0;
			
			//Saving old PageRank Values
			for(int i=0;i<PR.length;i++)
				oldPR[i]=PR[i];
				
			
			//Calculating New PageRank Values
			for(int i=0;i<N;i++)
			{
			
				for(int j=0;j<N;j++)
				{
				temp=(w[i][j]*PR[j])/sumOfAllWeights;
				}
			
				PR[i]=(1-dampingFactor)+dampingFactor*temp;
			}
		
		error=getErrorInPageRankScores(PR,oldPR);
		}while(error<0.01);
		
		
		
		
		return PR;
	}

	private double getErrorInPageRankScores(double[] newPR,double[] oldPR)
	{
	double[] temp=new double[newPR.length];
	double sum=0.0;
	for(int i=0;i<newPR.length;i++)
	{
		
			temp[i]=Math.pow((newPR[i]-oldPR[i]),2);
			sum+=temp[i];
		
	}
	
	
	
	
	return Math.sqrt(sum);

	
	}


}
