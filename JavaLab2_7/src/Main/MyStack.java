package Main;

//Реализовать класс-стек, реализующий методы добавления 
//элементов, извлечения и очистки.

class MyStack {
	private int top;
	private Object[] arrStack;
    private int maxSize;
 
    public MyStack(int max) {
        this.maxSize = max;
        arrStack = new Object[maxSize];
        top = -1;
    }
    
    public void push(Object number)
    {
    	arrStack[++top] = number;
    }
    
    public Object pop()
    {
    	return arrStack[top--];
    }
    
    public void clear()
    {
    	for(int i=0; i<arrStack.length; i++)
    	{
    		arrStack[i] = 0;
    	}
    	
    	top = 0;
    }
}