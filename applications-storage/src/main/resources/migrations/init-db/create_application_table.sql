-- Create Table
-- ================================================================
-- Application
create table application
(
    id              bigserial          not null,
    integration_id  varchar(36)        not null,
    pickup_code     varchar(255)       null     default null,
    status          varchar(255)       not null default 'CREATED',
    created_at      timestamp          not null default now(),
    updated_at      timestamp          null     default null,

    constraint application_pk primary key (id)
);

create index application_integration_id_idx on application (integration_id);