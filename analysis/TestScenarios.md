# Test Scenarios

---

### Test Scenario <Template\>

#### Name
>   Insert Name here

#### Scenario
>   Text

#### Result
>   More Text

#### Extensions
>   Even more text

---
<!-- Add Test Scenarios somewhere beneath this-->

### Test Scenario Search For Booking <Mathias\>

#### Name
>   Search For Booking

#### Scenario
>   1. Actor selects to search for booking.
>   2. System asks the actor to enter booking details
>   3. Actor enter New York in the departure airport field, Tokyo in the arrival airport field and COLOMB as the passenger name.
>   4. System searches for all the booking that match the enter booking details.
>   5. System shows an overview of the only one booking that match this details (passenger: Christophe COLOMB, departure airport: New York, arrival airport: Tokyo, booking reference: 35383113).
>   6. Actor selects the booking.
>   7. System shows the complete booking details for the booking reference: 35383113.

#### Result
>   Sales employee has successfully retrieved the booking details.

#### Extensions
>   None.

#### Exceptions
>   5. System informs user no booking was found.
>>      5.1 Test Scenario ends here.

### Test Scenario Use Management Dashboard <Mathias\>

#### Name
>   Use Management Dashboard

#### Scenario
>   1. Actor selects management dashboard.
>   2. System displays the management dashboard.
>   3. Actor interact with the dashboard and [look financial sheet In Statistics](Use%20Cases.md#use-case-view-financial-sheets-in-statistics).

#### Result
>   Sales manager used the management dashboard.

#### Extensions
>   None.

#### Exceptions
>   3. System shows that an error occurred when using the dashboard.
>>      3.1 Test Scenario ends here.

### Test Scenario View Financial Sheets In Statistics <Mathias\>

#### Name
>   View Financial Sheets In Statistics.

#### Scenario
>   1. Actor select to view financial sheets.
>   2. System asks the actor to select a flight.
>   3. Actor selects the flight number 10984.
>   4. System shows financial sheet of the selected flight (booked seats: 90%, total revenue: 10000€, total number of tickets sold: 100, total number of options sold: 10).

#### Result
>   Sales manager successfully viewed the financial sheet for the flight selected.

#### Extensions
>   None.

#### Exceptions
>   None.

### Test Scenario Login Verification <Lucas\>

#### Name
>   Login Verification.

#### Scenario
> 1.	Open the application.
> 2.	Verify that the homepage of the application is displayed.
> 3.	Navigate to the login page.
> 4.	Enter valid login credentials (Peter, Peter2001).
> 5.	Click on the login button.
> 6.	Verify that the system indicates the success of the login.
> 7.	Verify that the user is directed to their account page.


#### Result
>   The system successfully logs the sales employee into their account.
The sales employee is directed to their account page and can access the necessary features and information.


#### Extensions
>   None.

#### Exceptions
>   If the user enters incorrect login credentials, the system informs the user that their credentials are incorrect.

### Test Scenario Access previous flight records <Lucas\>

#### Name
>   Access Previous Flight Records

#### Scenario
> 1.    Navigate to the previous flight records page.
>2.	Verify that the system displays the previous flight records page.
>3.	Check if there are any previous flights available.
>4.	If there are no previous flights available, verify that the system notifies the user.
>5.	If there are previous flights available, select a flight that has already happened(flight 1823).
>6.	Verify that the system displays the flight information for the selected flight.
>7.	Check that the flight information includes the date, time, departure and arrival locations, flight duration, and any other relevant details.



#### Result
>   The system successfully displays the flight information of previous flights.
The sales employee can view the flight information for any previous flight that has occurred.



#### Extensions
>   None.

#### Exceptions
>   If there are no previous flights available, the system notifies the user that there are no previous flights.
The test scenario ends in this case.

### Test Scenario Login Verification <Lucas\>

#### Name
>   Start Sales Process

#### Scenario
>1.	Open the application.
>2.	Verify that the homepage of the application is displayed.
>3.	Navigate to the upcoming  flights page.
>4.	Verify that the system displays all upcoming flights.
>5.	Select an upcoming flight(flight 12321).
>6.	Verify that the system shows the selected flight.
>7.	Activate the sales process for the selected flight.
>8.	Verify that the system indicates that the sales process was successfully activated.




#### Result
>   The sales officer is able to activate the sales process for an upcoming flight.
The system indicates that the sales process was successfully activated.




#### Extensions
>   None.

#### Exceptions
>   If there are no active flights available, the system notifies the user that there are no active flights.
The test scenario ends in this case.

