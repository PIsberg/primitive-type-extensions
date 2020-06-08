This lib is a result of me playing around with the possibility to abstract away common code used for java primitive types

For booleans there is BooleanExt that uses boolean algebra gates for writing logic even simpler and cleaner:

e.g
```
/**
Check that a child they can have candy, or ice cream. But they can't have both! (aka known as exclusive or (xor))
**/
public void canChildEatTreats(Boolean isEatingIcecream, Boolean isEatingCandy) {
	boolean result = false;
	if(isEatingIcecream != null && isEatingCandy != null &&
	((!isEatingIcecream && !isEatingCandy) || (isEatingIcecream && isEatingCandy)) {
		result = true;
	}
	return result;
}
```
Since this is a real world example for logic known as exclusive or (xor) it can instead be simplified and written like:
```
public void canChildEatTreats(BooleanExt isEatingIcecream, BooleanExt isEatingCandy) {
	return isEatingIcecream.xor(isEatingCandy);
}
```
NOTE: nulls are treated as false and are assumed to be checked during i.e input validation instead

BooleanExt also support the following operations
Not or (nor)
xnor
nor
nand
orand
not

// Peter Isberg
