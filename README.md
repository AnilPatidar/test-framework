# test-framework

This framework is developed using gradle build tool, it uses Java, Selenium and Cucumber as a core lib, and TestNg to invoke the execution.
Framework supports allur reports and cucumber reports.




To run the project : 

gradle clean webTest -Dbrowser=CHROME

webTest is a gradle task which invokes the execution.

-Dbrowser=CHROME is optional property , here is the possible values : 

        CHROME,
        FIREFOX,
        EDGE,
        IE

To generate Allur report , use following command : 

allure serve reports/tests/allure-results













