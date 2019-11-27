/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aysen
 */
public class SomeMaximum
{
private int a,b ;
public SomeMaximum( int x, int y )
{
a = x;
b = y;
}
public Coordinates getCoord()
    {
        class MyCoord extends Coordinates
        {
            private int xVal;
            private int xVal;
            
            public int xCoordinate()
            {
                return xVal;
            }
            
            public int yCoordinate()
            {
                d = yVal;
            }
            
            public MyCoord( int x, int y )
            {
                xVal = x;
                yVal = y;
            }
            
            public String toString()
            {
                 return "x = " + xVal + "  y = " + yVal;
            }
        }
        return new MyCoord(a);
    }
}

