* The application will run through a command line user interface, whereby the user can enter commands using standard input (terminal).
* At any prompt, the user can type [Hh]elp and view a description of what actions are available to them, and how to execute them.

```
 ----------------      ---       --------------------
| run executable | -- | > | --- | help <command=all> |
 ----------------      ---   |   --------------------
                             |   ----------------
                             -- | viewAlg <name> |
                             |   ----------------
                             |   ------------------
                             -- | modifyAlg <name> |
                             |   ------------------
                             |           |   -------------  
                             |           -- | Alg[name] > |
                             |           |   -------------
							 |   -----------------
					 		 -- | viewTest <name> |
					 		 |   -----------------
					 		 |   -------------------
					 		 -- | modifyTest <name> |
					 		 |   -------------------
                             |           |   ---------------
                             |           -- | Test [name] > |
                             |           |   ---------------
                             |   -----------------
                             -- | run <test_name> |
                             |   -----------------
							 |   --------------------
							 -- | loadResults <name> |
							     --------------------

```

###Basic Commands

**`[Hh]elp`** - display commands available to user or help on a specific command

**`[Bb]ack`** - go back to the previous menu level -- may be prompted to save changes

**`[Ee]xit`** - quit the program -- may be prompted to save changes

###Top-Level Commands

**`viewAlg`** - view an existing algorithm.  If none is specified, displays a list of available algorithms.  Usage: `viewAlg [name]`
```
> viewAlg SimpleBuyCheap

Displaying Algorithm: SimpleBuyCheap

Parameters: ITEM, BUYTHRESHOLD, MINBALANCE, NUMSHARES

:: Rule ::
Trigger: [ITEM] drops below [BUYTHRESHOLD=0]
Conditions: Account balance is greater than [MINBALANCE=0]
Action: Buy [NUMSHARES=1] units of [ITEM]

> _
```

**`modifyAlg`** - Modify an existing algorithm, by name.  If algorithm doesn't exist, create one.  Usage: `modifyAlg [name]`
* After specifying an algorithm to be modified, the prompt will change to `Alg [name] >`.
* See "Algorithm Modification" heading for sub-commands
```
> modifyAlg Algo1
"Algo1" not found.  Creating new algorithm.

Alg Algo1 > _
```

**`viewTest`** - view an existing test scenario.  If none is specified, displays a list of available tests.  Usage: `viewTest [name]`
```
> viewTest  BuyAppleCheap

Displaying Test Scenario: BuyAppleCheap

Algorithms:
SimpleBuyCheap ITEM=AAPL BUYTHRESHOLD=65 NUMSHARES=10

Time Periods:
2011-01-01 to 2011-12-31
2013-03-01 to 2013-05-01
2014-06-20 to 2014-09-20

> _
```

**`modifyTest`** -  Modify an existing test scenario, by name.  If that test scenario doesn't exist, create one.  Usage: `modifyTest [name]`
* After specifying a test to be modified, the prompt will change to `Test [name] >`.
* See "Test Scenario Modification" heading for sub-commands.

**`run`** - Runs a selected test scenario.  Usage: `run [test_name]`
* After selecting run, will prompt user to specify a filename to save results before running.
* Will tell the user that it is running the scenario and display a progress bar.

**`loadResults`** - User specifies a filename and app displays the saved results of a test scenario run.  Usage: `loadResults [filename]`

##Algorithm Modification Commands

**`newRule`** - Create a new rule for this algorithm.
* A rule consists of a set of conditions and a set of actions.
* Rules and actions are defined using the commands `newCondition` and `newAction`
* After the command `newRule`:
  * The user will be shown a list of conditions, and prompted to select a set of conditions using identifiers
  * The user will then be shown a list of actions, and prompted to select a set of actions using identifiers

Example:
```
Alg Algo1 > newRule
Select conditions.  Enter IDs separated by spaces.
C1 : [ITEM] price greater than [HIGHTHRESHOLD]
C2 : [ITEM] price less than [LOWTHRESHOLD]

Alg Algo1 | newRule | Conditions > C1_
```

**`newCondition`** - Create a new trigger/condition.
* User will be prompted to define a condition.  Each rule can have several conditions, which must all be true for an action to occur.  The trigger is typically related to the behaviour of a `ITEM` parameter (for whichever security (stock, bond, option, etc) is passed to the algorithm in a test scenario).
  * User selects from a variety of possible market events (using market statistics, or indicators)
  
**`newAction`** - Create a new action.
* User will be prompted to define an action.  Actions are buy or sell orders, where the user can define the amount of stock to buy/sell.  This amount can be a constant value, an additional parameter, or a function (the latter probably not in MVP).

**`removeRule` / `removeCondition` / `removeAction`** - Displays rules/conditions/actions and prompts user to specify an item to be removed

**`saveAlgorithm`** - Saves the modifications to disk

##Test Scenario Modification Commands

**`listAlgorithms`** - Displays a list of algorithm names with their parameters.

**`addAlgorithm`** - Adds an algorithm to the test scenario.  Prompts user to specify values for each parameter requested by the algorithm.
Usage: `addAlgorithm [name]`

**`addTime`** - Adds the specified time window to the test scenario.
Usage: `addTime [Start YYYYMMDD] [End YYYYMMDD]`


##Note
In addition to the command line UI, the executable will be able to take a text file with structured commands as input.  This will be extremely useful for testing.