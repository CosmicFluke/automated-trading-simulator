* The application will run through a command line user interface, whereby the user can enter commands using standard input (terminal).
* At any prompt, the user can type [Hh]elp and view a description of what actions are available to them, and how to execute them.

```
 ----------------      ---      --------------------
| run executable | -- | > | -- | help <command=all> |
 ----------------      ---  |   --------------------
                            |   ------------------
                            -- | viewAlg <name> |
                            |   ------------------
                            |   ----------------
                            -- | loadAlg <name> |
                            |   ----------------
                            |   ------------------
                            -- | modifyAlg <name> |
                            |   ------------------
                            |           |   ----------    
                            |           -- | [name] > |
                            |           |   ----------
							|   -----------------
							-- | viewTest <name> |
							|   -----------------
							|   -------------------
							-- | modifyTest <name> |
							|   -------------------
                            |   ----------------
                            -- | run <test_name> |
                                ----------------

```

*`[Hh]elp`* - display commands available to user or help on a specific command
*`[Bb]ack`* - go back to the previous menu level -- may be prompted to save changes
*`[Ee]xit`* - quit the program -- may be prompted to save changes

*`viewAlg`* - view an existing algorithm
Usage: viewAlg [name]
```
> viewAlg SimpleBuyCheap
Displaying Algorithm: SimpleBuyCheap

Parameters: Stock Name, Buy Threshold, Minimum Balance, Number of Shares

:: Rule ::
Trigger: [Stock Name] drops below [Buy Threshold]
Conditions: Account balance is greater than [Minimum Balance]
Action: Buy [Number of Shares] [Stock Name]

> _
```

*`modifyAlg`* - Modify an existing algorithm, by name.  If algorithm doesn't exist, create one.
Usage: modifyAlg [name]

* After specifying an algorithm to be modified, the prompt will change to `[name] >`.

```
> modifyAlg Algo1
"Algo1" not found.  Creating new algorithm.

Algo1 > _
```

Modification commands include:
*`newRule`* - Create a new rule for this algorithm.
* A rule consists of a set of conditions and a set of actions.
* Rules and actions are defined using the commands `newCondition` and `newAction`
* After the command `newRule`:
  * The user will be shown a list of conditions, and prompted to select a set of conditions using identifiers
  * The user will then be shown a list of actions, and prompted to select a set of actions using identifiers

*`newCondition`* - Create a new trigger/condition.
* User will be prompted to define a condition.  Each rule can have several conditions, which must all be true for an action to occur.  The trigger is typically related to the behaviour of a `ITEM` parameter (for whichever security (stock, bond, option, etc) is passed to the algorithm in a test scenario).
  * User selects from a variety of possible market events (using market statistics, or indicators)
  
*`newAction`* - Create a new action.
* User will be prompted to define an action.  Actions are buy or sell orders, where the user can define the amount of stock to buy/sell.  This amount can be a constant value, an additional parameter, or a function (the latter probably not in MVP).


##Note
In addition to the command line UI, the executable will be able to take a text file with structured commands as input.  This will be extremely useful for testing.