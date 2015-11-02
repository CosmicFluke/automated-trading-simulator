##Initial Planning
##Decisions made during the meeting:
Decided to create interfaces for each of the following
* User interface:
  * based on command line
  * user create experiments,strategies,rules, conditions and actions
* Strategies:
  * contains a set of rules to be applied to market data
  * set over a period of time
* rules:
  * condition: based on market indicators
  * action: buy or sell
* experiment:
  * contains strategies to be applied to market data
  * applies strategies market data over specified time periods and generates results
  * results will contain: account balance for each time period and how much was bought and sold daily
* indicators:
  * stock values
  * changes in market data over time

##Sprint Backlog
* Architecture (M-size)
* backend:
  * dataloader: load, parse and store market data (L-size)
  * stock: data for each stock                    (M-size)
  * stockday: daily data for stock                (S-size)
  * Experiment: stores strategies, runs experiment(L-size)
  * Strategy: stores rules						  (L-size)
  * Rule: made of condition and action			  (M-size)
  * Condition: checks market data				  (L-size)
  * action: buy, sell, short, cover				  (S-size)
  * decisionmaker: decides whether to apply action(M-size)
  * indicators: calculations wr market variables  (L-size)							
* top-level classes:
  * command handler                               (L-size)
  * application                                   (L-size)
* frontend: 
 * top-level terminal/UI:                         (M-size)
   * create experiment
   * create strategy
 * sub-level terminal/UI:                           
  * create/modify experiment:					  (L-size)
    * add strategies
    * set time periods for experiment
    * save experiment
  * create/modify strategy: 					  (L-size)
    * add rules
    * add conditions
    * add actions
    * save

##Update Meetings

 Location: Online-Slack 
 Time: October 27th 2015
 Participants: Asher, Bill, Shirley, Tomek
 
 * Changes made to UI:
   * launch new shells for modifyexperiment and modifystrategy rather than restricting commands
   * user select conditions and actions from a list rather than entering it themselves
 * Changes made to the top-level classes
 	*instead of having one engine class store states and make api calls based on user input, engine is split up into application and command handler
 	* application stores states while command handler makes api calls based on user commands
 
##Burndown Chart

![alt tag](https://github.com/csc301-fall-2015/project-team9-L5101/blob/master/doc/phase2/burndown/groupburndownchart.jpg)
![alt tag](https://github.com/csc301-fall-2015/project-team9-L5101/blob/master/doc/phase2/burndown/asher_chart.png = 250x)
![alt tag](https://github.com/csc301-fall-2015/project-team9-L5101/blob/master/doc/phase2/burndown/Tomasz_chart.jpg = 250x)

##Review & Retrospective
* work that isn't done:
 * user defined indicators
 * user defined conditions
 * multiple conditions applied to a rule
 * set time periods for experiment
 * generate random time set
 * indicators 
