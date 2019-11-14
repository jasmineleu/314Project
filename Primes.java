import java.util.ArrayList; 
import java.math.BigInteger;

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class Primes {
	// Pair class implementation.
	private class Pair<T> {
		T first;
		T second;
		Pair(T first, T second) {
			this.first = first;
			this.second = second;
		}
		T getFirst() { return first; }
		T getSecond() { return second; }
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	private ArrayList<BigInteger> primes = new ArrayList<BigInteger>(0);
	private ArrayList<Pair<BigInteger>> pairs = new ArrayList<Pair<BigInteger>>(0);
	private ArrayList<Pair<BigInteger>> hexagonPairs = new ArrayList<Pair<BigInteger>>(0);
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		boolean duplicates = false;
		for(int i = 0; i < primes.size(); i++) {
			if(x == primes.get(i))
				duplicates = true;
		}
		if(!duplicates)
			primes.add(x);
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		for(int i = 0; i < primes.size(); i++)
			System.out.println(primes.get(i));
		System.out.println("Total Primes: " + primes.size());
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		for(int i = 0; i < pairs.size(); i++)
			System.out.println(pairs.get(i).getFirst() + ", " + pairs.get(i).getSecond());
		System.out.println("Total Pairs: " + pairs.size());
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
		for(int i = 0; i < hexagonPairs.size(); i++) {
			System.out.print(hexagonPairs.get(i).getFirst().subtract(BigInteger.valueOf(1)) + ", " 
					+ hexagonPairs.get(i).getFirst().add(BigInteger.valueOf(1)) + " and ");
			System.out.print(hexagonPairs.get(i).getSecond().subtract(BigInteger.valueOf(1)) + ", " 
					+ hexagonPairs.get(i).getSecond().add(BigInteger.valueOf(1)) + " separated by ");
			System.out.println(hexagonPairs.get(i).getFirst() + ", " + hexagonPairs.get(i).getSecond());
		}
		System.out.println("Total Hexes: " + hexagonPairs.size());
	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		int i = 0;
		BigInteger prime = BigInteger.valueOf(2); 
		while(i < count) {
			if(isPrime(prime)) {
				addPrime(prime);
				i++;
			}
			prime = prime.add(BigInteger.valueOf(1));
		}
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		for(int i = 0; i < primes.size()-2; i++) {
			if(isPrime(primes.get(i).add(BigInteger.valueOf(2))))
				pairs.add(new Pair<BigInteger>(primes.get(i), primes.get(i).add(BigInteger.valueOf(2))));
		}
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		for(int i = 0; i < pairs.size(); i++) {
			BigInteger a = middleOfPair(pairs.get(i));
			BigInteger b = a.multiply(BigInteger.valueOf(2));
			if(isInMiddle(b))
				hexagonPairs.add(new Pair<BigInteger>(a, b));
		}
	}
	
	public boolean isPrime(BigInteger n)
	{
		if(n.compareTo(BigInteger.valueOf(1)) == -1 || n.compareTo(BigInteger.valueOf(1)) == 0) { return false; }
		for(int i = 2; i < n.intValue(); i++) {
			if(n.mod(BigInteger.valueOf(i)).equals(BigInteger.valueOf(0))) 
				return false;
		}
		return true;
	}
	
	public BigInteger middleOfPair(Pair<BigInteger> pair) {
		return pair.getFirst().add(BigInteger.valueOf(1));
	}
	
	public boolean isInMiddle(BigInteger x) {
		for(int i = 0; i < pairs.size(); i++) {
			if(pairs.get(i).getFirst().add(BigInteger.valueOf(1)).equals(x))
				return true;
		}
		return false;
	}
	
}
