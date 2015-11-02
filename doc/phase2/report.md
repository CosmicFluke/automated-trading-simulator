##Initial Planning
##Decisions made during the meeting:
Decided to create java packages for each of the following
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
* backend:
  * dataloader: load, parse and store market data (L-size)
  * stock: data for each stock                    (M-size)
  * stockday: daily data for stock                (S-size)

* top-level classes:
  * command handler                               (L-size)
  * application                                   (L-size)
 
* frontend: 
 * top-level terminal/UI:                           (M-size)
   * create experiment
   * create strategy
 * sub-level terminal/UI:                           (L-size)
  * create/modify experiment:
    * add strategies
    * set time periods for experiment
    * save experiment
  * create/modify strategy:
    * add rules
    * add conditions
    * add actions
    * save

##Update Meetings
 * Meetings were conducted online
 * Changes made to UI:
   * 
 * Changes made to the top-level classes
 * 
 
##Burndown Chart
 
##Review & Retrospective
* work that isn't done:
 * user defined indicators
 * user defined conditions
 * multiple conditions applied to a rule
 * set time periods for experiment
 * generate random time set
