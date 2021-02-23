package com.monochromecivilians.hashcode2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File


internal class TestKtTest {
    @Test
    fun `run Input A`() {
        val input = File("./src/main/resources/a_example.in").readLines(Charsets.UTF_8)
        assertThat(runInput(input, "A")).isGreaterThan(0)
    }

    @Test
    fun `run Input B`() {
        val input = File("./src/main/resources/b_small.in").readLines(Charsets.UTF_8)
        assertThat(runInput(input, "B")).isGreaterThan(0)
    }

    @Test
    fun `run Input C`() {
        val input = File("./src/main/resources/c_medium.in").readLines(Charsets.UTF_8)
        assertThat(runInput(input, "C")).isGreaterThan(0)
    }


    @Test
    fun `run Input D`() {
        val input = File("./src/main/resources/d_quite_big.in").readLines(Charsets.UTF_8)
        assertThat(runInput(input, "D")).isGreaterThan(0)
    }


    @Test
    fun `run Input E`() {
        val input = File("./src/main/resources/e_also_big.in").readLines(Charsets.UTF_8)
        assertThat(runInput(input, "E")).isGreaterThan(0)
    }
}

