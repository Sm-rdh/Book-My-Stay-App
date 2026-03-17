# Use Case 10: Booking Cancellation & Inventory Rollback

## Description
Allows safe cancellation of bookings and restores inventory.

## Concepts Used
- Stack (LIFO rollback)
- State reversal
- Inventory restoration

## Flow
Cancel booking → Restore inventory → Track rollback

## Output
Booking Cancellation  
Booking cancelled successfully. Inventory restored for room type: Single  

Rollback History (Most Recent First):  
Released Reservation ID: Single-1  

Updated Single Room Availability: 6  
