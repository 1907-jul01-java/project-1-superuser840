drop table if exists workers, reimbursements;

create table workers {
    id serial primary key,
    firstname text,
    lastname text,
    email text unique not null,
    password text not null,
    usertype text not null
};

create table reimbursements {
    id serial primary key,
    approved boolean not null,
    -- imageurl text,
    description text,
    cost numeric(10,2),
    employee text references workers(email) on delete cascade
};

-- Populate the things --
insert into workers (firstname, lastname, email, password, usertype) values ('John', 'Smith', 'john@revature.portal', 'manager');
insert into workers (firstname, lastname, email, password, usertype) values ('Candy', 'Applesmith', 'canapple@gmail.com', 'employee');
insert into workers (firstname, lastname, email, password, usertype) values ('Jipper', 'Chipperton', 'JippChipp@hotmail.com', 'employee');
insert into workers (firstname, lastname, email, password, usertype) values ('Bell', 'Cranel', 'hestiafamilia@anime.net', 'employee');

insert into reimbursements (approved, description, cost, employee) values ('f', 'foot got stuck in toaster, lost two toes in the attempt to remove toaster', 20.89, 'canapple@gmail.com');
insert into reimbursements (approved, description, cost, employee) values ('f', 'Flight got cancled and had to purchase a different ticket', 468.99, 'JippChipp@hotmail.com');
insert into reimbursements (approved, description, cost, employee) values ('f', 'Upon arriving at destination luggage was lost by airline, had to purchase new clothes and luggage', 356.86, 'JippChipp@hotmail.com');
insert into reimbursements (approved, description, cost, employee) values ('f', 'Armor became damadged during last trip in dungeon and needed replacing', 45.99, 'hestiafamilia@anime.net');


