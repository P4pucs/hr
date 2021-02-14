# hr

On creating a lease it saves the current time and once it gets a false value on a patch request from leases/close/:id, it sets the enddate and closes the lease.  

The stored prucedure gets created on appstart but cannot be called.
