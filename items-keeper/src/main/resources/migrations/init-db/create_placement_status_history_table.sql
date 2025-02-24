-- Create Tables
-- ================================================================
-- Document
create table placement_status_history
(
    id            uuid primary key              default gen_random_uuid(),
    cell_id       uuid,
    timestamp     timestamp          not null,
    new_status    varchar(50),

    constraint fk_cell foreign key (cell_id) references cell (id) on delete set null
);

