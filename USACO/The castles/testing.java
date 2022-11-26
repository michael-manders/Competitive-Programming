import static java.lang.System.*;

class main {
    public static void main(String[] args) {
        out.print(huh(256));
}
    
    public static boolean huh(int n)
{
  for( int i = 2; i < n; i++ )
  {
    if(n % i == 0)
      return false;
  }
  return true;
}
}