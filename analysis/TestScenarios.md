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

---
### Test Scenario Use Management Dashboard <Mathias\>

#### Name
>   Use Management Dashboard

#### Scenario
>   1. Actor selects management dashboard.
>   2. System displays the management dashboard.
>   3. Actor interact with the dashboard by reviewing how many tickets were and were not sold per flight. 

#### Result
>   Sales manager used the management dashboard.

#### Extensions
>   None.

#### Exceptions
>   3. System shows that an error occurred when using the dashboard.
>>      3.1 Test Scenario ends here.

---
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
>   2. System informs the user that no registered flights were found.
>>   2.1 Test scenario ends here.
>   4. System informs the user that an error occurred.
>   4.1 Test Scenario ends here.

---
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

---
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

---
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


### Test Scenario "Purchase Ticket" <Daniel>

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

### Test Scenario "Apply Discount"  <Daniel>

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

### Test Scenario "Apply voucher" <Daniel>

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

### Test Scenario "Cancel booking" <Daniel>

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

### Test Scenario "Register employee" <Daniel>

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

### Creating a new route  <Martin\>

#### Name
>   Creating a new route 

#### Scenario
>1.The actor navigates to the editing route menu of the application.
>2. The system displays an editing page with fields to enter route information for each segment of the route.
>3. The actor enters the necessary information for creating a route, such as route name "Route A", start location "New York City", end location "Los Angeles", departure date and time "2023-04-01 10:00 AM", arrival date and time "2023-04-01 10:00 PM", and flight numbers "101", "202", and "303" for each segment of the route.
>4. The actor chooses to save changes.
>5. The system displays asks the user for confirmation.
>6. The actor confirms their choice.
>7. The system indicates the success of the execution of the action by displaying successful message.


#### Result
>   The actor has successfully created a route.

#### Extensions
>6. The actor does not confirm.
     >>6.1 Return to step 2. 
#### Exceptions
>7 The system informs the employee that something went wrong when creating the route, such as a database connection error.
     >>7.2 Return to step 2.


---

### Edit a route <Martin\>

#### Name
>   Edit a route

#### Scenario
>1. The actor navigates to the menu for managing routes. 
>2.The system displays a list of existing routes.
>3. The actor selects which flight they want to edit: route from Canada (CND) to Tokyo (TKY) with a layover in Seoul (SEO).
>4.The system displays an editing page with the current details of the route.
>5. The actor changes the departure time from "2023-04-01 08:00" to "2023-04-01 09:00".
-The actor adds a new stopover at “CBD airport”
-The actor changes the arrival time at the final destination from "2023-04-01 12:00" to "2023-04-01 13:00".
>6. The airline administrator saves the changes.
>7.The system asks the airline administrator to confirm their choice.
>8. The airline administrator confirms the changes.
>9.The system updates the route with the new information and indicates the success of the execution of the action.


#### Result
>   The actor has successfully edited a route.

#### Exceptions
>8. The actor does not confirm the changes.
     >>8.1 The system returns the airline administrator to the editing page.
>9. The system informs the actor that something went wrong when updating the route. 
     >>9.1 The system displays an error message and allows the airline administrator to try again.

---

### Update upcoming flight information  <Martin\>

#### Name
>   Change/update upcoming flight information 

#### Scenario
>1. Actor navigates to the menu for managing flights.
>2.The system displays a list of existing flights.
>3. Actor selects the flight they want to update. 4.The system displays a page with the current details of the flight: Flight number: UA123 Departure airport: CBD, arrival airport: LAX, Departure time: 2023-03-15 08:30 AM, arrival time: 2023-03-15 11:45 AM.
>5.Actor makes the necessary changes to the flight. Flight number: UA123 Departure airport: JFK Arrival airport: SFO Departure time: 2023-03-15 08:30 AM EST Arrival time: 2023-03-15 12:15 PM.
>6. Actor saves the changes.
>7.The system asks for confirmation of the changes.
>8. Actor confirms changes. 
>9.The system updates the flight with the new information and indicates the success of the execution of the action.


#### Result
>   MThe actor has successfully updated the flight information.

#### Exceptions
> 9.The system informs the user that something went wrong when updating the flight. 
     >> 9.1 The system displays an error message and allows the airline staff to try again.

---

### Register upcoming flight <Martin\>

#### Name
>   Register upcoming flight

#### Scenario
>1. Actor navigates to the menu for registering flights.
>2.The system displays an editing page for registering flights.
>3. Actor enters the following information for the upcoming flight: Flight number: AA123 Departure airport: LAX (Los Angeles International Airport) Destination airport: CBD (Car Nicobar Airport) Departure date and time: 2023-03-15 08:00 AM Arrival date and time: 2023-03-15 04:00 PM  Number of available seats: 100.
>4.Actor saves the changes.
>5. The system asks the user to confirm their choice.
>6.Actor confirms the registration for the upcoming flight.
>7. The system updates the database with the new flight information and indicates the success of the execution. 


#### Result
>   The actor has successfully registered the upcoming flight with the specified information.

#### Extensions
>7. The system informs the user that something went wrong when registering the flight.
     >> 7.1 The system displays an error message and allows the actor to try again.
     
    ----
     
### Use Case Searching for a flight<Jazz>
#### Name
> Search for a flight

#### Actor
> Sales employee

#### Description
> A sales employee is searching for one or more flights

#### Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for searching a flight

#### Scenario
> 1.Actor navigates to the area/menu for searching a flight. 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a flight and confirms it. 
> 4.The system gives the necessary information, that was asked 
> 5.The actor is choosing the information that is need

#### Result
> The actor has successfully found a flight

#### Exceptions
> The system informs the user that something went wrong while searching for a route.

    ---
    
### Use case Search for a route<Jazz>
#### Name
> Search for a route

#### Actor
> Sales employee

#### Description
> A sales employee is searching for one or more routes

#### Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for searching a route

#### Scenario
> 1.Actor navigates to the area/menu for searching a route. 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a route and confirms it. 
> 4.The system gives the necessary information, that was asked 
> 5.The actor is choosing the information that is needed

#### Result
> The actor has successfully found a route.

#### Exceptions
> The system informs the user that something went wrong while searching for a route.

    
    -----
    
### Use case View flight information<Jazz>
#### Name
> View flight information

#### Actor
> Sales employee

#### Description
> A sales employee is viewing the upcoming fight information

#### Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for viewing the upcoming flight information

#### Scenario
> 1.Actor navigates to the area/menu for searching 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a specific flight and confirms it. 
> 4.The system lists the necessary information(flights) 
> 5.The actor is choosing the flight that is needed 
> 6.System gives the page of the flight that was chosen 
> 7.The actor I able to see all the information about a specific upcoming flight

#### Result
> The actor has successfully found the information about an upcoming flight.

#### Exceptions
> The system informs the user that something went wrong while searching for a flight or displaying its information.

    
    -----
    
### Use case Edit personal information for a costumer<Jazz>
#### Name
> Edit personal information for a costumer

#### Actor
> Sales employee

#### Description
> A sales employee is editing costumers personal

#### Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for editing customers information

#### Scenario
> 1.Actor navigates to the menu for editing the customers 
> 2.The system displays a menu. 
> 3.The actor edits the necessary information for the customer 
> 4.The actor confirms the modified data 
> 5.The system checks all the modified data 
> 6.The system confirms the modifications

#### Result
> The actor has edited the customers information

#### Exceptions
> The system informs the user that something went wrong while editing the information.
     
## [Back to Table of Contents](https://github.com/FontysVenlo/prj2-2023-prj2-2023-17/blob/main/TableOfContents.md)
