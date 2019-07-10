/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Branden Knuth
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1)
			return n;
		if (n == k)
			return 1;
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n < 1000)
			return "" + n;
		int magnitude = (int) Math.log10(n);
		magnitude = (magnitude / 3) * 3;
		int exp = (int) Math.pow(10, magnitude);
		String returnStr = (n / exp) + ",";
		return returnStr + recurseCommas(n % exp);
	}

	private String recurseCommas(int n) {
		if (n < 10)
			return "00" + n;
		if (n < 100)
			return "0" + n;
		if (n < 1000)
			return "" + n;
		int magnitude = (int) Math.log10(n);
		magnitude = (magnitude / 3) * 3;
		int exp = (int) Math.pow(10, magnitude);
		String returnStr = (n / exp) + ",";
		if (returnStr.length() == 2)
			return "00" + returnStr + recurseCommas(n % exp);
		if (returnStr.length() == 3)
			return "0" + returnStr + recurseCommas(n % exp);
		return returnStr + recurseCommas(n % exp);

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index >= len - index - 1)
			return;
		int memo = x[index];
		x[index] = x[len - index - 1];
		x[len - index - 1] = memo;
		reverseArray(x, index + 1, len);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayMaxMin(a, a[0], a[0], 0);
	}

	private int arrayMaxMin(int[] array, int max, int min, int index) {
		if (array[index] > max)
			max = array[index];
		if (array[index] < min)
			min = array[index];
		if (index == array.length - 1)
			return max - min;
		return arrayMaxMin(array, max, min, index + 1);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length == 0)
			return true;
		return recurseSortCheck(nums, 0);
	}

	private boolean recurseSortCheck(int[] nums, int index) {
		if (index == nums.length - 1)
			return true;
		if (nums[index] > nums[index + 1])
			return false;
		return recurseSortCheck(nums, index + 1);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return searchStr(search, strs, 0);
	}

	private boolean searchStr(String search, String[] strs, int index) {
		if (strs[index].contentEquals(search))
			return true;
		if (index == strs.length - 1)
			return false;
		return searchStr(search, strs, index + 1);

	}
}
