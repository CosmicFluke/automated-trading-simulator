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
* backend:
 * dataloader: load, parse and store market data
 * stock: data for each stock
 * stockday: daily data for stock

* application layer:
 * simpleRule
 * simpleStrategy
 * simpleExperiment
 
* frontend: 
 * top-level terminal:
  * create experiment
  * create strategy
 * sub-level terminal
  * create/modify experiemnt:
   * add strategies
   * set time periods for experiment
   * save experiment
  * create/modify strategy:
   * add rules
   * add conditions
   * add actions
   * save

##Update Meetings

##Burndown Chart

##Review & Retrospective
* work that isn't done:
 * user defined indicators
 * user defined conditions
 * multiple conditions applied to a rule
 * set time periods for experiment
 * generate random time set
