package com.ozman.testingapplication

object HomeWork {

    /***
     * Returns the n-th fibonacci number
     * They are defind like this:
     * fab(0)=0
     * fab(1)=1
     * fab(n)= fab(n-2) +fab(n-1)
     * **/

    fun fab(n: Int): Long {
        if (n == 0 || n == 1)
            return n.toLong()
        var a = 0L
        var b = 1L
        var c = 1L
        (1..<n).forEach { _ ->
            c = a + b
            a = b
            b = c
        }
        return c
    }


    /**
     * checks if the braces are set correctly
     * e.g   "(a * b))  should return false
     *  care about order
     **/

    fun checkBraces(string: String): Boolean {
        return string.count { it == '(' } == string.count { it == ')' }
    }

}