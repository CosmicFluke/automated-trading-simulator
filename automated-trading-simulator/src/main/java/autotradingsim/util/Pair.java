package autotradingsim.util;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basic 2-tuple class.  Immutable.  Access members (x and y) directly.
 *
 */
public class Pair<X, Y> {

    public final X x;
    public final Y y;

    public Pair (X x, Y y) {
        this.x = x;
        this.y = y;
    }

}
