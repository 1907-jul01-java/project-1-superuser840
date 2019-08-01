drop table if exists workers, reimbursements;

create table workers {
    id serial primary key,
    firstname text,
    lastname text,
    email text not null,
    password text not null,
    permission integer not null
};

create table reimbursements {
    id serial primary key,
    

};
