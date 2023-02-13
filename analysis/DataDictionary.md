# Data Dictionary

## Airplane:

    Id: Unique airplane number
	Capacity: Number of total seats in the airplane
	Seat mapping: Contains the mapping of the plane seats
    Type: What type of airplanes (Airbus A320, Boeing 737 -> small, medium, large)

## Baggage:

	Id: Unique identifier for each baggage
	Height: The maximum height of the baggage
	Length: The maximum length of the baggage
    Weight: The maximum weight of the baggage
    Width: The maximum width of the baggage
	Carry on: Whether the baggage is a carry on or not
	Cargo: Whether the baggage is cargo or not 

## Booking:

    Id: Unique identifier for each booking
	Employee id: Identifier of the employee that create the booking
    Flight id: Identifier of the flight of the booking
	Passenger id: Identifier of the passenger related to the booking
	Ticket: The ticket of this booking
	Booking date: Date when booking was made
	Seat number: Seat number assigned to the passenger

## Discount:

	Id: Unique identifier for each discount
	Static: Whether this discount is static (will take off a fixed amount of the price)
	Dynamic: Whether this discount is dynamic (will take off a percentage of the price)
	Value: The value of the discount (percentage discount if not static)

## Employee:

    Id: Unique identifier for each employee
	First name: First name of the employee
	Last name: Last name of the employee
	Birthdate: The birthdate of the employee
	Phone: Phone number of the employee
	Email: Email address of the employee
    Job title: This defines what a person's job is in the company


## Flight:

    Id: Unique identifier for each flight
	Arrival: City where the flight arrives at
	Departure: City where the flight departs from
    Arrival datetime: Time and date when the flight arrives
    Airplane: Type of airplane used for the flight
    Capacity: Maximum number of seats in the flight (linked to airplane)
	Departure datetime: Time and date when the flight departs
	Flight duration: Total duration of the flight
    Flight number: Flight number for the airline
    Status: Current state of the flight (scheduled, delayed, canceled, ongoing, landed, boarding, ?)
	Tickets: Different ticket types for this flight 
	Ticket id: Unique ticket number for the specific flight
	Cost: Cost of the flight
	Gate: The gate of the flight


## Passenger:

    Id: Unique identifier for each passenger
	First name: First name of the passenger
	Last name: Last name of the passenger
	Nationality: Nationality of the passenger
	Passport/ID number: Passport number of the passenger (if applicable)
	Phone: Phone number of the passenger
	Email: Email address of the passenger
    Passenger type: The type of the passenger (Adult, child, student)

## Seat:

	Availability: Whether the seat is available or not
    Class: The class of the current seat (1st, 2nd, eco)
    Column: Column number of the seat
	Row: Row number of the seat
	Number: The seat number
	Door of entrance: The door of entrance of the seat

## Ticket:

	Baggage: The baggage allowed for this ticket
	Discount: The discount of the ticket
    Price: The price of the ticket
    Seat: The seat of this ticket
	Currency: The currency of the ticket

## Route

	Flights: The flights of the route
	Route duration: The duration of the route
	Route cost: The cost of the route
	Transit times: The transit time of each flights
