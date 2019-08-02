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
