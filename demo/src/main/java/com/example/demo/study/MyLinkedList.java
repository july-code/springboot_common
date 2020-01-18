package com.example.demo.study;

/**
 * @author zy
 */
public class MyLinkedList<E> {
    Node<E> first;
    Node<E> last;

    int size;

    public void add(E element){
        Node<E> node = new Node<E>(element);

        if (first == null){
            first = node;
            last = node;
        }else {
            node.prev = last;
            node.next = null;
            last.next = node;
            last = node;
        }

        size++;
    }

    public E get(int index){
        checkRange(index);
        Node<E> node  = null;
        if (index < (size>>1)){
            node = first;
            while (index != 0){
                node = node.next;
                index--;
            }
        }else {
            node = last;
            int temp = size-index-1;
            while (temp != 0){
                node = node.prev;
                temp--;
            }
        }
        return node.element;
    }

    public void remove(E element){
        Node<E> node = first;
        while (size > 0){
            if (node.element != element){
                node = node.next;
                size--;
            }else {
                if (node.prev == null){
                    if (node.next != null){
                        first = node.next;
                        node.next.prev = null;
                        return;
                    }
                    first = node.next;
                    return;
                }
                if (node.next == null){
                    last = node.prev;
                    node.prev.next = null;
                    return;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return;
            }
        }
        throw new RuntimeException("该元素不存在！");
    }

    public void remove(int index){
        checkRange(index);
        Node<E> node  = null;
        if (index == 0){
            node = first;
            if (node.next != null){
                first = node.next;
                node.next.prev = null;
                return;
            }
            first = node.next;
            return;
        }
        if (index == size-1){
            node = last;
            last = node.prev;
            node.prev.next = null;
            return;
        }
        if (index < (size>>1)){
            node = first;
            while (index != 0){
                node = node.next;
                index--;
                if (index==0){
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    return;
                }
            }
        }else {
            node = last;
            int temp = size-index-1;
            while (temp != 0){
                node = node.prev;
                temp--;
                if (temp == 0){
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    return;
                }
            }
        }
    }

    public void checkRange(int index){
        if (index >= size  || index <0){
            throw new RuntimeException("Index is invalid ！");
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> temp = first;
        while (temp != null){
            stringBuilder.append(temp.element+",");
            temp = temp.next;
        }
        if (stringBuilder.length() == 1){
            return "[]";
        }
        stringBuilder.setCharAt(stringBuilder.length()-1, ']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        linkedList.add("g");
        linkedList.add("h");
        linkedList.add("i");
        linkedList.add("j");
        System.out.println("原链表："+linkedList.toString());
//        System.out.println(linkedList.get(1));
        linkedList.remove(9);
        System.out.println("删除后："+linkedList.toString());
    }

}

class Node<E>{
    Node prev;
    Node next;
    E element;

    public Node(E element) {
        this.element = element;
    }
}
