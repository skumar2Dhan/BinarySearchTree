/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreedemo;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class BinarySearchTreeDemo
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      IntTree tree = new IntTree( );

      System.out.println("Enter a list of nonnegative integers.");
      System.out.println("Place a negative integer at the end.");
      int next = keyboard.nextInt( );
      while (next >= 0)
      {
          tree.add(next);
          next = keyboard.nextInt( );
      }

      System.out.println("In sorted order (inorder) values are:");
      tree.showElements( );

      System.out.println("\nPost Order values are:");
      tree.postorderElements();

      System.out.println("\nPre Order are:");
      tree.preorderElements();
      
   }
}