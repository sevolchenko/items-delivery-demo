-- Create Table
-- ================================================================
-- Task
create table task
(
    id              bigserial          not null,
    task_id         varchar(255)       not null default gen_random_uuid(),
    application_id  varchar(255)       null,
    placement_id    varchar(255)       null,
    pickup_code     varchar(255)       null,
    type            varchar(255)       null,
    status          varchar(255)       not null default 'WAITING_FOR_HANDLING',
    operator_id     varchar(255)       null,
    created_at      timestamp          not null default now(),
    updated_at      timestamp          null,
    constraint task_pk primary key (id)
);

create index idx_task_pickup_code on task (pickup_code);
create index idx_task_task_id on task (task_id);