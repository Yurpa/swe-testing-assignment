# Testing

## Testing Strategy
The application has two clearly distinct layers -- a pure-logic layer (**CalcLogic**) and a UI-wiring layer (**Calculator_main**). Because **CalcLogic** contains no Swing dependencies, it can be tested in complete isolation with plain unit tests that run in milliseconds, while the performance of the **Calculator_main** can only be reasonably tested with the tests that actually drive the UI.
Therefore, the overall testing consists of two types of tests **Unit tests** and **Integration tests**. 

For the **Unit tests**, Each arithmetic method received at least one positive-path case and one case that probes a known edge - negative operands, zero divisor, non-numeric operands.

For the **Integration tests**, the strategy was to choose scenarios that validatethe two most structurally important UI contracts: that the full input-operation-display pipeline produces the correct output, and that the reset mechanism ((C) button) returns every observable field to a known default. These tests in tandemn with **Unit tests** cover the overall functional requirements for this project exaustively.

Areas such as visual layout, button colours, window-close behaviour, and performance were deliberately left out of scope. These either fall outside the definition of functional correctness (visual styling),  or are simply not applicable to a single-user, instant-arithmetic desktop tool (performance and concurrency).


## Testing (Lecture) Concepts

### Testing Pyramid
Testing suite employs the Pyramid concept by establishing a wider base of Unit tests (10) and the smaller group of integration tests (2), which accurately portrays the structure of the pyramid (at least it's lower and middle layers, mostly due to the app's simplicity) and its core principles, as the extensive coverage of the Unit tests allows for the fewer amounts of integration tests,latter being 1000 times slower than the former.  


### Black-Box VS White-Box testing
The unit tests adopt a black-box approach. They only care about the correlation of specific input to specific output, and therefore no matter how much the internal code would change, as long the main functions would correctly transform input into output, the unit tests would continue to pass. 

The integration tests, by contrast, are inherently white-box. The tester must know application's internal structure in order to correctly assign Swing components, the exact default strings the clear button is expected to restore and etc, in order to write the tests. And while some might argue that the integral tests were created to examine the  most default usage of the app, through a simulated environment, the fact that the most of the used information in the tests is not accessible to a normal user. 
The tests are therefore examining the internal correspondence between the UI layer and the arithmetic layer, which is a white-bos testing.


### Functional vs Non-Functional Testing
All 12 tests in this suite are functional tests. They verify that the system does what it is specified to do.

Non-functional testing was intentionally omitted (look at **Testing strategy** for further explanation).

### Regression Testing
Due to the way that the arithmetic logic and UI are separeted, as well as the ability to run the testing through a singular command, it can be said that the current project could support regression testing. As beforementioned characteristics allow for the quick and comprehensive testing for whenever the new features are introduced.



## Test Results Summary

| # | Test Name | Class / Group | Type | Status |
|---|------|------|------|------|
| 1 | testAddPositiveIntegers | UnitTests | Unit | Pass |
| 2 | testAddNegativeNumbers | UnitTests | Unit | Pass |
| 3 | testSubtractPositiveResult | UnitTests | Unit | Pass |
| 4 | testSubtractNegativeResult | UnitTests | Unit | Pass |
| 5 | testMultiplyStandard | UnitTests | Unit | Pass |
| 6 | testMultiplyByZero | UnitTests | Unit | Pass |
| 7 | testDivideDecimalResult | UnitTests | Unit | Pass |
| 8 | testDivideByZeroThrows | UnitTests | Unit | Pass |
| 9 | testAddDecimalInputs | UnitTests | Unit | Pass |
| 10 | testParseNonNumericThrows | UnitTests | Unit | Pass |
| 11 | testFullAddInteraction (IT-01) | IntegrationTests | Integration | Pass |
| 12 | testClearResetsDisplay (IT-02) | IntegrationTests | Integration | Pass |



