-- Create Tables
-- ================================================================
-- Document
create table placement
(
    id         varchar(255) primary key,
    product_id varchar(255) not null,
    cell_id    varchar(255) not null,
    created_at timestamp    not null,
    updated_at timestamp,
    status     varchar(50)  not null,

    constraint fk_cell foreign key (cell_id) references cell (id) on delete set null
);

