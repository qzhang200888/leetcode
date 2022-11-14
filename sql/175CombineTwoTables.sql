select P.firstName as firstName, P.lastName as lastName,
A.city as city, A.state as state
from Person as P
left join Address as A
on P.personId = A.personId;
