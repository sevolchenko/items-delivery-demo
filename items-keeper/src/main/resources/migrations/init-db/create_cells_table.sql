-- Create Tables
-- ================================================================
-- Document
create table cells
(
    id                    uuid primary key   not null    default gen_random_uuid(),
    name                  varchar(255)       not null    default 'Default',
    cell_dimensions       uuid               null        default null,

    constraint fk_cell_dimensions foreign key (cell_dimensions) references cell_dimensions (id) on delete set null
);