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
 * commands: 
 * modify [arg]
 * run
 * exit			
 */
/*
 * All Terminal/CLI classes go in this package.
 */
public class SimTerminal {

	static BufferedReader br;
	
	public enum level{
		experiment, strategy, top
	}
	static level currentlevel=level.top;
	public static void run()
	{
		String name="";
		String output="";
		String input ="";
		
		br = new BufferedReader(new InputStreamReader(System.in));
		while(input!=null){
			output="";
			if(currentlevel!=level.top){
				System.out.print(currentlevel+" "+name);
			}
			System.out.print("$>");
			
			try {
				input =br.readLine();	
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] args = input.split("\\s+");
			switch(args[0].toLowerCase()){
				case "h":
				case "help" :{
					output="You asked for help!";
				}break;
				case "exit" :{
					currentlevel=level.top;
					name="";
				}break;
				case "modifyex": { //if file args[1] not found in local dir
								//create new file named args[1]
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
				}break;
				case "modifystrat":{
					if(currentlevel!=level.top){
						output="You must exit "+currentlevel+" "+name+" first";
					}else{
						if(args.length!=2){
							output="Incorrect number of arguments!";
						}else{
							currentlevel=level.strategy;
							name=args[1];
						}
					}
				}break;
				case "run": {
					if(currentlevel!=level.experiment){
						output="You have no experiment open right now.";
					}else{
						output="So you want to run " +name;
					}
				}break;
				case "": output="";
				break;
				default :{
					output="That is not a command.";
				}
			}
			if(!output.isEmpty()){
				System.out.print(""+output+" \n");
			}
		}
	}
	public static void main(String[] args){
		run();
	}

}
