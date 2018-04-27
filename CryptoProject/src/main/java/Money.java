
/*
This class holds the basic object which is later derived from to create Cryptocurrency. It is a basic example
of how derivation works in OOP.
*/

import java.io.Serializable;
import java.math.BigDecimal;

abstract class Money implements Serializable {

    BigDecimal amountHeld;

}
