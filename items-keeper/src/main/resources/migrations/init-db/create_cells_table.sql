-- Create Tables
-- ================================================================
-- Document
create table cell
(
    id                 varchar(255) primary key not null,
    name               varchar(255)             not null,
    cell_dimensions_id varchar(255)             null     default null,

    constraint fk_cell_dimensions foreign key (cell_dimensions_id) references cell_dimensions (id) on delete set null
);