#Planning
##Initial Planning:
Demo: Bill wanted to have our GUI to be functional enough to demonstrate everything from the creation of strategy and experiment to running and displaying the results of an experiment.

####Sprint Backlog:
Completed Tasks:
* Test SimpleMovingAverage class priority - [high] [Size-M]
* Test BufferAdapter class priority - [high] [Size-M]
* Implement StaticCondition class (general case for ICondition with unchanging comparison value) feature request priority - [high] [Size-S] 
* Implement Strategy class (multiple rules) feature request priority - [high] [Size-M]
* Remove Stock csv's from resources application enhancement feature request priority - low [Size-S]
* Modify application class to reflect required changes application documentation enhancement priority - [high] [Size-M]
* stock & strategy is moved to be placed under TradingApplication application priority - [high] [Size-S]
* Strategy names are not checked for valid format bug priority - low [Size-S] strategy
* change from getStrategy(int id) to getStrategy(String name) [Size-S]
* Design UI/UX - First Pass documentation priority - [high] [Size-M] 
* Implement *meta* IMeasurement class enhancement feature request priority - low [Size-L]
* Create MovingAverageIndicator class feature request priority - [high] [Size-M]
* Reorganize application package application priority - [high] [Size-L]
* Save Strategies to file (serialization or text specification) application Critical feature request priority - [high] [Size-M]
* Fix open IO BufferedReader in Stock.StockLoader bug priority - low [Size-S]
* Implement Stock Collection in TradingApplication application priority - [high] [Size-S]

Incompleted Tasks:
* Change StrategyDemoFactory::newAdvancedStrategy to use non-constant sell quantity priority - [high] [Size-S]
* Constant "sell" quantities are almost useless -- implement variable shares-based quantities feature request priority - [high] [Size-L] 
* IDecisionMaker needs to get information about shares from Experiment for shares-based quantities experiment feature request priority - [high] [Size-M] 
* Fix broken delete experiment in ExperimentList (UI) [priority-low] [Size-S] 
* Write report: planning.md Critical priority - [high] Report [Size-L]
* Test MetaIndicators (IndicatorRelativeChange and IndicatorAbsoluteChange) Critical priority - [high] [Size-M]
* Create Condition GUI: Hard code indicators to measurement dropdown priority - [high] [Size-M] 
* Write report: process.md Critical priority - [high] Report [Size-L]
* Implement Container class "ExperimentResults" for Experiment results experiment feature request priority - [high] [Size-L]
* ExperimentEngine to generate timeset based on experiment engine experiment feature request [priority-low] [Size-S]
* Restrict timeline of each stock in runExperiment experiment [priority-low] [Size-M]
* Create condition: change value being compared to to user input field [Size-S] 
* Change create experiment prompt window title [priority-low] [Size-S]
* ViewStrategy: display list of rules in window, conditions and actions in dropdown [priority-low] [Size-M] 
* write test cases for TradingApplication.delExperiment application [priority-low] [Size-S]
* SimpleStockValue should be deprecated [priority-low] [Size-S]
* Error when running Experiment tests bug experiment priority - [high] [Size-S] 
* There's no way to programmatically get a list of available indicators/IMeasurements. bug feature request [priority-low] [Size-M]
* Implement functioning UI form(s) for adding rules (with conditions and actions) to a strategy Critical priority - [high] [Size-M]
* open viewexperiment upon creating experiment feature request [priority-low] [Size-S]
* Test Experiment using more advanced Strategy set-up experiment [priority-low] [Size-L] strategy test
* Connect UI to ExperimentEngine Critical experiment feature request priority - [high] [Size-L] UI
* Ensure that StrategyEngine instantiates objects from full Strategy implementation Critical engine priority - [high] [Size-M]
* Connect UI to StrategyEngine Critical engine priority - [high] [Size-L]
* Test new IRule implementation [priority-low] [Size-M] 

##Re-planning and Adjustments
Towards the end of the last meeting we realized that we cannot implement what we intended. We will instead only implement most important part of our application, which is running experiment and displaying results, and subsequently write a utility class to programmatically construct the strategies that will be used in the experiment.

###Goals that weren't met:
* Working in pairs
* Functional GUI for creating strategy
* Weekly meetings and scrum meetings

##Review and Retrospectives
Even though communication and participation has improved since the last phase, it was still disorganized. This resulted in us not being able to implement the ideal MVP while still being sleep-deprived.
For the next phase I would like to have a very structured Scrum Planning Meeting with detailed meeting minutes, to identify tasks and assign them to group members. I would also encourage group members to hold themselves responsible for completing tasks.

