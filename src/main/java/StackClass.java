public class StackClass {

    private StackNode top;

    public StackClass()
    {
        top = null;
    }

    public void push(int dataValue)
    {
        StackNode new_top = new StackNode( dataValue, top );
        top = new_top;
    }

    public int peek()
    {
        if (isEmpty())
            throw new RuntimeException("Attempted to peek at an empty stack");

        return top.getData();
    }

    public int pop()
    {
        int value = peek();
        top = top.getNext();
        return value;
    }

    public boolean isEmpty()
    {
        return ( top == null );
    }

    public void clear()
    {
        top = null;
    }

    public String toString()
    {
        StackNode current = top;
        String result = "";

        if ( current == null )
        {
            result = "[Empty Stack}";
        }
        else
        {
            while (current != null)
            {
                result = result + "[" + current.data + "] ";
                current = current.getNext();
            }
        }

        return result;
    }


    private class StackNode {
        private StackNode next;
        private int data;

        //CONSTRUCTORS
        public StackNode(int dataValue, StackNode nextNode)
        {
            next = nextNode;
            data = dataValue;
        }

        // GETTERS/SETTERS FOR NEXT AND DATA
        public StackNode getNext()
        {
            return next;
        }

        public int getData()
        {
            return data;
        }
    }
}
