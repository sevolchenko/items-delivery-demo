-- Create Tables
-- ================================================================
-- Document
create table item
(
    id              uuid              not null default gen_random_uuid(),
    type            varchar(255)      not null,
    color           varchar(255)      null     default null,
    status          varchar(255)      not null default 'AVAILABLE',
    created_at      timestamp         not null default NOW(),
    updated_at      timestamp         null     default NOW(),

    constraint item_pk primary key (id)
);