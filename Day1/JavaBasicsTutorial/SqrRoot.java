// Show square roots of 1 to 99 and the rounding error.
class SqrRoot {
public static void main(String args[]) {
double sqrroot, rerr;
for(double num = 1.0; num < 100.0; num++) {
sqrroot = Math.sqrt(num);
System.out.println("Square root of " + num +
" is " + sqrroot);
}
}
}
