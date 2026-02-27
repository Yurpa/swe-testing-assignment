import javax.swing.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class CalcTest {

    // UNIT TESTS

    @Nested
    @DisplayName("Unit Tests — CalcLogic")
    class UnitTests {

        private static final double DELTA = 1e-9; // tolerance for floating-point comparisons

        // ADD

        @Test
        @DisplayName("ADD: 5 + 3 = 8")
        void testAddPositiveIntegers() {
            assertEquals(8.0, CalcLogic.add(5, 3), DELTA);
        }

        @Test
        @DisplayName("ADD: negative numbers — (-4) + (-6) = -10")
        void testAddNegativeNumbers() {
            assertEquals(-10.0, CalcLogic.add(-4, -6), DELTA);
        }

        // SUB

        @Test
        @DisplayName("SUB: 10 - 4 = 6")
        void testSubtractPositiveResult() {
            assertEquals(6.0, CalcLogic.subtract(10, 4), DELTA);
        }

        @Test
        @DisplayName("SUB: 3 - 7 = -4  (negative result)")
        void testSubtractNegativeResult() {
            assertEquals(-4.0, CalcLogic.subtract(3, 7), DELTA);
        }

        // MUL
        @Test
        @DisplayName("MUL: 6 × 7 = 42")
        void testMultiplyStandard() {
            assertEquals(42.0, CalcLogic.multiply(6, 7), DELTA);
        }

        @Test
        @DisplayName("MUL: anything × 0 = 0")
        void testMultiplyByZero() {
            assertEquals(0.0, CalcLogic.multiply(99, 0), DELTA);
        }

        // DIV

        @Test
        @DisplayName("DIV: 10 ÷ 4 = 2.5  (decimal result)")
        void testDivideDecimalResult() {
            assertEquals(2.5, CalcLogic.divide(10, 4), DELTA);
        }

        @Test
        @DisplayName("DIV: division by zero throws ArithmeticException")
        void testDivideByZeroThrows() {
            ArithmeticException ex = assertThrows(
                    ArithmeticException.class,
                    () -> CalcLogic.divide(5, 0)
            );
            assertTrue(ex.getMessage().contains("zero"),
                    "Exception message should mention 'zero'");
        }
        // EDGE CASES

        @Test
        @DisplayName("EDGE: decimal inputs — 1.5 + 2.5 = 4.0")
        void testAddDecimalInputs() {
            assertEquals(4.0, CalcLogic.add(1.5, 2.5), DELTA);
        }

        @Test
        @DisplayName("EDGE: non-numeric string throws NumberFormatException")
        void testParseNonNumericThrows() {
            assertThrows(
                    NumberFormatException.class,
                    () -> CalcLogic.parse("abc")
            );
        }
    }

    // INTEGRATION TESTS
    @Nested
    @DisplayName("Integration Tests — UI + CalculatorLogic")
    class IntegrationTests {

        private FrameFixture window;

        @BeforeEach
        void setUp() {
            // Build the frame on the Swing EDT to avoid threading issues
            JFrame frame = GuiActionRunner.execute(Calculator_main::buildFrame);
            window = new FrameFixture(frame);
            window.show(); // makes the frame visible and starts the robot
        }

        @AfterEach
        void tearDown() {
            window.cleanUp(); // disposes the frame and releases the robot
        }

        @Test
        @DisplayName("IT-01: Enter 5, press ADD, enter 3, press Calculate -> result is 8.0")
        void testFullAddInteraction() {
            GuiActionRunner.execute(() -> {
                window.textBox("num1").target().setText("5");
                window.button("plus").target().doClick();   // reads num1="5", num2="0" -> res=5
                window.textBox("num2").target().setText("3");
                window.button("plus").target().doClick();   // reads num1="5", num2="3" -> res=8
                window.button("calc").target().doClick();   // result.setText("8.0")
            });

            assertThat(window.textBox("result").text()).isEqualTo("8.0");
        }

        @Test
        @DisplayName("IT-02: After a DIV calculation, pressing (C) resets all fields to defaults")
        void testClearResetsDisplay() {
            GuiActionRunner.execute(() -> {
                window.textBox("num1").target().setText("10");
                window.button("div").target().doClick();    // reads num1="10", num2="0"
                window.textBox("num2").target().setText("2");
                window.button("div").target().doClick();    // reads num1="10", num2="2" -> res=5
                window.button("calc").target().doClick();   // result.setText("5.0")
            });

            // Verify the result is shown before clearing
            assertThat(window.textBox("result").text()).isEqualTo("5.0");

            // Press Clear on the EDT as well
            GuiActionRunner.execute(() -> window.button("clear").target().doClick());

            // Assert all fields are back to their initial defaults
            assertThat(window.textBox("num1").text()).isEqualTo("0");
            assertThat(window.textBox("num2").text()).isEqualTo("0");
            assertThat(window.textBox("result").text()).isEqualTo("No answer yet!");
            assertThat(window.label("end").text()).isEqualTo("Choose operation!");
        }
    }
}