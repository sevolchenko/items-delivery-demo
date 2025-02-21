-- Create Tables
-- ================================================================
-- Document
create table cell_dimensions
(
    id         uuid primary key                  default gen_random_uuid(),
    length     double precision      not null,
    height     double precision      not null,
    width      double precision      not null

);

