import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author giuseppeaccardo
 *
 */

public interface Dataset
{ 
	public double Distanza(int i, ArrayList<Double> centroide); 	//ok
 	public double getCella(int i, int j);
	public void inizializzaTabella();	
	public void stampaDataset();
	public void setColonna( ArrayList<Double> colonnaValori);
	public ArrayList<ArrayList<Double>> getTabella();
	public int getnFeature(); //ok
	public int getnRecord() ;
	public void setnFeature(int nFeature); 
	public void setnRecord(int nRecord); 	
	public void setTabella(int Colonna, Double Valore); 
	public String getNomeDataset();	
	public void setNomeDataset(String nomeDataset);
	public double[][] toMatrix();
	public ArrayList<Integer> getFeatureUsate(); // Per le feature selezionate
	public void setNomiFeature(String[] nomiFeature);

}