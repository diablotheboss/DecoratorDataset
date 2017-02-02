import java.io.IOException;

public class Client {

	public static void main(String[] args) throws IOException 
	{
		Dataset ds = new DatasetConcreto();
		Dataset iris = new Iris("./src/Iris.data", ds);
		ds.stampaDataset();
	}

}
