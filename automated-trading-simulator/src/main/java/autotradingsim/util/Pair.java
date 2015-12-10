package autotradingsim.util;

import java.io.Serializable;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basic 2-tuple class.  Immutable.  Access members (x and y) directly.
 *
 */
public class Pair<X, Y> implements Serializable{

	private static final long serialVersionUID = 1647272678901384368L;
	public final X x;
    public final Y y;

    public Pair (X x, Y y) {
        this.x = x;
        this.y = y;
    }

}
