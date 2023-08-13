package org.example;

public interface CustomList <T>{


boolean add (T item) throws IndexOutOfBoundsException;

boolean add(int index, T item) throws IndexOutOfBoundsException;

int getSize ();

T get (int index) throws IndexOutOfBoundsException;


T remove(int index) throws IndexOutOfBoundsException;

T removeIndex(int index) throws IndexOutOfBoundsException;

T removeElement(T value) throws IndexOutOfBoundsException;



}
