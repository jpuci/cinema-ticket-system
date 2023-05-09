# cinema-ticket-system
The application enables the reservation of movie tickets and verification of their validity.

The user (viewer), without the need to log into the system, can browse the available repertoire (showing date, time, and duration of screenings; movie details including description and photo).

The viewer can purchase tickets for a selected screening, provided that there are available seats. Purchasing tickets involves selecting a screening (date, time, and theater - a cinema can have multiple theaters) and choosing seats in the cinema hall. The client selects seats on a view representing a schematic layout of the cinema hall with the screen and rows of seats. The client marks the desired number of seats by clicking and confirms the reservation. As a result, a unique reservation code is generated, serving as proof of ticket purchase.

The ticket officer is an authorized user who has the ability to check the validity of a ticket based on the entered code. The ticket can be in one of the following states: non-existent, valid, cancelled, invalid.

The ticket is only valid up to 15 minutes before the screening starts and becomes invalid at the end of the screening.

In addition to the ticket status, the ticket officer should be able to see the number of reserved seats, theater number, and seat numbers. The ticket officer should have the ability to cancel a ticket, thereby changing its status from valid to cancelled.

The system should support two user classes:

Viewers:

Browsing the repertoire and purchasing tickets for a selected screening.
Reserving chosen seats in the cinema hall.
Ticket Officers:
