-- Create Tables
-- ================================================================
-- Document
create table cell_dimensions
(
    id         uuid primary key                  default gen_random_uuid(),
    length     double precision      not null    default 1.0,
    height     double precision      not null    default 1.0,
    width      double precision      not null    default 1.0

);

