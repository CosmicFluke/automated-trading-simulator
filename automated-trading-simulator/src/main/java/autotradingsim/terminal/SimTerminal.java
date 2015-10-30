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
	static String runningExperiment="";
	public static void run()
	{

		String output="";
		String input ="";
		br = new BufferedReader(new InputStreamReader(System.in));
		while(input!=null){
			try {
				output="";
				if(runningExperiment!="")System.out.print(runningExperiment+" ");
				System.out.print("$>");
				input =br.readLine();
				String[] args = input.split("\\s+");
				switch(args[0].toLowerCase()){
					case "h":
					case "help" :{
						output="You asked for help!";
					}break;
					case "exit" :{
						runningExperiment="";
					}break;
					case "modify": { //if file args[1] not found in local dir
									//create new file named args[1]
						if(args.length!=2){ //should be modify [experiment name]
							output="Incorrect number of arguments!";
						}else{
							runningExperiment=args[1];
						}
					}break;
					case "run": {
						if(runningExperiment.isEmpty()){
							output="You have no experiments open right now.";
						}else{
							output="So you want to run " +runningExperiment;
						}
					}break;
				}
				if(!output.isEmpty()){
					System.out.print(""+output+" \n");
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
