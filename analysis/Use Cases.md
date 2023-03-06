# USE CASES

---
* [USE CASES](#use-cases)
    * [Use Case Purchase Ticket <Daniel>](#use-case-purchase-ticket-daniel)
    * [Use Case "Apply discount" <Daniel>](#use-case--apply-discount--daniel)
    * [Use Case "Apply voucher" <Daniel>](#use-case--apply-voucher--daniel)
    * [Use Case Login <Lucas>](#use-case-login-lucas)
    * [Use Case Access previous flight records <Lucas>](#use-case-access-previous-flight-records-lucas)
    * [Use Case Start sales process <Lucas>](#use-case-start-sales-process-lucas)
    * [Use Case Search For Booking <Mathias\>](#use-case-search-for-booking--mathias)
    * [Use Case Use Management Dashboard <Mathias\>](#use-case-use-management-dashboard--mathias)
    * [Use Case View Financial Sheets In Statistics <Mathias\>](#use-case-view-financial-sheets-in-statistics--mathias)
    * [Use Case Cancel a booking <Jazz>](#use-case-cancel-a-booking-jazz)
    * [Use Case "Register Employee" <???>](#use-case--register-employee----)
    * [Create a route <Martin>](#create-a-route-martin)
    * [Edit a route <Martin>](#edit-a-route-martin)
    * [Update upcoming flight information <Martin>](#update-upcoming-flight-information-martin)
    * [Register upcoming flight <Martin>](#register-upcoming-flight-martin)
  * [Back to Table of Contents](#back-to-table-of-contents)

#### Name
>   Template

#### Actor
>   Developers

#### Description
>   *The void stares back at you*

#### Pre-condition
>   Understanding how to write these

#### Scenario
>1. Open the .md file in Visual Studio Code
>2. VSCode opens the code
>3. Edit the file to include the new Use Case and save
>4. Switch to GitHub Desktop and click on the "Fetch origin" button, wait for it to finish
>5. After asserting that there are no issues / conflicts, name the commit, add brief description if needed and commit

#### Result
>   The Use Cases have been updated, by adding, editing or deletion of one or multiple Use Cases

#### Exceptions
>5. If there is an issue, handle it before committing
<!-- Here we need to double check if this'd be an exception for 4. or 5.-->

---
<!-- Further Use Cases can be edited now-->


### Use Case Purchase Ticket <Daniel>

#### Name
>   Purchase Ticket

#### Actor
>   Sales Employee

#### Description
>   Actor buys a ticket for a person

#### Pre-condition
>   Logged in as Sales Employee

#### Scenario
>1. Actor navigates to the "Purchase Ticket" option
>2. System provides the according GUI
>3. Actor selects the flight their customer desires
>4. System shows that this flight has been selected and asks if there's anything else
>5. Actor denies the question
>6. System provides the GUI to enter the personal information for the ticket
>7. Actor either enters the information on behalf of the customer or lets them do it themselves and finalises the purchase
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
### Use Case "Apply discount" <Daniel>

#### Name
>   Apply discount

#### Actor
>   Sales Employee

#### Description
>   Actor applies a discount on a ticket before continuing with the sale of the ticket

#### Pre-condition
>   Logged in as Sales Employee
>   Selected option to "Apply discount" in Use Case "Purchase Ticket"

#### Scenario
>1. Actor informs the system of what discount needs to be added
>2. System asks the actor to fill in the amount of the discount that is to be applied
>3. Actor fills in what the correct amount is
>4. System asks actor to confirm if the shown amount is the correct amount
>5. Actor confirms this
>6. System puts the actor back to the previous page

#### Result
>   A discount has been applied to the ticket that is being bought

#### Exceptions
>4.a.   If the actor enters an amount greater than or equal to the price of the ticket, the system informs them of this and asks them to enter a viable amount

>5.a.   Should the actor deny this as a correct amount, the system reverts back to step 2.

#### Extensions
>   None

---

### Use Case "Apply voucher" <Daniel>

#### Name
>   Apply voucher

#### Actor
>   Sales Employee

#### Description
>   Actor applies a voucher (percentage discount) on a ticket before continuing with the sale of the ticket

#### Pre-condition
>   Logged in as Sales Employee
>   Selected option to "Apply voucher" in Use Case "Purchase Ticket"

#### Scenario
>1. Actor informs the system of what voucher needs to be added
>2. System asks the actor to fill in the amount of the voucher that is to be applied
>3. Actor fills in what the correct amount is
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
### Use Case Login <Lucas>
    
#### Name
>   Login

#### Actor
>   Sales employee, sales officer and sales manager

#### Description
>   Actor logs in to gain access to their account

#### Pre-condition
>   Actor has a account and is logged out

#### Scenario
>1. Actor opens the application.
>2. The system displays the login page of the application
>3. The actor fills in the required fields with his credentials.
>4. The system indicates the success of the login

#### Result
>   The actor has successfully logged in.

#### Exceptions
>3. The system informs the user that his credentials were incorrect.
    3.1 return to step 2
>4. The system informs the user there was an error attempting to log in
    4.1 return to step 2
---
### Use Case Access previous flight records <Lucas>
#### Name
>   Access previous flight records

#### Actor
>   Sales employee

#### Description
>   A sales employee is able to see the flight information of flights that already happened

#### Pre-condition
>  Sales employee is logged in

#### Scenario
>1. Actor navigates to the previous flight records page.
>2. The system displays the previous flight records page. 
>3. The actor selects a flight which already happened. 
>4. the system displays the flight information for the selected flight. 


#### Result
>   The actor can look at the records of previous flights
#### Exceptions
>2. system notifies that there are no previous flights
    2.1 case ends
#### Extensions
    3a. Actor applies a filter to the list
        1. System shows a list of filters.
        2. Actor selects the filter he wants to use. Return to step 3. 

---
### Use Case Start sales process <Lucas>
#### Name
>   Start sales process

#### Actor
>   Sales Officer 

#### Description
>   A sales officer can start the sales process for the sales employee to see 

#### Pre-condition
>  Sales officer is logged in

#### Scenario
    
>1. The actor navigates to the flights. 
>2. the system displays all registered flights.
>3. the actor selects a flight. 
>4. the system shows the selected flight.
>5. the actor activates the sales process
>6. the system indicates it was successfully activated.


#### Result
>   The sales process has successfully begun
#### Exceptions
>3. system notifies that there are no active flights.
3.1 case ends here
>4. System notifies that an error accured when trying to initiate the sales process
    4.1 case ends here
---


### Use Case Search For Booking <Mathias\>

#### Name
>   Search For Booking

#### Actor
>   Sales employee

#### Description
>   Sales employee search for one booking

#### Pre-condition
>   Sales employee is signed in to his account.

#### Scenario
>   1. Actor selects to search for booking.
>   2. System asks the actor to enter booking details
>   3. Actor enter some booking details.
>   4. System searches for all the booking that match the enter booking details.
>   5. System shows the reservations found.
>   6. Actor select one of the bookings shown.
>   7. System shows the booking details for the selected booking.

#### Result
>   Sales employee has successfully retrieved the booking details.

#### Extensions
>   None.

#### Exceptions
>   3. System informs user no booking was found.
>>      3.1 Use case ends here.

---

### Use Case Use Management Dashboard <Mathias\>

#### Name
>   Use Management Dashboard

#### Actor
>   Sales manager

#### Description
>   Sales manager uses the management dashboard to view key performance indicators.

#### Pre-condition
>   Sales manager is signed into his account.

#### Scenario
>   1. Actor selects management dashboard.
>   2. System displays the management dashboard.
>   3. Actor interact with the dashboard (e.g., [<ins>view financial sheets in statistics</ins>](Use%20Cases.md#use-case-view-financial-sheets-in-statistics--mathias)).

#### Result
>   Sales manager viewed the key performance indicators and other important data.

#### Extensions
>   None.

#### Exceptions
>   3. System shows that an error occurred when using the dashboard.
>>      3.1 Use case ends here.
---


### Use Case View Financial Sheets In Statistics <Mathias\>

#### Name
>   View Financial Sheets In Statistics.

#### Actor
>   Sales manager.

#### Description
>   Sales manager views a financial sheet of a flight.

#### Pre-condition
>   Sales manager is using the dashboard.

#### Scenario
>   1. Actor select to view financial sheets.
>   2. System asks the actor to select a flight.
>   3. Actor selects a flight.
>   4. System shows financial sheet of the selected flight.

#### Result
>   Sales manager successfully viewed the financial sheet for the flight selected.

#### Extensions
>   None.

#### Exceptions
> 5. System informs the actor that something went wrong when loading the information and allows the user to try again. 

---
        
Use Case Searching for a flight <Jazz>
#### Name
> Search for a flight

Actor
> Sales employee

Description
> A sales employee is searching for one or more flights

####Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for searching a flight

Scenario
> 1.Actor navigates to the area/menu for searching a flight. 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a flight and confirms it. 
> 4.The system gives the necessary information, that was asked 
> 5.The actor is choosing the information that is need

Result
> The actor has successfully found a flight

Exceptions
> The system informs the user that something went wrong while searching for a route.

---
    
Use case Search for a route <Jazz>
#### Name
> Search for a route

Actor
> Sales employee

Description
> A sales employee is searching for one or more routes

Pre-condition
 > Sales Employee is signed into their account.

> Sales Employee is provided with the information for searching a route

Scenario
> 1.Actor navigates to the area/menu for searching a route. 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a route and confirms it. 
> 4.The system gives the necessary information, that was asked 
> 5.The actor is choosing the information that is needed

Result
> The actor has successfully found a route.

Exceptions
> The system informs the user that something went wrong while searching for a route.

    
---
    
Use case View flight information <Jazz>
#### Name
> View flight information

####Actor
> Sales employee

Description
> A sales employee is viewing the upcoming fight information

Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for viewing the upcoming flight information

Scenario
> 1.Actor navigates to the area/menu for searching 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a specific flight and confirms it. 
> 4.The system lists the necessary information(flights) 
> 5.The actor is choosing the flight that is needed 
> 6.System gives the page of the flight that was chosen 
> 7.The actor I able to see all the information about a specific upcoming flight

Result
> The actor has successfully found the information about an upcoming flight.

Exceptions
> The system informs the user that something went wrong while searching for a flight or displaying its information.

    
    -----
    
Use case Edit personal information for a costumer <Jazz>
#### Name
> Edit personal information for a costumer

Actor
> Sales employee

Description
> A sales employee is editing costumers personal

Pre-condition
> Sales Employee is signed into their account.

> Sales Employee is provided with the information for editing customers information

Scenario
> 1.Actor navigates to the menu for editing the customers 
> 2.The system displays a menu. 
> 3.The actor edits the necessary information for the customer 
> 4.The actor confirms the modified data 
> 5.The system checks all the modified data 
> 6.The system confirms the modifications

Result
> The actor has edited the customers information

Exceptions
> The system informs the user that something went wrong while editing the information.
----
### Use Case Cancel a booking <Jazz>

#### Name
>   Cancel a booking

#### Actor
>   Sales Employee

#### Description
>   The Sales Employee cancels a booking on behalf of a customer

#### Pre-condition
>   Logged in as a Sales Officer

#### Scenario
>1. Actor selects the option to cancel a booking
>2. System provides the according GUI
>3. Actor indicates which ticket should be deleted
>4. System asks for confirmation if this is the correct Ticket to delete
>5. Actor confirms the choice
>6. System informs how much money is to be refunded
>7. Actor informs the system that the refund has been completed
>8. System returns to the previous screen

#### Result
>   The Ticket has been successfully canceled. Refundment has been handed out

#### Exceptions
>5.a. If actor denies the confirmation, the system moves back to step 3

---

### Use Case "Register Employee" <???>

#### Name
>   Register Employee

#### Actor
>   Sales Manager

#### Description
>   Sales Manager registers new employee

#### Pre-condition
>   Logged in as Sales Manager

#### Scenario
>1. Actor selects the option to register new employees
>2. System provides the according GUI
>3. Actor enters the information (i.e. name, contact info, job title) and confirms
>4. System saves the info and informs actor what the ID of the new employee is
>5. Actor selects the option to go back to inital screen
>6. System moves back to initial screen

#### Result
>   New employee has been registered and been given an ID

#### Exceptions
>   None

---

### Create a route <Martin>

#### Name
>   Create a route

#### Actor
>   Sales officer

#### Description
>   A sales officer creates one or more routes

#### Pre-condition
>   Sales officer is signed into their account.

#### Scenario
>1. Actor navigates to the menu for creating  route.
>2. The system displays an editing page.
>3. The actor enters the necessary information for creating a route.
>4. The actor saves the made changes.
>5. The system asks the actor to confirm their choice.
>6. The actor confirms their choice.
>7. The system indicates the success of the execution of the action.


#### Result
>   The actor has successfully created a route.

#### Exceptions
>7.  The system informs the user that something went wrong when creating the route.
>>7.1 Use case ends here.

#### Extensions
> None

---

### Edit a route <Martin>

#### Name
>   Edit a route

#### Actor
>   Sales officer

#### Description
>   Sales officer edits an existing route

#### Pre-condition
>   Sales officer is signed into their account.
>   Sales officer has created a route that he can edit.


#### Scenario
>1. Actor navigates to the menu for managing routes.
>2. The system displays a list of existing routes.
>3. Actor selects the route they want to edit.
>4. The system displays an editing page with the current details of the route.
>5. Actor makes the necessary changes.
>6. Actor saves the changes.
>7. The system asks the actor to confirm their choice.
>8. Actor confirms changes.
>9. The system updates the route with the new information and indicates the success of the execution of the action. 



#### Result
>   The actor has successfully edited the route.

#### Exceptions
>8. The actor does not confirm the changes.
>>8.1   The system returns the user to the editing page.
    
>9. The system informs the user that something went wrong when updating the route.
    >>9.1  The system displays an error message and allows the actor to try again.


#### Extensions
> None

---  

### Update upcoming flight information <Martin>

#### Name
>   Update upcoming flight information

#### Actor
>   Sales officer

#### Description
>   Sales officer updates information about a flight.

#### Pre-condition
>   Sales officer is signed into their account.


#### Scenario
>1. Actor navigates to the menu for managing flights.
>2. The system displays a list of existing flights.
>3. Actor selects the flight they want to update.
>4. The system displays a page with the current details of the flight.
>5. Actor makes the necessary changes to the flight.
>6. Actor saves the changes.
>7. The system asks for confirmation of the changes.
>8. Actor confirms changes.
>9. The system updates the flight with the new information and indicates the success of the execution of the action.



#### Result
>   The actor has successfully updated the flight information.

#### Exceptions
>9. The system informs the user that something went wrong when updating the flight.
 >>   9.1 The system displays an error message and allows the airline staff to try again.


#### Extensions
> None
    
---  

### Register upcoming flight <Martin>

#### Name
>   Register upcoming flight

#### Actor
>   Sales officer

#### Description
>   Sales officer updates information about a flight.

#### Pre-condition
> Sales officer is signed into their account
> Sales officer has the necessary information to register the upcoming flight



#### Scenario

>1. Actor navigates to the menu for registering flights.
>2. The system displays an editing page for registering flights.
>3. Actor enters the necessary information for the upcoming flight.
>4. Actor saves the changes.
>5. The system asks the user to confirm their choice.
>6. Actor confirms the registration for the upcoming flight.
>7. The system updates the database with the new flight information and indicates the success of then execution.


#### Result
> The actor has successfully registered the upcoming flight.

#### Exceptions
>7. The system informs the user that something went wrong when registering the flight.
    >7.1 The system displays an error message and allows the actor to try again.


#### Extensions
> None



### Creare a booking <Janis>

#### Name
>   Creare a booking

#### Actor
>   Sales employee

#### Description
>   Sales employee is dooing a booking for a Customer.

#### Pre-condition
> Sales employee is signed into their account
> Sales employee has the necessary information to register the upcoming flight



#### Scenario

1.	 Sales employee at a travel agency logs into the company's booking system to create a new booking for a customer,  who wants to book a flight to Tokyo for a business trip.
2.	Sales employee navigates to the booking section of the system and enters the travel details of the Customer, including departure and arrival airports, travel dates, and any other relevant information.
3.	The system presents the Sales employee a list of available flights that match the Customers requirements. She can filter and sort the results by price, duration, or airline.
4.	The Sales employee selects a flight that fits the Customers schedule and budget and enters his personal and payment information into the system. The system generates a booking confirmation, which the Sales employee sends to the Customer via email.
5.	A few days before the flight, the system sends the Customer a reminder email with his flight details and instructions for check-in and baggage.



#### Result
> The actor has successfully create a booking.

#### Exceptions
>7. The system informs the user that something went wrong with creating the booking.
    >7.1 The system displays an error message and allows the actor to try again.


#### Extensions
> None




### Adding Extras <Janis>

#### Name
>   Adding Extras

#### Actor
>   Sales employee

#### Description
>   Sales employee is adding Extras for a Customer.

#### Pre-condition
> Sales employee is signed into their account
> Sales employee has the necessary information to register the upcoming flight



#### Scenario

1.	 Sales employee at a travel agency and a customer has already purchased a flight ticket for a trip.
2.	Customer  calls the Sales employee to add extras to his flight, such as seat selection, in-flight meals, and baggage allowance upgrades.
3.	The Sales employee logs into the company's booking system and finds the Customers reservation by entering his name and confirmation number.
4.	The system displays the Customers flight details and allows the Sales employee to view and add extras to his reservation.
5.	The Sales employee selects the extras that the Customer  requested and adds them to his reservation. The system automatically calculates the total cost of the extras and updates the reservation with the new price.



#### Result
> The actor has successfully add extras.

#### Exceptions
>7. The system informs the user that something went wrong while adding extras.
    >7.1 The system displays an error message and allows the actor to try again.


#### Extensions
> None




### Canceling a booking <Janis>

#### Name
>   Canceling a booking

#### Actor
>   Sales employee

#### Description
>   Sales employee is caneling a booking for a Customer.

#### Pre-condition
> Sales employee is signed into their account
> Sales employee has the necessary information to register the upcoming flight



#### Scenario

1.	The sales employee gets a call by a Customer who wants to cancel his next flight. 
2.	The Customer provides his name and flight confirmation number to the Sales empoyee.
3.	The Sales employee logs into the company's booking system and enters the Customers name and confirmation number to retrieve his flight details.
4.	The system displays the Customers flight information, including the flight number, departure time, and booking details.
5.	The sales Employee confirms the details with the Customer and informs him of the cancellation policy and any applicable fees.
6.	The sales Employee enters the cancellation request into the system and initiates the refund process.
7.	The system generates a cancellation confirmation and a refund receipt for the Customer.



#### Result
> The actor has successfully canceled the booking.

#### Exceptions
>7. The system informs the user that something went wrong while canceling tuhe booking.
    >7.1 The system displays an error message and allows the actor to try again.


#### Extensions
> None






## [Back to Table of Contents](../TableOfContents.md)
