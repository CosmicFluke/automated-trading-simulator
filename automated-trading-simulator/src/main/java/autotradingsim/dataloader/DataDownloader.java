package autotradingsim.dataloader;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Console;
import java.io.File;
import java.lang.InterruptedException;

/**
 * TODO: This needs to be either entirely deprecated or fixed up to be a functioning module.
 */
public class DataDownloader {

	public static void main(String[] args){
		
		if(Desktop.isDesktopSupported()){
			
			try{
				
				String line = null;
				String symbol;
				BufferedReader br = new BufferedReader(new FileReader("S&P-500-symbol-name-list.csv"));
				br.readLine();
				Console console = System.console();
				int i = 1;
				int n = 0;
				int limit = 1;
				String[] names = new String[1];
				while((line = br.readLine()) != null){
					symbol = line.split(",")[0];
					if(symbol.contains(".")){
						symbol.replace(".", "-");
					}
					Desktop.getDesktop().browse(new URI("http://real-chart.finance.yahoo.com/table.csv?s="+ 
														symbol));
					names[n] = symbol;
					System.out.println(i + ": " + symbol);
					n++;
					if(limit == i){
						//line = console.readLine("flow control:");
						Thread.sleep(10000); 
						for (int j = 1; j <= n; j++){
							File oldf = new File("/Users/billfeng/Downloads/table (" + j + ").csv");
							File newf = new File("/Users/billfeng/Downloads/" + names[j - 1] + ".csv");
							oldf.renameTo(newf);
						}
						//limit += Integer.parseInt(line);
						limit++;
						//names = new String[Integer.parseInt(line)];
						n = 0;
					}
					i++;
				}
				br.close();
				console.flush();
					
			}catch(IOException e){
				System.out.println(e);
			}catch(URISyntaxException u){
				System.out.println(u);
			}catch(InterruptedException i){
				System.out.println(i);
			}
			
		}
	}
}