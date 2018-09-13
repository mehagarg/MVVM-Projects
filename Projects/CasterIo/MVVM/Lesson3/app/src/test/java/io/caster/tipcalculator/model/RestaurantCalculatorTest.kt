package io.caster.tipcalculator.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RestaurantCalculatorTest {
    lateinit var calculator: RestaurantCalculator

    @Before
    fun setup() {
        calculator = RestaurantCalculator()
    }

    @Test
    fun testCalculateTip() {
        val baseTC = TipCalculation(checkAmount = 10.00)
        val testVals = listOf(
            baseTC.copy(tipPct = 25, tipAmount = 2.50, grandTotal = 12.50),
            baseTC.copy(tipPct = 15, tipAmount = 1.50, grandTotal = 11.50),
            baseTC.copy(tipPct = 18, tipAmount = 1.7999999999999998, grandTotal = 11.80)
        )

        testVals.forEach {
            assertEquals(it, calculator.calculateTip(it.checkAmount, it.tipPct))
        }

//        val checkInput = 10.0
//        val tipPctInput = 25

//        val expectedTipResult = TipCalculation(
//            checkAmount = checkInput,
//            tipPct = 25,
//            tipAmount = 2.5,
//            grandTotal = 12.5
//        )
//        assertEquals(expectedTipResult, calculator.calculateTip(checkInput, tipPctInput))
    }
}