import java.util.Scanner;

public class Stack<T extends Object> implements StackInterface<T> {

    private StackNode<T> top;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Stack<Character> s = new Stack<Character>();

        System.out.println("Enter an expression to test if balanced:");
        String userInput = scan.next();
        char[] expression = userInput.toCharArray();
        char c;

        for(int i = 0; i < userInput.length(); i++) {

            if(expression[i] == '{' || expression[i] == '(' || expression[i] == '[') {

                c = expression[i];
                s.push(c);
            }

            if(expression[i] == '}' || expression[i] == ')' || expression[i] == ']') {

                if(s.isEmpty()){
                    System.out.println("False");
                    return;
                }

                if(s.peek().equals('(') && expression[i] == ')'){
                    s.pop();
                }
                else if(s.peek().equals('[') && expression[i] == ']'){
                    s.pop();
                }
                else if(s.peek().equals('{') && expression[i] == '}'){
                    s.pop();
                }
            }
        }

        if(s.isEmpty())
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

    }


    public Stack()
    {
        top = null;
    }

    public void push(T dataValue)
    {
        StackNode<T> new_top = new StackNode( dataValue, top );
        top = new_top;

    }

    public T peek()
    {
        if ( isEmpty() )
            throw new RuntimeException("Attempted to peek at an empty stack");
        return top.getData();
    }

    public T pop()
    {
        T value = null;
        try {
            value = peek();
        }
        catch(RuntimeException e)
        {
            throw new RuntimeException("Attempted to pop value off an empty stack");
        }

        if ( value != null )
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

    @Override
    public String toString()
    {
        StackNode current = top;
        String result = "";

        if ( current == null )
        {
            result = "[Empty Stack]";
        }
        else
        {
            while ( current != null )
            {
                result = result + "[" + current.data + "] ";
                current = current.getNext();
            }
        }

        return result;
    }

    public void display()
    {
        String result = this.toString();

        if ( !result.equals("[Empty Stack]") )
            result = "((TOP)) " + result + "((BOTTOM))";

        System.out.print(result);
    }

    // private inner class for node
    private class StackNode<T> {
        private StackNode next;
        private T data;

        // constructor
        public StackNode(T dataValue, StackNode nextNode)
        {
            next = nextNode;
            data = dataValue;
        }

        // get for next and data
        public StackNode getNext()
        {
            return next;
        }

        public T getData()
        {
            return data;

        }
    }
}