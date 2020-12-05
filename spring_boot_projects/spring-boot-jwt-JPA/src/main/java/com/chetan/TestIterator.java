package com.chetan;

import java.util.*;

public class TestIterator {
	
	public static void main(String[] args) throws Exception {
		//my obj[] = new my[1];
		//System.out.println( obj );
		//obj[0] = new my();
		//obj[4] = new my();
		//System.out.println( obj );
		//my obj1 = new my();
		
		//List obj1 = new ArrayList();
		//for(String s: new my())
		/*for(my s: obj )
		{
			for(String s1: new my()) {
				System.out.println(s1);
			}
			System.out.println(s);
		}*/
		
		for(String s1: new my())
		{
			System.out.println(s1);
		}
	}

}

class my implements List<String>
{
	 transient Object[] elementData;
	 private int size;
	 private static final int DEFAULT_CAPACITY = 10;
	 
	 public my()
	 {
		 size = DEFAULT_CAPACITY;
	 }

	@Override
	public Iterator<String> iterator() {
		System.out.println("iter");
		return new myit();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String e) {
		// TODO Auto-generated method stub
		elementData[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String set(int index, String element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

class myit implements Iterator<String>
{
	private boolean ret = true;

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return ret;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		ret= false;
		return "Test";
	}
}


