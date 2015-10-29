# Proposal for Algorithmic Trading Simulator

## Objective

This application will be a platform for non-professional traders to test and optimize trading algorithms for securities, using historical data (back testing). Users will be able to specify algorithms using the UI, and run simulations over specified periods of time on historical data for specified stocks. The application aims to make algorithmic trading easy for anyone who has a background in trading but little technical knowledge.

## Key Personas

###1. Eduardo the Economics Student: 
Eduardo is a student of International Economics and Finance at Ryerson University. Due to his education, Eduardo has a strong understanding of market forces, and in addition he has taught himself the basics of algorithmic trading through books and online resources. He has also studied some financial mathematics, but hasn't applied it to his trading. He has spent some time building a small securities portfolio.

###2. Market Momma Maggie:
Maggie is mother of two boys and a part-time day trader. She holds an undergraduate degree in psychology, where she gained some experience with statistical software SPSS, but generally she's not accustomed to highly technical software. Trading takes a lot of time out of her busy life, and she would really like to automate her rather defined set of strategy with a computer program so she can spend more time with her kids. With this in mind, she is looking for a easy to use software that can let her try out how it would be like to automate her trades instead of having to watch the market herself.

## Scenarios

###1. Economics Student
Eduardo the wants to try his hand at algorithmic trading, but before investing his savings, he wants some evidence that his algorithm works. This can be achieved through back testing. After a long and exhaustive search on the Internet, he was not able to find a good tool within a reasonable price range and has a relatively shallow learning curve to start with. As a student user, he wants to use a free application before committing to a paid advanced tool to test his hypotheses on historical data. (Priority: high. Difficulty: med)

###2. Market Momma
Maggie would like to bring in a more predictable income, with less day-to-day work, by improving her trading strategies. A friend told her about automated trading. She doesn't have the expertise, nor the time to learn about financial mathematics, but she'd like to try out some simple automated trading algorithms. To help mitigate the risk and test her methods, she's looking for an easy-to-learn tool that'll simulate results and help her learn to trade effectively using algorithms. (Priority: high. Difficulty: high) 

## Key Principles
* Simple, easy-to-navigate terminal interface
  * The application should be easy to use for someone who has a background in trading but little-to-no programming experience nor knowledge of financial mathematics
* Allow a user to create, save, and modify trading algorithms
  * Algorithms can be specified using preset trigger-condition-action combinations
  * Basic recipe is _buy/sell <amount> when <conditions>_
    * Conditions should include fixed price thresholds, percentage changes, and account balance
* User can run on-demand tests, or create a test queue for multiple stocks, over multiple time periods
  * The application will recommend default configurations for statistically reliable testing
* Output should be easy to read for the purpose of gaining insight on the effectiveness of the algorithm
* The software should allow algorithms to be created for all kinds of market actions that a trader would want to perform in a real-life trading situation.

###UX
* The application will run using a custom command line designed for ease of use.
* Preliminary UX details can be found in the Markdown file UX.md