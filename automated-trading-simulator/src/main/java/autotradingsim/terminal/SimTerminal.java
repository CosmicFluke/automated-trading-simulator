package autotradingsim.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * All Terminal/CLI classes go in this package.
 */
public class SimTerminal {

	BufferedReader br;
	
	public void run()
	{
		boolean running = true;
		br = new BufferedReader(new InputStreamReader(System.in));
		while(running){
			System.out.print("\n>");
			
			try {
				running = (br.readLine() != null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
