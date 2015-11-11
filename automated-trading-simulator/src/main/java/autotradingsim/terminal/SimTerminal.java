package autotradingsim.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import autotradingsim.engine.Engine;
/** 12
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * commands: 
 * modify [arg]
 * run
 * exit	
 * 
 * implemented interface: 
 * handleModifyExperiment(String[] args)
 * handleModifyStrategy (String[] args)
 * ListCommands: added lists for experiment and strategy level
 * 
 *All Terminal/CLI classes go in this package.
 */

public class SimTerminal {

	private Engine engine;
	
	public SimTerminal(){
		engine = new Engine();
	}
	public boolean checkArgNum(String[]args, int correctnum){
		if(args.length!=correctnum){
			System.out.println("invalid number of arguments for "+args[0]);
			return false;
		}
		return true;
	}

    public static void main(String[] args){
        SimTerminal st = new SimTerminal();
        System.out.println("Welcome to Automated Trading Simulator!");
        System.out.println("Type 'help' to see a list of commands.");
        st.run();
    }
	
	public void run()
	{
		boolean running = true;
		do {			
			String[] args = getUserInput();
			if(args == null)
				return;

			switch(args[0].toLowerCase()){
				case "help" :
					HandleHelp(args);
					break;
				case "viewstrat":
					if(args.length == 1){
						engine.viewStrategy("");
					}
					if(args.length == 2){
						engine.viewStrategy(args[1]);
					}
					break;
				case "modifystrat":
					if(args.length == 2){
						HandleModifyStrategy(args);
					}
					if(args.length == 1){
						engine.createDefaultStrategy();
					}
					
					break;		
				case "viewexp":
					if(checkArgNum(args,2)){
						//engine.viewExperiment(args[1]);
					}
					break;
				case "modifyexp":
					if(checkArgNum(args, 2)){
						HandleModifyExperiment(args);
					}
					break;
				case "run":
					if(checkArgNum(args,2)){
						handleRun(args[1]);
					}
					break;
				case "exit" :
					if(checkArgNum(args, 1)){
						running = false;
					}
					break;

				case "":
					break;

				default :
					System.out.println("Please enter a valid command.");
					ListCommands("");
			}
		} while(running);
	}

