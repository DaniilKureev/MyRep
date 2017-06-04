package ru.spbstu.telematics.java.lab2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OwnList<T> implements List<T>, Iterable<T> {
	
	private final int INIT_SIZE = 16;
	private final int CUT_RATE = 4;
	private T [] array;
	private int length = 0;
	
	public OwnList()
	{
		array = (T[]) new Object[INIT_SIZE];
	}

	private void resize(int newLength) 
	{
		Object[] newArray = new Object[newLength];
		System.arraycopy(array, 0, newArray, 0, length);
		array = (T[]) newArray;
	}

	@Override
	public T remove(int index)
	{
		for (int i = index; i < length; i++)
			array[i] = array[i + 1];
		array[length] = null;
		length--;
		if (array.length > INIT_SIZE && length < array.length / CUT_RATE)
			resize(array.length / 2);
		return null;
	}

	public int size() 
	{
		return length;
	}

	@Override
	public boolean add(T e)
	{
		if (length == array.length - 1)
			resize(array.length * 2);
		array[length++] = e;
		return true;
	}

	public T get(int index) 
	{
		if(index >= this.length || index < 0){
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
		return array[index];
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < this.length; i++) {
			if (this.get(i).equals(o))
				return true;
		}
		return false;
	}
	
	public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int curIndex;
            @Override
            public boolean hasNext() {
                if(this.curIndex < length){
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                return get(curIndex++);
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
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
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
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
}