/**
 * @author Xiaolong Meng
 * This class contains the solution for Worksheet1
 */
 public class Worksheet1 {
	// Exercise 1

	 static int power(int m, int n) {
		if(m==0 && n!=0) return 0;
		else if (m==0 && n==0) return 1;
		else if(n==0) return 1;
		else return m*power(m,n-1);
	}

	 static int fastPower(int m, int n) {
		if(n==0) return 1;
		else if(n%2!=0) return m*fastPower(m,n-1);
		else return fastPower(m*m,n/2);
	}

	// Exercise 2

	 static List<Integer> negateAll(List<Integer> a) {
		if(a.isEmpty()) return new List<>();
		else {
			return new List<>(-a.getHead(),negateAll(a.getTail()));
		}
	}

	// Exercise 3

	 static int find(int x, List<Integer> a) {
		if(a.isEmpty()) throw new IllegalArgumentException();
		else if(a.getHead()==x) return 0;
		else return 1+find(x,a.getTail());
	}

	// Exercise 4

	 static boolean allPositive(List<Integer> a) {
		if(a.isEmpty()) return true;
		else return a.getHead()>=0 & allPositive(a.getTail());
	}

	// Exercise 5

	 static List<Integer> positives(List<Integer> a) {
		if(a.isEmpty()) return new List<>();
		else if(a.getHead()>0) return new List<>(a.getHead(),positives(a.getTail()));
		else return positives(a.getTail());
	}

	// Exercise 6

	 static boolean sorted(List<Integer> a) {
		if(a.getTail().isEmpty()) return true;
		else return a.getHead()<=a.getTail().getHead() & sorted(a.getTail());
	}

	// Exercise 7

	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if(a.isEmpty()) return b;
		else if (b.isEmpty()) return a;
		else {
			if(a.getHead()<=b.getHead()) return new List<>(a.getHead(),merge(a.getTail(),b));
			else return new List<>(b.getHead(),merge(a,b.getTail()));
		}
	}

	// Exercise 8

	static List<Integer> removeDuplicates(List<Integer> a) {
		if(a.getTail().isEmpty()) return new List<>(a.getHead(),a.getTail());
		else if(a.getHead()==a.getTail().getHead()) return removeDuplicates(a.getTail());
		else return new List<>(a.getHead(),removeDuplicates(a.getTail()));
	}
	
	public static void main(String[] args) {
		//System.out.println(power(2,7));
		//System.out.println(fastPower(2,7));
		List<Integer> list1 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		List<Integer> list2 = new List<>(5,new List<>(7,new List<>(8,new List<>(9,new List<>()))));
		System.out.println(find(3,list1));
	}
}
