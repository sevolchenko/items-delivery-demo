-- Create Tables
-- ================================================================
-- Document
create table cell_dimensions
(
    id     varchar(255) primary key,
    length double precision not null,
    height double precision not null,
    width  double precision not null

);