	public String[] getUserInput() {
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("> ");
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
	

	private void ListCommands(String operationtype) {
		if(operationtype.isEmpty()){
			System.out.println("Valid commands include:\r\n"
					+ "help [<command>]\r\n"
					+ "viewStrat <name>\r\n"
					+ "modifyStrat <name>\r\n"
					+ "viewExp <name>\r\n"
					+ "modifyExp <name>\r\n"
					+ "run <experiment_name>");
		}
		if(operationtype.equals("experiment")){
			System.out.println("Valid commands in experiment include:\r\n"
					+ "e/exit \r\n"
					+ "liststrat\r\n"
					+ "addstrat <name>\r\n"
					+ "addtime [Start YYYYMMDD] [End YYYYMMDD]\r\n"
					+ "addrandomtimeset [size] [length]\r\n"
					+ "save\r\n"
					+ "run");
		}
		if(operationtype.equals("strategy")){
			System.out.println("Valid commands in experiment include:\r\n"
					+ "e/exit \r\n"
					+ "newrule\r\n"
					+ "newcond \r\n"
					+ "newaction \r\n"
					+ "removerule\r\n"
					+ "removecond\r\n"
					+ "removeaction\r\n"
					+ "save");
		}
	}
	/**
	 * @param exargs
	 * Start a new loop for creation/modification of experiments.
	 * Throws IllegalArgumentExceptions
	 */
	private void HandleModifyExperiment(String[] exargs) {
		String currentExperiment = exargs[1];
		boolean running=true;
		do{
			System.out.print(currentExperiment);
			String[] args = getUserInput();
			switch(exargs[0].toLowerCase()){
				case "e":
				case "exit": 
					running = false;
					break;
				case "h":
				case "help":
					HandleHelp(args);
					break;
				case "addstrat":
					//add existing strategies
					//engine.addStrategy(currentExperiment, args[1]);
					break;
				case "addtime":
					//CommandHandler.addExpTime(currentExperiment,args);
					break;
					//add time period [Start YYYYMMDD] [End YYYYMMDD]
				case "liststrat":
					//liststrat [-a] display all or current strategies
					if(args.length == 1){
						engine.viewStrategy("");
					}if(args.length == 2 && args[1].equals("-a")){
						engine.viewStrategy("");
					} else if (false/*something?*/) {
					    // do something
					}
					break;
				case "save":
					//CommandHandler.saveEx(currentExperiment);
					break;
				case "addrandomtimeset":
					//Adds a randomly generated set of time windows: size windows, each length days long.
					if(checkArgNum(args, 3)){
						engine.addtimeset(currentExperiment, args[1], args[2]);
					}
					break;
				default :
					System.out.println("Please enter a valid command.");
					ListCommands("experiment");
			}
		}while(running);
	}

	private void HandleModifyStrategy(String[] stratargs) {
		String stratname = stratargs[1];

		boolean running = true;
		do{
			System.out.print(stratargs[1]);
			String[] args = getUserInput();
			switch(args[0].toLowerCase()){
				case "e":
				case "exit": 
					running=false;
					break;
				case "newrule":

					//get user input for condition
					engine.printconditions();
					String choice = getUserInput()[0];
					while(!Character.isDigit(choice.toCharArray()[0])
							||((Integer.parseInt(choice) != 1) && (Integer.parseInt(choice) != 2))){
						System.out.println("please enter 1 or 2");
						choice = getUserInput()[0];
					}
					int select = Integer.parseInt(choice);
					System.out.print("Set value for x: ");
					choice = getUserInput()[0];
					while(!Character.isDigit(choice.toCharArray()[0])){
						System.out.print("enter a number: ");
						choice = getUserInput()[0];
					}
					int val = Integer.parseInt(choice);
					
					//get user input for actions
					engine.printactions();
					String achoice=getUserInput()[0];
					while(!Character.isDigit(achoice.toCharArray()[0])
							||(Integer.parseInt(achoice)!=1 && Integer.parseInt(achoice) != 2)){
						System.out.println("please enter 1 or 2");
						achoice=getUserInput()[0];
					}
					int aselect = Integer.parseInt(achoice);
					System.out.print("Set value for y: ");
					achoice = getUserInput()[0];
					while(!Character.isDigit(achoice.toCharArray()[0])){
						System.out.print("enter a number: ");
						achoice = getUserInput()[0];
					}
					int aval = Integer.parseInt(achoice);
					engine.addNewSimpleStrategy(stratname, select, val, aselect, aval);
					break;

				case "h":
				case "help":
					HandleHelp(args);
					break;
				case "newcond":
					//define new condition
					//CommandHandler.addCond(args[1]);
					break;
				case "newaction":
					//define amount to buy and sell
					//CommandHandler.addAction(args[1]);
					break;
				case "removecond":
					//remove a condition from list
					//CommandHandler.removeCond(args[1]);
					break;
				case "save":
					engine.saveCurrentStrategy();
					System.out.println("Strategy: " + stratname + " is saved");
					System.out.println("now exiting back to main menu");
					running = false;
					break;
				default :
					System.out.println("Please enter a valid command.");
					ListCommands("strategy");

			}
		} while(running);
	}

	private void handleRun(String experimentname) {

			System.out.println("Running default experiment");
			return;
	}
	
	private void HandleHelp(String[] args) {
		if(args.length == 1){
			System.out.println("What do you need help with? Try: help viewstrat, modifystrat, viewexp, modifyexp, run.");
		}else{
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
					
				case "modifyexp":
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
					
				default:
					helpString = "Did not understand " + args[1] +
								" as a valid input. Needs to be one of viewstrat, modifystrat"
								+ ", viewexp, modifyex, run";
					break;
			}
			System.out.println(helpString);
		}
	}
}
