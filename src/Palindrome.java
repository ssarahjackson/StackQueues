public class Palindrome<E>
{

    ArrayListStack<E> palinStack;
    public Palindrome(ArrayListStack<E> passedPalindrome)
    {
        palinStack = new ArrayListStack<E>();
        palinStack = passedPalindrome;
    }
    public ArrayListStack<E> splitStack(ArrayListStack<E> s)
    {
        ArrayListStack<E> tempStack = new ArrayListStack<>();
        if(s.getSize()%2==0)
        {
            for(int i = 0; i < (s.getSize()/2); i++)
            {
                tempStack.push(s.pop());
            }
        }
        else
        {
            for(int i = 0; i < (s.getSize()/2); i++)
            {
                tempStack.push(s.pop());
            }
            s.pop();
        }
        return tempStack;
    }
    public boolean isPalindrome()
    {
        ArrayListStack<E> palinStack2 = new ArrayListStack<>();
        palinStack2 = splitStack(palinStack);
        int count = 0;
        for(int i = 0; i < palinStack.getSize(); i++)
        {
            if(palinStack.pop()==palinStack2.pop())
            {
                count++;
            }
        }
        return count == palinStack.getSize();
    }
}
