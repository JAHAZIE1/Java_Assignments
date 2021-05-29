import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Chess {

	public static abstract class ChessPiece
	{
		private int locX, locY;

		ChessPiece( int x, int y )
		{
			locX = x;
			locY = y;
		}

		int getX()
		{
			return locX;
		}

		int getY()
		{
			return locY;
		}

		abstract boolean canAttack( ChessPiece p );
	}

	public static class King extends ChessPiece
	{
		King( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int queryX = p.getX();
			int queryY = p.getY();
			int difX = Math.abs(super.locX - queryX);
			int difY = Math.abs(super.locY - queryY);
			boolean answer = false;

			if (difX == 0 || difX == 1) {
				if (difY == 0 || difY == 1) {
					answer = true;
				}
			} else {
				answer = false;
			}

			return answer;

		}
	}


	public static class Bishop extends ChessPiece
	{
		Bishop( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int queryX = p.getX();
			int queryY = p.getY();
			int difX = Math.abs(super.locX - queryX);
			int difY = Math.abs(super.locY - queryY);

			if (difY == difX) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class Rook extends ChessPiece
	{
		Rook( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int queryX = p.getX();
			int queryY = p.getY();

			if (super.locX == queryX | super.locY == queryY) {
				return true;
			} else {
				return false;
			}
		}		
	}

	public static class Queen extends ChessPiece
	{
		Queen( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int queryX = p.getX();
			int queryY = p.getY();
			int difX = Math.abs(super.locX - queryX);
			int difY = Math.abs(super.locY - queryY);

			if (super.locX == queryX | super.locY == queryY | difY == difX) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static class Knight extends ChessPiece
	{
		Knight( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int queryX = p.getX();
			int queryY = p.getY();
			int difX = Math.abs(super.locX - queryX);
			int difY = Math.abs(super.locY - queryY);

			if (difY == 2 & difX == 1) {
				return true;
			} else if (difX == 2 & difY == 1) {
				return true;
			} else {
				return false;
			}
		}		
	}


	public static void main(String[] args) { 

		// sample use of the classes
//
//		ChessPiece a = new King(0,0);
//		ChessPiece b = new Queen(1,1);
//		ChessPiece c = new Rook(2,1);
//		ChessPiece d = new Bishop(4,4);
//
//		System.out.println( a.canAttack(b));//true
//		System.out.println( a.canAttack(c));//false
//		System.out.println( a.canAttack(d));//false
//
//		System.out.println( b.canAttack(a));//true
//		System.out.println( b.canAttack(c));//true
//		System.out.println( b.canAttack(d));//true
//
//
//
//		System.out.println( c.canAttack(a));//false
//		System.out.println( c.canAttack(b));//true
//		System.out.println( c.canAttack(d));//false
//
//		System.out.println( d.canAttack(a)); //true
//		System.out.println( d.canAttack(b));// true
//		System.out.println( d.canAttack(c));//false

	}
}
