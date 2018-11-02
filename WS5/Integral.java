import java.util.function.Function;

public class Integral {
	
	public static double integral(Function<Double,Double> f, double a, double b, int n) {
		double step = (b-a)/n;
		double area = 0;
		for (int i = 0; i < n; i++) {
			area += f.apply(a+i*step);
		}
		area *= step;
		return area;
	}
	
	public static Function<Double, Double> f =
			x -> {return x*x*x + x*x + x + 1;};
			
	public static void main(String[] args) {
		System.out.println(integral(f,0,1,1000));
	}
}
