import java.util.ArrayList;

public class ArrayListStack<E>
{

    ArrayList<E> arrayListStack;
    public ArrayListStack(ArrayList<E> passedList)
    {
        arrayListStack = new ArrayList<E>();
        arrayListStack = passedList;
    }
    public ArrayListStack()
    {
        arrayListStack = new ArrayList<E>();
    }
    public boolean empty()
    {
        return peek() == null;
    }
    public E peek()
    {
        return arrayListStack.get(arrayListStack.size()-1);
    }
    public void push(E item)
    {
        arrayListStack.add(item);
    }
    public E pop()
    {
        E temp = arrayListStack.get(arrayListStack.size()-1);
        arrayListStack.remove(arrayListStack.size()-1);
        return temp;
    }
    public int search(Object o)
    {
        if(arrayListStack.contains(o))
        {
            return arrayListStack.indexOf(o);
        }
        else
        {
            return -1;
        }
    }
    public int getSize()
    {
        return arrayListStack.size();
    }

}
