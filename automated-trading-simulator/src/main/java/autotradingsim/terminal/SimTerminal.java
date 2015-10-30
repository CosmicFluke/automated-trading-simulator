package autotradingsim.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by unknown.
 * Contributors: Shirley, Tomek
 *
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * Public Methods:
 *      addStock(String)
 */
/*
 * All Terminal/CLI classes go in this package.
 */
public class SimTerminal {

	static BufferedReader br;
	static String locale="Enter command: ";
	public static void run()
	{
		String line ="";
		br = new BufferedReader(new InputStreamReader(System.in));
		while(!line.equals("exit")){
			try {
				System.out.print(locale);
				System.out.print("$>");
				line =br.readLine();
				String[] args = line.split("\\s+");
				
				switch(args[0].toLowerCase()){
					case "h":
					case "help" :{
						System.out.println("you asked for help");
					} break;
					case "exit" :break;
					case "modify": { //if file args[1] not found in local dir
									//create new file named args[1]
						if(args.length!=2){ //should be modify [experiment name]
							System.out.println("incorrect number of arguments");
						}else{
							locale=args[1];
						}
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args){
		run();
	}

}
