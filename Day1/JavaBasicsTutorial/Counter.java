public class Counter {

    int count;

    public Counter() {
        count = 0;
    }

    public void Increment() {
        count++;
    }

    public int GetCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter myCounter = new Counter( );

        System.out.println("mycounter is " + myCounter.GetCount());//0
        myCounter.Increment();
        System.out.println("mycounter is " + myCounter.GetCount());//
    }
}