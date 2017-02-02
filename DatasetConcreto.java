import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author giuseppeaccardo
 *
 */
public class DatasetConcreto implements Dataset
{
	private int nFeature;
	private int nRecord;
	private ArrayList<Integer> featureUsate; // quelle selezionate
	private String nomeDataset;
	private String[] nomiFeature;
	
	//public double Tabella [][];
 	private ArrayList<ArrayList<Double>> Mat;
	 	
 	public double Distanza(int i, ArrayList<Double> centroide)
 	{
 		double Sum=0;
 		for(int j=0; j<nFeature; j++)
 			Sum+=Math.pow((centroide.get(j) - Mat.get(j).get(i)), 2);
 		return Math.sqrt(Sum);
 	}
 	
 	public double getCella(int i, int j)
 	{
 		return Mat.get(j).get(i);
 	}
 	
	public void inizializzaTabella()
	{
	   Mat = new ArrayList<ArrayList<Double>>();
	   featureUsate = new ArrayList<Integer>();
	   
	   for(int i=0; i< nFeature; i++)
	   {
		   Mat.add(new ArrayList<Double>());
		   featureUsate.add(i); // uso tutte le feature
	   }
	}


	public void stampaDataset()
	{
		System.out.println("Le feature selezionate sono");
		for(int j = 0; j<nFeature; j++)
			System.out.println(nomiFeature[j].toString());
		
		for(int i=0; i< nRecord; i++)
		{
			for(int j=0; j < nFeature; j++)
			{
				System.out.print( Mat.get(j).get(i)+ " ");
			}
			System.out.println("\n");
		}
	}
	
	public ArrayList<Double> getRecord(int indiceRandom)
	{
		ArrayList<Double> record = new ArrayList<Double>();
		for(int i=0; i<nFeature; i++)
			record.add( Mat.get(i).get(indiceRandom));
		
		return record;
	}
	
	public DatasetConcreto(int nFeature, String Nome) 
	{		
		setnFeature(4);
		setNomeDataset("Iris.data");
		inizializzaTabella();
	}
	
	// Craere dataset a partire da un dataset esistente con delle feature selezionate
	public DatasetConcreto(ArrayList<ArrayList<Double>> MatInput, ArrayList<Integer> featureSelezionate, int nRecord)
	{
		Mat = new ArrayList<ArrayList<Double>>();
		this.featureUsate = new ArrayList<Integer>(featureSelezionate);
		this.nRecord = nRecord;
		this.setnFeature(featureSelezionate.size());
		
		for(int i=0; i<featureSelezionate.size(); i++)
			setColonna( MatInput.get( featureSelezionate.get(i)));
		
	}
	
	public DatasetConcreto() {		// TODO Auto-generated constructor stub
	}


	public void setColonna( ArrayList<Double> colonnaValori)
	{
		this.Mat.add(colonnaValori);
	}
	
	public ArrayList<ArrayList<Double>> getTabella()
	{
		return this.Mat;
	}
	public int getnFeature() {
		return this.nFeature;
	}
	public int getnRecord() {
		return this.nRecord;
	}
	public void setnFeature(int nFeature) 
	{
		this.nFeature = nFeature;
		return;
	}
	public void setnRecord(int nRecord) {
		this.nRecord=nRecord;
		return;
	}
	
	public void setTabella(int Colonna, Double Valore) 
	{
		Mat.get(Colonna).add(Valore);
	}
	
	
	
	public String getNomeDataset() {
		return this.nomeDataset;
	}
	
	public void setNomeDataset(String nomeDataset) {
		 this.nomeDataset = new String(nomeDataset);
	}
	
	public double[][] toMatrix()
	{
	    double[][] matrix = new double[this.getnRecord()][this.getnFeature()];
		for(int i=0; i< nRecord; i++)
		{
			for(int j=0; j < nFeature; j++)
			{
				matrix[i][j] = Mat.get(j).get(i);
			}
		}
		return matrix;
	}
	
	public ArrayList<Integer> getFeatureUsate()
	{return this.featureUsate;}

	@Override
	public void setNomiFeature(String[] nomifeature) 
	{
		this.nomiFeature = new String[nFeature];
		this.nomiFeature = nomifeature;

	}
}