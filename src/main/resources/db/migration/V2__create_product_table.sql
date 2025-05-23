CREATE TABLE product(
    id serial PRIMARY KEY,
    name varchar(255) not null unique,
    description varchar(255),
    price DECIMAL(15,2) not null,
    stock_quantity INT not null,
    image_url varchar(255)
)