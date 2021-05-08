Feature: To test the excel value functionality

  Scenario:

  Given user launched the url
    When user enters the below values
      | input    | Values        |
      | value1   | $122,364.24   |
      | value2   | $599.00       |
      | value3   | $850,139.99   |
      | value4   | $23,329.50    |
      | value5   | $566.27       |
      | TotalBlc | $1,000,000.00 |
    Then the right count of values should appear on the screen
    And all the values on the screen should be greater than zero
    And the total balance should be correct
    And values should be formatted as currency
    And total value amount should match sum of all the values



