-- Create Tables
-- ================================================================
-- Document
create table placements
(
    id            uuid primary key                  default gen_random_uuid(),
    product_id    uuid                  not null,
    cell_id       uuid                  not null,
    created_at    timestamp             not null    default now(),
    updated_at    timestamp                         default null,
    status        varchar(50)           not null    default 'FREE',

    constraint fk_cell foreign key (cell_id) references cells (id) on delete set null
);

