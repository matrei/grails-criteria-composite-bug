# Composite Key in criteria bug

GORM for Hibernate 5 7.0.0 throws a IllegalArgumentException when attempting to access a composite key property of a domain.
The exception message is: Unable to locate Attribute  with the the given name [domain1] on this ManagedType [composite.Domain1Domain2]

## Steps to recreate:

Run test in project.
