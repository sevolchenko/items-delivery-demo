-- Create Sequences
-- ================================================================
create sequence link_sequence start with 1 increment by 1;

-- Create Tables
-- ================================================================
-- Document
create table items
(
    id              bigint                   not null default nextVal('link_sequence'),
    type            varchar(255)             not null,
    color           varchar(255)             null,
    status          varchar(255)             not null,
    created_at      timestamp with time zone not null,
    updated_at      timestamp with time zone null,

    constraint link_pk primary key (id)
);