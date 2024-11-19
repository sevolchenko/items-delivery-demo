-- Create Sequences
-- ================================================================
create sequence item_sequence start with 1 increment by 1;

-- Create Tables
-- ================================================================
-- Document
create table item
(
    id              bigint            not null default nextVal('item_sequence'),
    type            varchar(255)      not null,
    color           varchar(255)      null     default null,
    status          varchar(255)      not null default 'AVAILABLE',
    created_at      timestamp         not null default NOW(),
    updated_at      timestamp         null     default NOW(),

    constraint item_pk primary key (id)
);