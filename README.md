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


Cucumber report :

https://reports.cucumber.io/reports/2ef3f393-e9e5-4a1c-af16-160135a0fc36

<h3>
	 
 <img src="https://github.com/AnilPatidar/test-framework/blob/069945b567c0bb1ab894c22cb6b0daa8a1ddc93a/Screenshot%202023-10-22%20at%209.57.40%20PM.png" alt="ATD" width="45%" align="top"></a>

</h3>













