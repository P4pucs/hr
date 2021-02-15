# hr

On creating a lease it sets the "starDate" to current date and the "active" to true   
On patch request from leases/close/:id "active": false, it sets the "enddate" to current date closes the lease.  

The stored prucedure gets created on appstart but cannot be called.
