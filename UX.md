We've decided the best way to implement our UI will be through a fake command line.

 ----------------      ---      --------------------
| run executable | -> | $ | -> | help <command=all> |
 ----------------      ---  |   --------------------
                            |   ------------------
                            -> | loadStock <name> |
                            |   ------------------
                            |   ----------------
                            -> | loadAlg <name> |
                            |   ----------------
                            |   ----------------
                            -> | saveAlg <name> |
                            |   ----------------
                            |   ------------------
                            -> | modifyAlg <name> |
                            |   ------------------
                            |   ---------------------------------------------------
                            -> | run <algName=defaultAlg> <stockName=defaultStock> |
                                ---------------------------------------------------

Help - display commands available to user or help on a specific command

loadStock - load a stock from a file. Label the stock with the filename. "GOOG.csv" will be labeled GOOG.

loadAlg - load an algorithm by name from a recently saved session.

saveAlg - save an alogrithm to file by name. Saved to local folder under name.alg

modifyAlg - Modify an existing algorithm, previously loaded, by name. If algorithm name does not exist, create it.

Defualt Parameters: By default we have a default algorithm and a default stock picked out. The arguments to run
                    are optional, and when not specified, the defaults are used. This gives users a baseline 
                    and let's them get started quickly on developing their algorithm.

                    When any algorithm or stock modifiers are called, such as loading, or modifying, the default
                    is replaced by the modified stock or algorithm.

In addition to the virtualized command line, we will allow arguments passed straight into the executable to execute
the same commands. This will be mainly used for testing our application, plus allows for a graphical back end
for future development