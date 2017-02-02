import java.util.ArrayList;

public abstract class DatasetDecorator implements Dataset {
protected Dataset dataset;

public DatasetDecorator(Dataset dataset){
this.dataset=dataset;
}

@Override
public double Distanza(int i, ArrayList<Double> centroide) {
	return this.dataset.Distanza(i, centroide);
}

@Override
public double getCella(int i, int j) {
	return this.dataset.getCella(i, j);
}

@Override
public void inizializzaTabella() {
	this.dataset.inizializzaTabella();
}

@Override
public void stampaDataset() {
	this.dataset.stampaDataset();
}

@Override
public void setColonna(ArrayList<Double> colonnaValori) {
	this.dataset.setColonna(colonnaValori);
}

@Override
public ArrayList<ArrayList<Double>> getTabella() {
	return this.dataset.getTabella();
}

@Override
public int getnFeature() {
	return this.dataset.getnFeature();
}

@Override
public int getnRecord() {
		return this.dataset.getnRecord();
}

@Override
public void setnFeature(int nFeature) {
	this.dataset.setnFeature(nFeature);	
}

@Override
public void setnRecord(int nRecord) {
	this.dataset.setnRecord(nRecord);
}

@Override
public void setTabella(int Colonna, Double Valore) {
	this.dataset.setTabella(Colonna, Valore);
}

@Override
public String getNomeDataset() {
	return this.dataset.getNomeDataset();
}

@Override
public void setNomeDataset(String nomeDataset) {
this.dataset.setNomeDataset(nomeDataset);	
}

@Override
public double[][] toMatrix() {
	return this.dataset.toMatrix();
}

@Override
public ArrayList<Integer> getFeatureUsate() {
	return this.dataset.getFeatureUsate();
}

public void setNomiFeature(String[] nomifeature) 
{this.dataset.setNomiFeature(nomifeature);}

}