package frankhjung.tests

import frankhjung.console.processArgs
import org.junit.Test
import kotlin.test.assertEquals

class ConsoleTest {
    @Test
    internal fun testProcessArgs() {
        val input = listOf("one", "two", "three")
        val expected = input.joinToString()
        assertEquals(expected, processArgs(input))
    }
}
