-- Create Tables
-- ================================================================
-- Document
create table placement
(
    id            uuid primary key                  default gen_random_uuid(),
    product_id    uuid                  not null,
    cell_id       uuid                  not null,
    created_at    timestamp             not null,
    updated_at    timestamp,
    status        varchar(50)           not null,

    constraint fk_cell foreign key (cell_id) references cells (id) on delete set null
);

