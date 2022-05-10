package org.biteleva.L4Triangle;


public class Triangle {
   public static void main(String[] args) throws NegativeLengthException, IncompatibleLengthException {

        System.out.println(triangleSquare (10,8,12)); }




    public static double triangleSquare (int a, int b, int c)  throws NegativeLengthException, IncompatibleLengthException
    {
        if(a<0 || b<0|| c<0) throw new NegativeLengthException ("Значение длины одной или более сторон отрицательное");
        if (a+b<c|| a+c<b || b+c<a ) throw new IncompatibleLengthException("Сумма длин двух сторон меньше длины третьей");

        double p =(a+b+c)/2;

        double result = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        double abrResult = Math.round(result * 100) / 100.00;

        return abrResult;}
}

