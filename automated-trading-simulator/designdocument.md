##Architecture

###Controller

The `engine` package is responsible for handling calls from the UI and delivering information back to it.  The class
`StrategyEngine` handles calls involving the strategy package, while `ExperimentEngine` handles calls involving the
Experiment package.  Stocks are handled by both, depending on context (since they will nearly always appear in the
context of one or the other).

###View

The UI is built in Swing using NetBeans Swing GUI Builder.  Efforts were made to avoid dependencies upon several
packages, so the UI primarily makes calls to the `engine` package.

###Model

The model component of this software consists of four pillars:

####Application
The singleton class `TradingApplication` represents the overall state of the application model.  It is responsible for
providing data to the engine/controller, which means either storing it in memory or in the file system, and accessing it
when needed.

The application model consists of data structures from the following packages.

####Stocks
The `stocks` package contains data structures for storing and accessing historical stock data.  An `IStock` has a symbol,
a name and a set of data.  Each stock has an associated range of valid dates, and a `StockDay` entry for each date.

Access to a stock's data can be gained either through an `IBufferAdapter` -- produced by an IStock factory method --
which provides daily data for a range of dates of a given size, ending with a specified date; or may get the entire
collection of StockDays as a stream (Java 8 object that provides access to a collection's elements by implementing
several functional interfaces with closures).

####Strategies
The `strategy` package is responsible for storing the specifications for applying strategies to stocks over periods
of time.  Each `Strategy` stores a set of rules, and has a factory method for creating a `StrategyTester` which can be
used by the `Experiment` class (see below) to run experiments.  Within `strategy` there are two sub-packages: `rules`
and `indicators`.  `rules` contains the data structure classes for defining rules (main component of strategies),
including the `IDecisionMaker` interface, which is responsible for applying a given rule to a given stock on a given
day.  The `IRule` interface has a factory method that produces `IDecisionMaker` instances, and those are used by
`StrategyTester` instances to produce lists of `IDecision` instances for `Experiment`.

####Experiments
Experiments are how a user gets results from their strategies.  An `Experiment` consists of pairings of strategies and
stocks (called "trials").  Running an experiment requires a `TimeSet`, which is a collection of uniformly long periods
of time distributed pseudo-randomly throughout a given time period.  The experiment runs its set of trials on each time
period in the time set, and generates results for each time period.  Through random sampling of historical data,
statistics can be collected which will point to the effectiveness of the strategies used.  Running an experiment produces
results in a data structure encapsulated in `ExperimentResults` (not yet implemented), which holds collections for each
period in the time set of `ResultDay` instances, which store the results for each day of each trial.