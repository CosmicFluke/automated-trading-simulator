# project-team9-L5101
# Topic: Algorithmic Trading Simulator

## High Level Overview

The application is split into multiple layers, each providing independent core functionality.
* The UI layer is the topmost layer and is the layer which the user will directly interact with.
* The Command handler will prepare the output produced by the UI and make calls to the application
* The Application provides the back end of the service and is used to interact with raw data

## User interface
* Built in JFC/Swing
* In charge of converting commands typed in by the user and filtering out bad input.
* Help is also located at this level to assist user with providing valid input
* After the UI has filtered out bad input, it will pass the good input into the CommandHandler by way of API calls to the interface

## CommandHandler
* In charge of taking commands given to it, from the UI, and making apropriate calls to the application

## Application
* In charge of running, saving, and loading data to work with.
* Runs experiments and modifies the structures and objects as instructed by the CommandHandler

#**Add more as we go along**

####