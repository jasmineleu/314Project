public class Project1 {
	public static void main(String[] args) 
	{
		// Instantiate Primes Class
		PrimesOperations testOne = new PrimesOperations();
		
		// Generate Primes and test.
		testOne.generatePrimes(21);
		testOne.printPrimes();
		
		// Generate and test Twin Primes
		PrimesOperations testTwo = new PrimesOperations();
		testTwo.generatePrimes(100);
		testTwo.generateTwinPrimes();
		testTwo.printTwins();
		
		// Generate and test Hexagonal crosses
		PrimesOperations testThree = new PrimesOperations();
		testThree.generatePrimes(15000);
		testThree.generateTwinPrimes();
		testThree.generateHexPrimes();
		testThree.printHexes();
		
	}
}
