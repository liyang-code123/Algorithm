package javaregular;

import java.util.LinkedList;

public class SortArayThreeStacks {
	public static void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<>();
		LinkedList<Integer> s3 = new LinkedList<>();
		sort(s1, s2, s3, s1.size());
	}
	
	private static void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
		// base case;
		if (length <=1) {
			return;
		}
		int mid1 = length/2;
		int mid2 = length - length/2;
		for(int i = 0; i < mid1; i++) {
			s2.offerFirst(s1.pollFirst());
		}
		sort(s2, s3, s1, mid1);
		sort(s1, s3, s2, mid2);
		
		int i = 0;
		int j = 0;
		while (i < mid1 & j < mid2) {
			if (s2.peekFirst() < s1.peekFirst()) {
				s3.offerFirst(s2.pollFirst());
				i++;
			} else {
				s3.offerFirst(s1.pollFirst());
				j++;
			}
		}
		while (i < mid1) {
			s3.offerFirst(s2.pollFirst());
			i++;
		}
		while (j < mid2) {
			s3.offerFirst(s1.pollFirst());
			j++;
		}
		
		for (int index = 0; index < length; index++) {
			s1.offerFirst(s3.pollFirst());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3,1,2,4 
		 LinkedList<Integer> list= new LinkedList<>();
		 list.add(3);
		 list.add(1);
		 list.add(2);
		 list.add(4);
		 sort(list);
         
	}

}
