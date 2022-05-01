public class CircularArrayQueue<E>
{
    private Object[] circularArray;
    private int mStart;
    private int mEnd;
    private int size;
    private final int DEFAULT_SIZE = 10;
    public CircularArrayQueue()
    {
        mStart = 0;
        mEnd = 0;
        size = 0;
        circularArray = new Object[DEFAULT_SIZE];
    }
    public CircularArrayQueue(E[] passedArray)
    {
        mStart = 0;
        mEnd = 0;
        size = passedArray.length;
        circularArray = new Object[size];
        for(int i = 0; i < size; i++)
        {
            circularArray[i] = passedArray[i];
        }
        mEnd = size-1;
    }
    public boolean add(E e)
    {
        if(e == null)
        {
            return false;

        }
        if(size == circularArray.length)
        {
           expandCapacity();
        }
        if(mEnd != (circularArray.length-1))
        {
            mEnd++;
            circularArray[mEnd] = e;
            size++;
            return true;
        }
        return false;
    }
    private void expandCapacity()
    {
        Object[] newArray = new Object[(size * 2)];
        for(int i = mStart; i<size-mStart; i++)
        {
            newArray[i] = circularArray[i];
        }
        if(mEnd < mStart)
        {
            for (int j = 0; j < mEnd; j++) {
                newArray[j] = circularArray[j];
            }
        }
        circularArray = newArray;
    }
    public E element()
    {
        return (E)circularArray[mStart];
    }
    public E peek()
    {
        if(circularArray[mStart] != null) {
            return (E)circularArray[mStart];
        }
        else
        {
            return null;
        }
    }
    public E poll()
    {
        if(circularArray[mStart] != null)
        {
            E temp = (E)circularArray[mStart];
            circularArray[mStart] = null;
            if(circularArray[mStart++]!=null)
            {
                mStart++;
            }
            size--;
            return temp;
        }
        else
        {
            return null;
        }
    }
    public E remove()
    {
        E temp = (E)circularArray[mStart];
        circularArray[mStart] = null;
        if(circularArray[mStart++]!=null)
        {
            mStart++;
        }
        size--;
        return temp;

    }
}
