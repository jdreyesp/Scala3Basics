package com.rockthejvm.part1basics

import scala.annotation.tailrec

object Recursion {

  def main(args: Array[String]): Unit = {
    // println(sumUntil(10))
    // println(sumTail(10))
    // println(sumNumbersBetween(1, 10))
    // println(sumNumbersBetween_v2(1, 10))
    println(fibonacci(0))
    println(isPrime(8))
  }

  // for big numbers, this will stack overflow
  def sumUntil(n: Int): Int = {
    if (n <= 0) 0 else n + sumUntil(n - 1)
  }

  // TAIL recursion: the recursive call is the last operation in the function (here, not the + but the loop function is the last operation)
  // for big numbers, this won't stack overflow
  def sumTail(n: Int): Int = {
    @tailrec
    def loop(x: Int, acc: Int): Int = {
      if (x <= 0) acc else loop(x - 1, acc + x)
    }
    loop(n, 0)
  }

  // sum numbers between a and b
  def sumNumbersBetween(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumNumbersBetween(a + 1, b)
  }

  def sumNumbersBetween_v2(a: Int, b: Int): Int = {
    @tailrec
    def loop(currentNumber: Int, acc: Int): Int = {
      if (currentNumber > b) acc
      else loop(currentNumber + 1, acc + currentNumber)
    }
    loop(a, 0)
  }

  // fibonacci(10) = 10
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTail(i: Int, lastAcc: Int, previousAcc: Int): Int = {
      if (i >= n) lastAcc
      else fibonacciTail(i + 1, lastAcc + previousAcc, lastAcc)
    }

    if (n == 0) 0
    else if (n == 1) 1
    else fibonacciTail(2, 1, 1)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

}
