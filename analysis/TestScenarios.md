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

---


### Test Scenario "Purchase Ticket"

####    Name
>   Purchase Ticket

####    Scenario
>1. Actor navigates to the "Purchase Ticket" option
>2. System provides the according GUI
>3. Actor selects the flight "414, Duesseldorf - New York"
>4. System shows that this flight has been selected and asks if there's anything else
>5. Actor denies the question
>6. System provides the GUI to enter the personal information for the ticket
>7. Actor enters "Jan Mustermann, example@mail.com"
>7. System provides the ticket and returns back to initial screen

#### Result
>   The Sales Employee gets a ticket to the according flight for their customer

#### Extensions
>5.a. Actor selects the option "Apply discount". Handled by the Use Case "Apply discount"

>5.b. Actor selects the option "Apply voucher". Handled by the use Case "Apply voucher"

>5.c. Actor selects the option "Add extras". Handled by the Use Case "Choose Travel extras / options"

#### Exceptions
>5. Actor cancels the ticket selction. System moves back to the initial screen

---

### Test Scenario "Apply Discount"

####    Name
>   Apply Discount
####    Scenario
>1. Actor informs the system that a discount is to be added
>2. System asks the actor to fill in the amount of the discount that is to be applied
>3. Actor fills in "15.50"
>4. System asks actor to confirm if the shown amount is the correct amount
>5. Actor confirms this
>6. System puts the actor back to the previous page

#### Result
>   A discount has been applied to the ticket that is being bought

#### Exceptions
>4.a.   If the actor enters an amount greater than or equal to the price of the ticket, the system informs them of this and asks them to enter a viable amount

>5.a.   Should the actor deny this as a correct amount, the system reverts back to step 2.

---

### Test Scenario "Apply voucher"

####    Name
>   Apply voucher

####    Scenario
>1. Actor informs the system of what voucher needs to be added
>2. System asks the actor to fill in the amount of the voucher that is to be applied
>3. Actor fills in "0.05" (meaning 5%)
>4. System asks actor to confirm if the shown amount is the correct amount
>5. Actor confirms this
>6. System puts the actor back to the previous page

#### Result
>   A voucher has been applied to the ticket that is being bought

#### Exceptions
>4.a.   If the actor enters an amount greater than or equal to 100%, the system informs them of this and asks them to enter a viable amount

>5.a.   Should the actor deny this as a correct amount, the system reverts back to step 2.

#### Extensions
>   None

---

### Test Scenario "Cancel booking"

####    Name
>   Cancel Booking

####    Scenario
>1. Actor selects the option to cancel a booking
>2. System provides the according GUI
>3. Actor indicates that ticket for flight "414, Dusseldorf - New York" needs to be canceled
>4. System asks for confirmation if this is the correct Ticket to delete
>5. Actor confirms the choice
>6. System informs that "5.00" (5 Euros) is to be refunded
>7. Actor informs the system that the refund has been completed
>8. System returns to the previous screen

#### Result
>   The Ticket has been successfully canceled. Refundment has been handed out

#### Exceptions
>5.a. If actor denies the confirmation, the system moves back to step 3

---

### Test Scenario "Register employee"

####    Name
>   Register employee

####    Scenario
>1. Actor selects the option to register new employees
>2. System provides the according GUI
>3. Actor enters the information "John Green, Sales Employee, green@mail.com"
>4. System saves the info and informs actor that the ID is "SEjogr001"
>5. Actor selects the option to go back to inital screen
>6. System moves back to initial screen

#### Result
>   New employee john Green has been registered and been given an ID

#### Exceptions
>   None

---

## [Back to Table of Contents](https://github.com/FontysVenlo/prj2-2023-prj2-2023-17/blob/main/TableOfContents.md)