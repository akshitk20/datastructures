package com.practice.basics.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int length = 0; //length for user
    private int capacity = 0; //actual length


    public DynamicArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal argument " + capacity);
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        if(index >= length || index < 0) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public void set(int index , T elem){
        if(index >= length || index < 0) throw new ArrayIndexOutOfBoundsException();
        array[index] = elem;
    }

    public void clear(){
        for(int i = 0; i < length ; i++) array[i] = null;
        length = 0;
    }

    public void add(T elem){
        if(length + 1 >= capacity){
            if(capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for(int i = 0 ; i < length ; i++)
                newArray[i] = array[i];

            array = newArray;
        }
        array[length++] = elem;
    }

    public T removeAt(int rmIndex){
        T elem = array[rmIndex];
        T[] newArray = (T[]) new Object[capacity];
        for(int i = 0 ; i < length ; i++){
            if(array[i] == elem)
                continue;
            newArray[i] = array[i];
        }
        capacity = --length;
        return elem;
    }

    public Boolean remove(Object obj){
        int index = indexOf(obj);
        if(index == -1) return false;
        removeAt(index);
        return true;
    }

    private int indexOf(Object obj) {
        for(int i = 0 ; i < length; i++){
            if(obj == null){
                if(array[i] == null)
                    return -1;
            }else if(obj.equals(array[i])) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
