package com.marlo.console

/**
 * Process command line arguments or show usage message.
 * @param args arguments to process
 */
fun processArgs(args: Array<String>) {
    when (args.size) {
        0 -> println("Usage: main arg1 arg2 arg3")
        else -> showArgs(args)
    }
}

/**
 * Show arguments.
 *
 * Other ways to loop through array lists:
 *
 *     println(args.joinToString(separator = ", ")) // one, two, three
 *     for (arg in args) {                          // onetwothree
 *         print(arg)
 *     }
 *     println(args.map { it })                     // [one, two, three]
 *     args.foreach { print(it) }                   // onetwothree
 *     args.iterator().foreach { print(it) }        // onetwothree
 *
 * @param args arguments to show
 */
fun showArgs(args: Array<String>) {
    println("Got arguments:\n")
    args.forEach { arg -> println(arg) }
}

/**
 * Echo arguments to console.
 * @param args command line arguments
 */
fun main(args: Array<String>) {
    processArgs(args)
}
