package autotradingsim.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * commands: 
 * modify [arg]
 * run
 * exit			
 */
/*
 * All Terminal/CLI classes go in this package.
 */
public class SimTerminal {

	public void run()
	{
		boolean running = true;
		do {
			System.out.print("$>");
			
			String[] args = getUserInput();
			if(args == null)
				return;

			switch(args[0].toLowerCase()){
				case "h":
				case "help" :
					HandleHelp();
					break;

				case "modifyex":
					HandleModifyExperiment(args);
					break;
				
				case "modifystrat":
					HandleModifyStrategy(args);
					break;
					
				case "run":
					handleRun();
					break;

				case "exit" :
					running = false;
					break;

				case "":
					break;

				default :
					System.out.println("Please enter a valid command.");
					HandleHelp();
			}
		} while(running);
	}

	private String[] getUserInput() {
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input =	br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if(input == null) {
			return null;
		}
		String[] args = input.split("\\s+");
		return args;
	}

	private void HandleModifyExperiment(String[] args) {
	/*
		if(currentlevel!=level.top){
			output="You must exit "+currentlevel+" "+name+" first";
		}else{
			if(args.length!=2){ //should be modify [experiment name]
				output="Incorrect number of arguments!";
			}else{
				currentlevel=level.experiment;
				name=args[1];
			}
		}
		*/
	}

	private void HandleModifyStrategy(String[] args) {
		/*
			if(args.length!=2){
				System.out.println("Incorrect number of arguments!");
			}else{
				currentlevel=level.strategy;
				name=args[1];
			}
		*/
	}

	private void handleRun() {
	}
	
	private void HandleHelp() {
		System.out.println("Help invoked");
	}
	
}
