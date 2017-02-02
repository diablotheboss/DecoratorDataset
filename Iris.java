import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.event.RowSorterEvent.Type;


/**
 * @author Giuseppe Accardo
 *
 *	Classe per il dataset
 */

// Classe generica

public class Iris extends DatasetDecorator
{
	//private Dataset dataset;
	
	 private final String[] nomiFeature = {"LunghezzaSepalo",
												"LarghezzaSetalo",
												 "LunghezzaPetalo",
												 "LarghezzaPetalo"}; 	

	//Costruttore: Crea dataset caricandolo da file
	public Iris(String NomeFile, Dataset dataset) throws IOException
	{
		super(dataset);

		// Costruttore padre Imposta il nome dataset e numero colonne
		//super(4,"Iris.data");
	    super.dataset.setnFeature(4);
	    super.dataset.setNomiFeature(nomiFeature);
	    super.dataset.inizializzaTabella();
	    
		System.out.println("Nome dataset: " + super.dataset.getNomeDataset());
		//Tabella = new double[getnRecord()][getnFeature()];
		
		super.setnRecord( CaricaDataset(NomeFile) );
		System.out.println("Record letti da dataset: " + super.getnRecord());	
	}
	// Throws specifica l'eccezzione che potrebbe lanciare
	protected int CaricaDataset(String pathFile) throws IOException
	{
		int iRecord = 0;
		BufferedReader bufferLetto = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			bufferLetto = new BufferedReader(new FileReader(pathFile));

			while ((line = bufferLetto.readLine()) != null) 
			{
				if (line.length() > 0) 
				{
					String[] cell = line.split(cvsSplitBy);
					this.addRow(cell);
					iRecord++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferLetto != null) {
				try {
					bufferLetto.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return iRecord;
	}
	
	// nuova riga da aggiungere
	public void addRow(Object cell[]) 
	{
		System.out.println(this.nomiFeature.length);
		for(int i=0; i<this.nomiFeature.length; i++)
			super.dataset.setTabella(i, Double.parseDouble(cell[i].toString()));
	}
	

}	