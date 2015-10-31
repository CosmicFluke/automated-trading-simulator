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
					HandleHelp(args);
					break;

				case "viewstrat":
					HandleViewStrategy();
					break;
					
				case "modifystrat":
					HandleModifyStrategy(args);
					break;	
					
				case "viewexp":
					HandleViewExperiment();
					break;
					
				case "modifyex":
					HandleModifyExperiment(args);
					break;

				case "run":
					handleRun(args);
					break;

				case "e":
				case "exit" :
					running = false;
					break;

				case "":
					break;

				default :
					System.out.println("Please enter a valid command.");
					ListCommands();
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
	
	private void HandleViewExperiment() {
		
	}

	private void HandleViewStrategy() {
		
	}

	private void ListCommands() {
		System.out.println("Valid commands include:\r\n"
				+ "help [<command>]\r\n"
				+ "viewStrat <name>\r\n"
				+ "modifyStrat <name>\r\n"
				+ "viewExp <name>\r\n"
				+ "modifyExp <name>\r\n"
				+ "run <experiment_name>");
	}

	private void HandleModifyExperiment(String[] args) {
	}

	private void HandleModifyStrategy(String[] args) {
	}

	private void handleRun(String[] args) {
		if(args.length == 1){
			System.out.println("Running default experiment");
			return;
		}
	}
	
	private void HandleHelp(String[] args) {
		if(args.length == 1){
			System.out.println("Welcome to the auto stock trading simulator!");
		}
		else{
			String helpString = "";
			switch(args[1].toLowerCase()){
				case "viewstrat":
					helpString = "View an existing trading strategy. "
							+ "If none is specified, displays a list of "
							+ "available strategies. Usage: viewStrat [name]";
					break;
					
				case "modifystrat":
					helpString = "Modify an existing strategy, by name. "
							+ "If strategy doesn't exist, one is created by that name. "
							+ "After specifying an strategy to be modified, the prompt "
							+ "will change to Strat [name] >. See help strategyModification "
							+ "for sub-commands.\r\n"
							+ "Usage: modifyStrat [name]";
					break;	
					
				case "viewexp":
					helpString = "viewExp - view an existing experiment. If none is specified, "
							+ "displays a list of available experiments. Usage: viewExp [name]";
					break;
					
				case "modifyex":
					helpString = "Modify an existing experiment by name. If that experiment doesn't exist, "
							+ "create one under given name. After specifying a experiment to be modified, "
							+ "the prompt will change to Experiment [name] >. See help experimentModification"
							+ " for sub-commands.\r\n"
							+ "Usage: modifyExp [name]";
					break;
	
				case "run":
					helpString = "run - Runs a selected experiment. "
							+ "Usage: run [experiment_name]";
					break;

				case "experimentModification":
				case "strategyModification":
					helpString = "help for modifications not yet implemented";
					break;
					
				default:
					helpString = "Did not understand " + args[1] +
								" as a valid input. Needs to be one of viewstrat, modifystrat"
								+ ", viewexp, modifyex, run, experimentModification, or strategyModification";
					break;
			}
			System.out.println(helpString);
		}
	}
}
