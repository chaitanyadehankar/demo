insert into BUS (BUS_ID,OPERATOR_NAME,CAPACITY,price_per_seat,costly_seat_price) 
values(1,'AAA',10,500,550);
insert into BUS (BUS_ID,OPERATOR_NAME,CAPACITY,price_per_seat,costly_seat_price) 
values(2,'BBB',20,600,650);

insert into bus_costly_seats(bus_bus_id,costly_seats) values(1,2);
insert into bus_costly_seats(bus_bus_id,costly_seats) values(1,6);
insert into bus_costly_seats(bus_bus_id,costly_seats) values(1,8);

insert into bus_costly_seats(bus_bus_id,costly_seats) values(2,5);
insert into bus_costly_seats(bus_bus_id,costly_seats) values(2,7);

insert into schedule(id,arrival_time,departure_time,destination,source,bus_bus_id,days)
values(101,'9.30','10.00',2,1,1,'MONDAY,TUESDAY');
insert into schedule(id,arrival_time,departure_time,destination,source,bus_bus_id,days)
values(102,'11.30','12.00',2,1,2,'MONDAY,TUESDAY');
insert into schedule(id,arrival_time,departure_time,destination,source,bus_bus_id,days)
values(103,'11.30','12.00',2,1,2,'FRIDAY');

insert into locations(id,location) values(1,'Yavatmal');
insert into locations(id,location) values(2,'Nagapur');

insert into booking(id,available_seats,booking_date,schedule_id)
values(201,5,'2020-07-07',101);
insert into booking_booked_seats(booking_id,booked_seats) 
values (201,1);
insert into booking_booked_seats(booking_id,booked_seats) 
values (201,2);
insert into booking_booked_seats(booking_id,booked_seats) 
values (201,3);
insert into booking_booked_seats(booking_id,booked_seats) 
values (201,4);
insert into booking_booked_seats(booking_id,booked_seats) 
values (201,5); 