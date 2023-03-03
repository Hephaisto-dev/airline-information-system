# USE CASES

---

### Use Case Template <Assignee?>

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


### Use Case Purchase Ticket

#### Name
>   Purchase Ticket

#### Actor
>   Sales Employee

#### Description
>   Actor buys a ticket for a person standing near them

#### Pre-condition
>   Logged in as Sales Employee

#### Scenario
>1. Actor selects the "Purchase Ticket" option
>2. System provides the according GUI
>3. Actor asks for and selects the flight their customer demands
>4. System shows that this flight has been selected and asks if there are further questions
>5. Actor denies the question
>6. System provides the ticket and returns back to initial screen

#### Result
>   The Sales Employee gets a ticket to the according flight for their customer

#### Extensions
>5. Actor selects the option "Apply discount". Handled by the Use Case "Apply discount"

>5. Actor selects the option "Apply voucher". Handled by the use Case "Apply voucher"

>5. Actor selects the option "Add extras". Handled by the Use Case "Apply extras"

#### Exceptions
>5. Actor cancels the ticket selction. System moves back to the initial screen
---

### Use Case Searching for a flight

#### Name
>   Search for a flight

#### Actor
>   Sales employee

#### Description
>   A sales employee is searching for one or more flights

#### Pre-condition
>   Sales Employee is signed into their account. 
 
Sales Employee is provided with the information for searching a flight
 


#### Scenario
> 1.Actor navigates to the area/menu for searching a flight. 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a flight and confirms it. 
> 4.The system gives the necessary information, that was asked
> 6.The actor is choosing the information that is need



#### Result
>   The actor has successfully found a flight

#### Exceptions
>The system informs the user that something went wrong while searching for a route. 
---

### Use case Search for a route
#### Name
>   Search for a route

#### Actor
>   Sales employee

#### Description
>   A sales employee is searching for one or more routes

#### Pre-condition
>   Sales Employee is signed into their account. 
 
Sales Employee is provided with the information for searching a route 


#### Scenario
> 1.Actor navigates to the area/menu for searching a route. 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a route and confirms it. 
> 4.The system gives the necessary information, that was asked
> 5.The actor is choosing the information that is needed


#### Result
>   The actor has successfully found a route. 

#### Exceptions
>The system informs the user that something went wrong while searching for a route. 

---

### Use case View flight information

#### Name
>   View flight information

#### Actor
>   Sales employee

#### Description
>   A sales employee is viewing the upcoming fight information

#### Pre-condition
>   Sales Employee is signed into their account. 
 
Sales Employee is provided with the information for viewing the upcoming flight information 


#### Scenario
> 1.Actor navigates to the area/menu for searching 
> 2.The system displays an area/menu. 
> 3.The actor enters the necessary information for searching a specific flight and confirms it. 
> 4.The system lists the necessary information(flights)
> 5.The actor is choosing the flight that is needed
> 6.System gives the page of the flight that was chosen
> 7.The actor I able to see all the information about a specific upcoming flight

#### Result
>   The actor has successfully found the information about an upcoming flight.

#### Exceptions
> The system informs the user that something went wrong while searching for a flight or displaying its information.

---

### Use case Edit personal information for a costumer

#### Name
>   Edit personal information for a costumer

#### Actor
>   Sales employee

#### Description
>   A sales employee is editing costumers personal

#### Pre-condition
>   Sales Employee is signed into their account. 
 
Sales Employee is provided with the information for editing customers information


#### Scenario
> 1.Actor navigates to the menu for editing the customers 
> 2.The system displays a menu. 
> 3.The actor edits the necessary information for the customer 
> 4.The actor confirms the modified data
> 4.The system checks all the modified data
> 6.The system confirms the modifications

#### Result
>   The actor has edited the customers information

#### Exceptions
> The system informs the user that something went wrong while editing the information.
