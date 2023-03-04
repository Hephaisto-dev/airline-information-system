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
>   3. Actor interact with the dashboard and [look financial sheet In Statistics](Use%20Cases.md#use-case-view-financial-sheets-in-statistics--mathias).

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
>   Login.

#### Scenario
> 1.	Actor Open the application.
> 2.	System displays the login page.
> 3.	Actor enters valid login credentials (Peter, Peter2001).
> 4.	Actor tries to log in with the credentials entered.
> 5.	the system indicates the success of the login.
> 6.	Actor is redirected to the acount page.


#### Result
>   The system successfully logs the sales employee into their account.
The sales employee is directed to their account page and can access the necessary features and information.


#### Extensions
>   None.

#### Exceptions
>   4. If the actor enters incorrect login credentials, the system informs the actor that their credentials are incorrect.

### Test Scenario Access previous flight records <Lucas\>

#### Name
>   Access Previous Flight Records

#### Scenario
>1. Actor navigates to the previous flight records menu.
>2. System displays the previous flight records menu.
>3. Actor selects flight from canada to tokyo that happend on 11-02-2003
>4. System displays a page with more details about flight 112 from canada to tokyo that happend on 11-02-2003
like amount of seats etc.




#### Result
>   The system successfully displays the flight information of previous flights.
The sales employee can view the flight information for any previous flight that has occurred.



#### Extensions
>   2a.Actor selects a filter
     1. sytem shows list of filters
     2. Actor selects filter. return to step 2

#### Exceptions
>   2. If there are no previous flights available, the system notifies the user that there are no previous flights.
The test scenario ends in this case.

### Test Scenario start sales process <Lucas\>

#### Name
>   Start Sales Process

#### Scenario

>1.	The actor navigates to the register flights page.
>2.	The system displays all registered flights.
>3.	The actor selects a registerd flight(flight 113 from los angeles to new york on 11-2-2011).
>4. The system displays extra details about the flight(seats, plane, etc) and an option to activate the sales process.
>5.	The actor selects the option to start the sales porcess.
>6.	System indicates that the sales process was successfully activated.



#### Result
>   The sales officer is able to activate the sales process for an upcoming flight.
The system indicates that the sales process was successfully activated.




#### Extensions
>   None.

#### Exceptions
>   2. If there are no active flights available, the system notifies the user that there are no active flights.
The test scenario ends in this case.
>6. The system indicates that a error occured when trying to activate the sales process.

