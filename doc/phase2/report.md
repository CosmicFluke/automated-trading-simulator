#Initial Planning
##Decisions made during the meeting:
  *User interface:
    *based on command line
    *user create rules that will be added to a strategy
    *strategies will then be added to experiment
    *user can run experiments through cmd
  *Strategies:
    *contains a set of rules to be applied to market data
    *set over a period of time
  *rules:
    *condition: based on market indicators
    *action: buy or sell
  *experiment:
    *can contain up to a number of strategies
    *ran over multiple periods of time and generates results for each of those time periods
    *results will contain: beginning balance, ending balance, and how much was bought and sold daily
  *indicators:
    *stock values
    *changes in market data over time
    
##Turned product backlog into a list of classes.

#Sprint Backlog
-experiment
  -strategy
  -rules
    -conditions
      -indicators
    -actions

#Update Meetings

#Burndown Chart

#Review & Retrospective
