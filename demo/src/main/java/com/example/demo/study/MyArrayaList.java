package com.example.demo.study;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyArrayaList<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayaList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public Boolean add(E e) {
        if (size == elementData.length) {
            //扩容
            int newCapacity = elementData.length + (elementData.length >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        elementData[size++] = e;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    public void set(int index, E element) {
        checkIndex(index);
        elementData[index] = element;
    }

    public void remove(int index) {
        checkIndex(index);
        int moved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, moved);
        elementData[--size] = null;
    }

    public boolean remove(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                    elementData[--size] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elementData[i])) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                    elementData[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("Index is invalid ！");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elementData[i] + ",");
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');

        return stringBuilder.toString();
    }

    /**
     * 利用反射机制获取ArrayList容量
     */
    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[]) field.get(arrayList);
            return objects.length;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {

        MyArrayaList<String> myArrayaList = new MyArrayaList<>();
        myArrayaList.add("a");
        myArrayaList.add("b");
        myArrayaList.add("c");
        myArrayaList.add("d");
        myArrayaList.add("e");
        myArrayaList.add("f");
        myArrayaList.add("g");
        myArrayaList.add("h");
        myArrayaList.add("i");
        myArrayaList.add("j");
        myArrayaList.add("k");
        myArrayaList.add("l");
        myArrayaList.add("m");
        System.out.println(myArrayaList.toString());


//        System.out.println(myArrayaList.get(20));
//        myArrayaList.set(2,"asdasda");
//        System.out.println(myArrayaList.get(2));
//        System.out.println(myArrayaList.get(3));
        myArrayaList.remove("e");
        System.out.println(myArrayaList.toString());

        /*List list = new ArrayList(1);
        System.out.println(getArrayListCapacity((ArrayList<?>) list));
        for (int i = 0; i <11 ; i++) {
            list.add(i);
        }
        System.out.println(getArrayListCapacity((ArrayList<?>) list));*/
    }
}
