
public class ArraySum {
	public int sumOfArray(Integer[] myArray, int i) {
		int sum = 0;
		sum += rMethod(myArray, i);
		return sum;
	}
	public int rMethod(Integer[] array, int j) {
		if (j < 0) {
			return 0;
		}
		return array[j] + rMethod(array, j - 1) ;
		
	}
}
