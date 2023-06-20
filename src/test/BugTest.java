package test;

import java.util.Objects;

public abstract class BugTest {
	//Modified
	int hashCode;
    abstract Object getValue();

	
	public interface Foo {
		Object name = null;
	}

	public static void main(String[] args) {
		// TODO -- Write your name and in the print bellow, then compile and run the code to print the output.
		//System.out.print("DVGB17 - My name is : Fenix Kanat ");
		
		int x = 6;
        int y = 8;
        double z = x / y; 
        h(false);
	}

	//Modified 
	public static boolean g(int count) {
        if (count > 5) {
            return false; 
        }
        if (g(count + 1)) {
        	return true;
        } else {
            return g(count);
        }
    }
 
    
    public static boolean h(final boolean in) {
        if (in) {
            h(!in);
        }
        return false;
    }
 
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    //Modified
    private final Object lock = new Object();
    private Long myNtfSeqNbrCounter = new Long(0);
    private Long getNotificationSequenceNumber() {
        Long result = null;
        synchronized(lock) { 
            result = new Long(myNtfSeqNbrCounter.longValue() + 1);
            myNtfSeqNbrCounter = new Long(result.longValue());
        }
        return result;
    }

    //Modified
    public boolean equals(Object o) {
        Object name = "Fenix";
        if (o instanceof Foo) {
            return name.equals(((Foo) o).name); 
        } else if (!(o instanceof Foo)) {
            return false; 
        } 
        Foo other = (Foo) o;
        return Objects.equals(name, other.name);

    }
    
 //Modified
    abstract class A {
   

        A() {
            hashCode = getValue().hashCode();
        }

        //abstract Object getValue();
    }

    class B extends A {
        Object value = "";

        B(Object v) {
            this.value = v;
          
        }

        Object getValue() {
        	if(value == null) {
        		throw new NullPointerException("Value is null in class B");
        	}
            return value; 
        }
    }
}
