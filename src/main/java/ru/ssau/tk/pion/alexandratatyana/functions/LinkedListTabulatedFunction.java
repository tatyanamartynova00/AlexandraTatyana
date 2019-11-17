package ru.ssau.tk.pion.alexandratatyana.functions;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    private Node head;
    private Node last;
    private int count;
    private static class Node{
        Node next;
        Node prev;
        double x;
        double y;
    }

    private void addNode(double x, double y){
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        if (head==null){
            head=newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
            last = newNode;
        }else{
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;
            last = newNode;
        }
        count ++;
    }
    public LinkedListTabulatedFunction(double[] xValues, double[] yValues){ //нужно ли добавить throws?
        if (xValues.length < 2) {
            throw new IllegalArgumentException("length is less than acceptable");
        }
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }
    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("length is less than acceptable");
        }
        double a; //переменная для изменения
        if (xFrom > xTo) {
            a = xFrom;
            xFrom = xTo;
            xTo = a;
        }
        double step = (xTo - xFrom) / (count - 1);
        if (xFrom != xTo) {
            for (int i = 0; i < count; i++) {
                addNode(xFrom + step * i, source.apply(xFrom + step * i));
            }
        } else {
            for (int i = 0; i < count; i++) {
                addNode(xFrom, source.apply(xFrom));
            }
        }
    }
    public int getCount() {
        return count;
    }

    public double leftBound() {
        return head.x;
    }

    public double rightBound() {
        return last.x;
    }

    private Node getNode(int index){
        Node required = head;
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            required = required.next;
        }
        return required;
    }
    public double getX(int index) {
        return getNode(index).x;
    }

    public double getY(int index) {
        return getNode(index).y;
    }

    public void setY(int index, double y) {
        getNode(index).y = y;
    }
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (x == this.getX(i)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (y == this.getY(i)) {
                return i;
            }
        }
        return -1;
    }
    public int floorIndexOfX(double x) throws IllegalArgumentException {
        if (x < head.x) {
            throw new IllegalArgumentException();
        }
        if (x > head.prev.x) {
            return count;
        }
        for (int i = 1; i < count; i++) {
            if (x < getX(i)) {
                return i - 1;
            }
        }
        return count;
    }
    @Override
    protected double interpolate(double x, int floorIndex) {
        Node left = getNode(floorIndex);
        Node right = left.next;
        return super.interpolate(x, left.x, right.x, left.y, right.y);
    }

    @Override
    protected double extrapolateRight(double x) {
        Node left = head.prev.prev;
        return super.interpolate(x, left.x, head.prev.x, left.y, head.prev.y);
    }

    @Override
    protected double extrapolateLeft(double x) {
        Node right = head.next;
        return super.interpolate(x, head.x, right.x, head.y, right.y);
    }
    public Iteratable<Point> iterator() {
        var iterator = new Iterator<Point>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                if (node == null) {
                    return false;
                }
                return true;
            }

            @Override
            public Point next() {
                if (hasNext()) {
                    Point point = new Point(node.x, node.y);
                    node = node.next;
                    if (node == head) {
                        node = null;
                    }
                    return point;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return iterator;
    }
}
