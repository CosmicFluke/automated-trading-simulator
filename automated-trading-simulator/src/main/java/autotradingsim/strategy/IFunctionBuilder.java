package autotradingsim.strategy;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-30.
 *
 * Just a labeling interface for now.  Attached to classes which need to build new functions from sets of parameters,
 * and then provide those functions to collaborators.
 *
 */
public interface IFunctionBuilder {

    Function getFunction();

}
