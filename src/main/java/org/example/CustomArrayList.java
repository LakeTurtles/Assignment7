package org.example;


public class CustomArrayList<T> implements CustomList<T>{
    Object[] data = new Object[10];
    Integer size = 0;

    @Override
    public boolean add(T item) {
      if (size == data.length){
          data = doubleArray();
      }
      data[size] = item;
      size++;
      return true;
    }

    @Override
    public boolean add(int index, T item){
        if (index > data.length) {
            throw new IndexOutOfBoundsException();
            }
        if (size == data.length) {
                data = doubleArray();
            }

        for (int i = size-1; i >= index; i--) {
                data[i+1] = data[i];
            }
            data[index] = item;
            size++;
            return true;
        }


    private Object[] doubleArray(){
        Object[] newArray = new Object[size*2];
        for (int i=0; i<size; i++) {
            newArray[i] = data[i];
        }
        return newArray;

    }

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public T get(int index) {
        if( index > data.length) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }




    public T remove(int index) {
        T indexToRemove = (T)data[index];
        Object[] newArray = new Object[data.length - 1];
        for (int i = index; i<size-1; i++) {
                data[i] = data[i+1];
            }
            size--;
            for (int i = 0; i < data.length-1; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        return indexToRemove;
    }


    public T removeIndex(int index){
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedItem = (T) data[index];

        for (int i = index; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        return removedItem;
    }




    public T removeElement(T value) {
        T valueToRemove = null;
        int indexToRemove = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value)) {
                indexToRemove = i;
                valueToRemove = (T)data[i];
                break;
            }
        }

        Object[] newArray = new Object[data.length - 1];

        for (int i = indexToRemove; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size--;

        for (int i = 0; i < data.length-1; i++) {
            newArray[i] = data[i];
        }

        data = newArray;


        return valueToRemove;
    }





}
