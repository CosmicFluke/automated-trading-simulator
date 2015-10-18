import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Console;
import java.io.File;

public class dataDownloader{
	
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
														symbol + 
														"&d=9&e=18&f=2015&g=d&a=1&b=28&c=1996&ignore=.csv"));
					names[n] = symbol;
					System.out.println(symbol);
					n++;
					if(limit == i){
						line = console.readLine("flow control:");
						for (int j = 1; j <= n; j++){
							File oldf = new File("/Users/billfeng/Downloads/table (" + j + ").csv");
							File newf = new File("/Users/billfeng/Downloads/" + names[j - 1] + ".csv");
							oldf.renameTo(newf);
						}
						limit += Integer.parseInt(line);
						names = new String[Integer.parseInt(line)];
						n = 0;
					}
					i++;
				}
					
			}catch(IOException e){
				System.out.println(e);
			}catch(URISyntaxException u){
				System.out.println(u);
			}
			
		}
	}
}