package com.servlet;

public class MainClass {

    public static void main(String args[]) {

      Thread t = Thread.currentThread();
      t.setName("My Thread");

      t.setPriority(1);

      System.out.println("current thread: " + t);

      int active = Thread.activeCount();
      System.out.println("currently active threads: " + active);
      Thread all[] = new Thread[active];
      Thread.enumerate(all);

      for (int i = 0; i < active; i++) {
         System.out.println(i + ": " + all[i]);
      }
   }
}