package Main;

public class Main {
	MyStack s = new MyStack(5);
	
	public static void main(String[] args) {
		MyStack s = new MyStack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(100);
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		s.push(110);
		s.push(120);
		s.clear();
		
		s.push(10);
		System.out.println(s.pop());
		
		s.push("a");
		s.push("b");
		s.push("c");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
    }
}
