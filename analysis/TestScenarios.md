# Test Scenarios

---
- [Test Scenarios](#test-scenarios)
    - [Test Scenario \<Template\>](#test-scenario-template)
      - [Name](#name)
      - [Scenario](#scenario)
      - [Result](#result)
      - [Extensions](#extensions)
    - [Test Scenario Search For Booking \<Mathias\>](#test-scenario-search-for-booking-mathias)
      - [Name](#name-1)
      - [Scenario](#scenario-1)
      - [Result](#result-1)
      - [Extensions](#extensions-1)
      - [Exceptions](#exceptions)
    - [Test Scenario Use Management Dashboard \<Mathias\>](#test-scenario-use-management-dashboard-mathias)
      - [Name](#name-2)
      - [Scenario](#scenario-2)
      - [Result](#result-2)
      - [Extensions](#extensions-2)
      - [Exceptions](#exceptions-1)
    - [Test Scenario View Financial Sheets In Statistics \<Mathias\>](#test-scenario-view-financial-sheets-in-statistics-mathias)
      - [Name](#name-3)
      - [Scenario](#scenario-3)
      - [Result](#result-3)
      - [Extensions](#extensions-3)
      - [Exceptions](#exceptions-2)
    - [Test Scenario Login Verification \<Lucas\>](#test-scenario-login-verification-lucas)
      - [Name](#name-4)
      - [Scenario](#scenario-4)
      - [Result](#result-4)
      - [Extensions](#extensions-4)
      - [Exceptions](#exceptions-3)
    - [Test Scenario Access previous flight records \<Lucas\>](#test-scenario-access-previous-flight-records-lucas)
      - [Name](#name-5)
      - [Scenario](#scenario-5)
      - [Result](#result-5)
      - [Extensions](#extensions-5)
      - [Exceptions](#exceptions-4)
    - [Test Scenario start sales process \<Lucas\>](#test-scenario-start-sales-process-lucas)
      - [Name](#name-6)
      - [Scenario](#scenario-6)
      - [Result](#result-6)
      - [Extensions](#extensions-6)
      - [Exceptions](#exceptions-5)
    - [Test Scenario "Purchase Ticket" ](#test-scenario-purchase-ticket-)
      - [Name](#name-7)
      - [Scenario](#scenario-7)
      - [Result](#result-7)
      - [Extensions](#extensions-7)
      - [Exceptions](#exceptions-6)
    - [Test Scenario "Apply Discount"  ](#test-scenario-apply-discount--)
      - [Name](#name-8)
      - [Scenario](#scenario-8)
      - [Result](#result-8)
      - [Exceptions](#exceptions-7)
    - [Test Scenario "Apply voucher" ](#test-scenario-apply-voucher-)
      - [Name](#name-9)
      - [Scenario](#scenario-9)
      - [Result](#result-9)
      - [Exceptions](#exceptions-8)
      - [Extensions](#extensions-8)
    - [Test Scenario "Cancel booking" ](#test-scenario-cancel-booking-)
      - [Name](#name-10)
      - [Scenario](#scenario-10)
      - [Result](#result-10)
      - [Exceptions](#exceptions-9)
    - [Test Scenario "Register employee" ](#test-scenario-register-employee-)
      - [Name](#name-11)
      - [Scenario](#scenario-11)
      - [Result](#result-11)
      - [Exceptions](#exceptions-10)
    - [Creating a new route  \<Martin\>](#creating-a-new-route--martin)
      - [Name](#name-12)
      - [Scenario](#scenario-12)
      - [Result](#result-12)
      - [Extensions](#extensions-9)
      - [Exceptions](#exceptions-11)
    - [Edit a route \<Martin\>](#edit-a-route-martin)
      - [Name](#name-13)
      - [Scenario](#scenario-13)
      - [Result](#result-13)
      - [Exceptions](#exceptions-12)
    - [Update upcoming flight information  \<Martin\>](#update-upcoming-flight-information--martin)
      - [Name](#name-14)
      - [Scenario](#scenario-14)
      - [Result](#result-14)
      - [Exceptions](#exceptions-13)
    - [Register upcoming flight \<Martin\>](#register-upcoming-flight-martin)
      - [Name](#name-15)
      - [Scenario](#scenario-15)
      - [Result](#result-15)
      - [Extensions](#extensions-10)
    - [Test Scenario "Searching for a flight" ](#test-scenario-searching-for-a-flight-)
      - [Name](#name-16)
      - [Scenario](#scenario-16)
      - [Result](#result-16)
      - [Exceptions](#exceptions-14)
    - [Test Scenario "Search for a route" ](#test-scenario-search-for-a-route-)
      - [Name](#name-17)
      - [Scenario](#scenario-17)
      - [Result](#result-17)
      - [Exceptions](#exceptions-15)
    - [Test Scenario "View flight information" ](#test-scenario-view-flight-information-)
      - [Name](#name-18)
      - [Scenario](#scenario-18)
      - [Result](#result-18)
      - [Exceptions](#exceptions-16)
    - [Test Scenario "Edit personal information for a costumer" ](#test-scenario-edit-personal-information-for-a-costumer-)
      - [Name](#name-19)
      - [Scenario](#scenario-19)
      - [Result](#result-19)
      - [Exceptions](#exceptions-17)
  - [Back to Table of Contents](#back-to-table-of-contents)
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
>4. System displays a page with more details about flight 112 from canada to tokyo that happend on 11-02-2003 like amount of seats etc.




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
     
### Test Scenario "Searching for a flight" <Jazz>
#### Name
> Search for a flight
#### Scenario
> 1.Actor is searching for a flight to Brusselles.
> 2.The system gives upcoming flights to different destinations: from Eindhoven - Brusselles, Brusselles - Paris, Cyprus - Riga.
> 3.The actor selecting specific flights: Brusselles - Paris.
> 4.The system gives all the information about the flight Brusselles - Paris: departure time from Brusselles: 2pm; arrival time to Paris: 3 pm; total time of the flight: 1h.

#### Result
> The actor has successfully found a flight

#### Exceptions
> The system informs the user that something went wrong while searching for a route.


### Test Scenario "Search for a route" <Jazz>
#### Name
> Search for a route

#### Scenario
> 1.Actor is searching for a rout from Dusseldorf to Los Angeles.
> 2.The system gives upcoming flights: from Dusseldorf - New York - Los Angeles, Dusseldorf - Frankfurt - Los Angeles.
> 3.The actor selecting specific route: Dusseldorf - Frankfurt - Los Angeles.
> 4.The system gives all the information about the route Dusseldorf - Frankfurt - Los Angeles: departure time from Dusseldorf: 2pm; arrival time to Frankfurt: 3:30 pm; transit time in Frankfurt: 1.5h; departure from Frankfurt: 5 pm; arrival time to Los Angeles: 12pm.

#### Result
> The actor has successfully found a route.

#### Exceptions
> The system informs the user that something went wrong while searching for a route.


### Test Scenario "View flight information" <Jazz>
#### Name
> View flight information

#### Scenario
> 1.Actor searching for a previous flight Brusselles - Paris.
> 2.The system displays all the information about the flight Brusselles - Paris.
> 3.The actor views information about flight Brusselles - Paris: departure time from Brusselles: 2pm; arrival time to Paris: 3 pm; total time of the flight: 1h.

#### Result
> The actor has successfully found the information about an upcoming flight.

#### Exceptions
> The system informs the user that something went wrong while searching for a flight or displaying its information.

     
### Test Scenario "Edit personal information for a costumer" <Jazz>
#### Name
> Edit personal information for a costumer

#### Scenario
> 1.Actor searching for a page of a customer Martin.
> 2.The system displays the page and all the personal infromation about a customer Martin.
> 3.The actor edits Martins age to 20 on the 30th of June.
> 4.The actor confirms Martins modified age.
> 5.The system checks all the modified data 
> 6.The system confirms the modifications and saves it

#### Result
> The actor has edited the customers information

#### Exceptions
> The system informs the user that something went wrong while editing the information.
     
## [Back to Table of Contents](../TableOfContents.md)
