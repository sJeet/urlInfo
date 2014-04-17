package URLInfo;

import java.io.BufferedReader;				//For buffer reader
import java.io.IOException;					//For IO Exception
import java.io.InputStreamReader;			//For input stream reader
import java.io.PrintWriter;					//For print writer
import java.net.MalformedURLException;		//For Mal formed exception
import java.net.URL;						//For URL methods
import javax.swing.JOptionPane;				//For user input

//URL Info class
public class URLInfo {

	//Main Function
	public static void main(String[] args) throws IOException {

	//For handling the exception
	try {
		
		String urlLink = null;				//variable for URL 
		String destName = null;				//variable for filename
		
		//User input for URL
		urlLink = JOptionPane.showInputDialog("Enter URL");
		//Create an object of class URL for operations
		URL InfoObj = new URL(urlLink);

		//User input for destination file
		destName = JOptionPane.showInputDialog("Save As (.txt)");
		//Create and open the file for writing
		PrintWriter FileWrite = new PrintWriter(destName + ".txt");

		//Write into file
		FileWrite.println("Protocol is " + InfoObj.getProtocol());
		FileWrite.println("Host is " + InfoObj.getHost());
		FileWrite.println("Port is " + InfoObj.getPort());
		FileWrite.println("File is " + InfoObj.getFile());
		
		//Fetch the stream and write into file
		try (BufferedReader StreamInfo = new BufferedReader(new InputStreamReader(InfoObj.openStream()))) {
			String inputStream;
                
			while ((inputStream = StreamInfo.readLine()) != null)
				FileWrite.println(inputStream);
		}
		catch (MalformedURLException mue) {
			System.out.println("MalformedURLException: " + mue);
		}

		//Close the file after writing into it
		FileWrite.close();
		
		//Indicate that the file has been written
		System.out.println("Data has been written in " + destName + ".txt");
		
	}
	catch (MalformedURLException e) {
		System.out.println("MalformedURLException:" + e);
	}
	
	catch (IOException ioe) {
		System.out.println("IOException: " + ioe);
	}
	
	}

}
