##Architecture

The backend of this software consists of three pillars:

###Stocks
Stocks are incidental, in a way, to the rest of the program.  A stock is a name and a set of data.  Each stock has an associated range of valid dates, and an entry for each date.  Note that "date" in this context includes time, so it is technically possible to have multiple entries for each day.  Implementations of the stock class for the MVP 

A class which wants to use a stock's data must provide a data range

###Strategies

###Experiments
Experiments are how a user gets results.  An experiment consists of a set of strategies.