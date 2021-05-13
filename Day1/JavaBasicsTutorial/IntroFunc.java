
public class IntroFunc {

public static void main()
{
int length=5;
int breadth=10;
// length and breadth are actual parameters
int add =sum(length,breadth);
System.out.println(add);
}
// a and b are formal parameters 
public static int sum(int a, int b)
{
return (a+b);
}
}
