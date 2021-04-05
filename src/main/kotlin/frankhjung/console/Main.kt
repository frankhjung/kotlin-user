package frankhjung.console

import kotlin.system.exitProcess

/**
 * Show command line arguments or show usage message.
 * @param args arguments to show
 */
fun showArgs(args: Array<String>) {
    when (args.size) {
        0 -> {
            println("Usage: main arg1 arg2 arg3")
            exitProcess(1)
        }
        else -> {
            println("Got arguments:")
            println(processArgs(args.toList()))
            exitProcess(0)
        }
    }
}

/**
 * Process command line arguments.
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
fun processArgs(args: List<String>): String {
    return args.joinToString()
}

/**
 * Echo arguments to console.
 * @param args command line arguments
 */
fun main(args: Array<String>) {
    showArgs(args)
}
