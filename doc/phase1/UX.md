* The application will run through a command line user interface, whereby the user can enter commands using standard input (terminal).
* At any prompt, the user can type [Hh]elp and view a description of what actions are available to them, and how to execute them.

```
 ----------------      ---       --------------------
| run executable | -- | > | --- | help <command=all> |
 ----------------      ---   |   --------------------
                             |   ------------------
                             -- | viewStrat <name> |
                             |   ------------------
                             |   --------------------      -----------------
                             -- | modifyStrat <name> | -- | Strat [name] >  |
                             |   --------------------      -----------------
							 |   ----------------
					 		 -- | viewExp <name> |
					 		 |   ----------------
					 		 |   ------------------      ----------------------
					 		 -- | modifyExp <name> | -- | Experiment [name] >  |
					 		 |   ------------------      ----------------------
                             |   ----------------
                             -- | run <exp_name> |
                             |   ----------------
							 |   --------------------
							 -- | loadResults <name> |
							     --------------------

```

###Basic Commands

**`[Hh]elp`** - display commands available to user or help on a specific command

**`[Bb]ack`** - go back to the previous menu level -- may be prompted to save changes

**`[Ee]xit`** - quit the program -- may be prompted to save changes

###Top-Level Commands

**`viewStrat`** - view an existing trading strategy.  If none is specified, displays a list of available strategies.  Usage: `viewStrat [name]`
```
> viewStrat SimpleBuyCheap

Displaying Strategy: SimpleBuyCheap

Parameters: STOCK, BUYTHRESHOLD, MINBALANCE, NUMSHARES

:: Rule 1 ::

Conditions: 
 * [STOCK] drops below [BUYTHRESHOLD=0]
 * Account balance is greater than [MINBALANCE=0]

Actions:
 * Buy [NUMSHARES=1] units of [STOCK]

> _
```

**`modifyStrat`** - Modify an existing strategy, by name.  If strategy doesn't exist, create one.  Usage: `modifyStrat [name]`
* After specifying an strategy to be modified, the prompt will change to `Strat [name] >`.
* See "strategy Modification" heading for sub-commands
```
> modifyStrat Strategy1
"Strategy1" not found.  Creating new strategy.

Strat Strategy1 > _
```

**`viewExp`** - view an existing experiment .  If none is specified, displays a list of available experiments.  Usage: `viewExp [name]`
```
> viewExp  BuyAppleCheap

Displaying Experiment: BuyAppleCheap

Strategies:
SimpleBuyCheap STOCK=AAPL BUYTHRESHOLD=65 NUMSHARES=10

Time Periods:
2011-01-01 to 2011-12-31
2013-03-01 to 2013-05-01
2014-06-20 to 2014-09-20

> _
```

**`modifyExp`** -  Modify an existing experiment , by name.  If that experiment  doesn't exist, create one.  Usage: `modifyExp [name]`
* After specifying a experiment to be modified, the prompt will change to `Experiment [name] >`.
* See "Experiment Modification" heading for sub-commands.

**`run`** - Runs a selected experiment .  Usage: `run [experiment_name]`
* After selecting run, will prompt user to specify a filename to save results before running.
* Will tell the user that it is running the  and display a progress bar.

**`loadResults`** - User specifies a filename and app displays the saved results of a completed experiment.  Usage: `loadResults [filename]`

###Strategy Modification Commands

**`newRule`** - Create a new rule for this strategy.
* A rule consists of a set of conditions and a set of actions.
* Rules and actions are defined using the commands `newCondition` and `newAction`
* After the command `newRule`:
  * The user will be shown a list of conditions, and prompted to select a set of conditions using identifiers
  * The user will then be shown a list of actions, and prompted to select a set of actions using identifiers

Example:
```
Strat Strategy1 > newRule
Select conditions.  Enter IDs separated by spaces.
C1 : [STOCK] price greater than [HIGHTHRESHOLD]
C2 : [STOCK] price less than [LOWTHRESHOLD]

Strat Strategy1 | newRule | Conditions > C1_
```

**`newCondition`** - Create a new trigger/condition.
* User will be prompted to define a condition.  Each rule can have several conditions, which must all be true for an action to occur.  The trigger is typically related to the behaviour of a `STOCK` parameter (for whichever stock is passed to the strategy in an experiment ).
  * User selects from a variety of possible market events (using market statistics, or indicators)
  
**`newAction`** - Create a new action.
* User will be prompted to define an action.  Actions are buy or sell orders, where the user can define the amount of stock to buy/sell.  This amount can be a constant value, an additional parameter, or a function (the latter probably not in MVP).

**`removeRule` / `removeCondition` / `removeAction`** - Displays rules/conditions/actions and prompts user to specify an item to be removed

**`saveStrategy`** - Saves the modifications to disk

###Experiment Modification Commands

**`listStrats`** - Displays a list of strategy names with their parameters.

**`addStrategy`** - Adds a strategy to the experiment.  Prompts user to specify values for each parameter requested by the strategy.
Usage: `addStrat [name]`

**`addTime`** - Adds the specified time window to the experiment.
Usage: `addTime [Start YYYYMMDD] [End YYYYMMDD]`

**`addRandomTimeSet [size] [length]`** -- Adds a randomly generated set of time windows: `size` windows, each `length` days long.


###Note
In addition to the command line UI, the executable will be able to take a text file with structured commands as input.  This will be extremely useful for experimenting.