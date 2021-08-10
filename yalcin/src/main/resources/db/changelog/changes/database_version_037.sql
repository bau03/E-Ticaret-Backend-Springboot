create table if not exists "users"
(
    id          serial primary key,
    username    varchar(50)  unique,
    email       varchar(100) not null unique,
    password    varchar(255) ,
    name        varchar(25),
    lastname    varchar(25),
    age         varchar(3),
    adress      varchar(100),
    phone_number varchar(10)
);
create table if not exists "total_order"(
 id               serial primary key,
 user_id          int not null references users(id),
 store_id         int not null references store(id),
 total_price      float(50)
);
create table if not exists "showcase"
(
    id               serial primary key,
    user_id          int not null references users(id),
    product_id       int not null references product(id),
    start_time       date,
    price            float(50),
    ende_time        date
);
create table if not exists "order_user"
(
    id               serial primary key,
    user_id          int not null references users(id),
    adress_id        int not null references users_adress(id),
    product_id       int not null references product(id)
);
create table if not exists "product"
(
    id               serial primary key,
    user_id          int not null references users(id),
    product_name     varchar(255),
    explanation      varchar(255),
    product_image    varchar ,
    price            float(50),
    stock            int,
    timestap         date
);
create table if not exists "purse"
(
    id               serial primary key,
    user_id          int not null references users(id),
    balance          float(50),
    timestap         date
);
create table if not exists "store"
(
    id               serial primary key,
    user_id          int not null references users(id),
    product_id       int not null references product(id),
    timestap         date
);
create table if not exists "product_category"
(
    product_id int references product (id),
    category_id int references cloud_category (id)
);
create table if not exists "cloud_category"
(
    id               serial primary key,
    category         varchar(50) unique
);
create table if not exists "cloud_roles"
(
    id               serial primary key,
    role             varchar(50) not null unique,
    is_account_admin boolean     not null default false
);
create table if not exists "users_adress"
(
    id               serial primary key,
    user_id int not null references users(id),
    country varchar(20),
    province varchar(20),
    district varchar(20),
    street varchar(20),
    building_number varchar(20),
    adress_type varchar(20)
);

create table if not exists "seller_begin"(
 id    serial primary key,
 content varchar (1000),
 timestap date ,
 user_id int not null references users(id)
);

create table if not exists "user_roles"
(
    user_id int not null references users (id),
    role_id int not null references cloud_roles (id)
);
create table if not exists "email_templates"(
     id serial primary key,
     template_name text not null unique ,
     content text not null
);

create table if not exists  "token_blacklist" (
      token text primary key not null unique,
      type varchar(50) not null
);

create table if not exists  "user_attempt" (
    ip varchar(255) primary key,
    attempt_counter int not null,
    first_attempt_date timestamp without time zone NOT NULL
);

create table if not exists  "active_sessions" (
    refresh_token varchar(255) primary key,
    access_token varchar(255),
    user_agent text,
    issue_date timestamp without time zone NOT NULL,
    expire_date timestamp without time zone NOT NULL,
    user_id int not null references users(id)
);