-- Create Sequences
-- ================================================================
create sequence items_sequence start with 1 increment by 1;

-- Create Tables
-- ================================================================
-- Document
create table items
(
    id              bigint                   not null default nextVal('items_sequence'),
    type            varchar(255)             not null,
    color           varchar(255)             null     default null,
    status          varchar(255)             not null default 'AVAILABLE',
    created_at      timestamp with time zone not null default NOW(),
    updated_at      timestamp with time zone null     default NOW(),

    constraint items_pk primary key (id)
);