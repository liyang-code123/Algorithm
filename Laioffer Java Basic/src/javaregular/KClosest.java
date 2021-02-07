package javaregular;

public class KClosest {
	public int kth(int[] a, int[] b, int k) {
		return kth(a, 0, b, 0, k);
	}
	
	private int kth(int[] a, int aleft, int b[], int bleft, int k) {
		// base case
		if (aleft >= a.length) {
			return b[bleft + k - 1];
		}
		if (bleft >= b.length) {
			return a[aleft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aleft], b[bleft]);
		}
		
		// recursion rules
		int amid = aleft + k / 2 - 1;
		int bmid = bleft + k / 2 - 1;
		int avalue = amid >= a.length ? Integer.MAX_VALUE : a[amid];
		int bvalue = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
		if (avalue <= bvalue) {
			return kth(a, amid + 1, b, bleft, k - k / 2);
		} else {
			return kth( a, aleft, b, bmid + 1, k - k / 2);
		}
	}

}