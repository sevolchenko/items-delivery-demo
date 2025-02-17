-- Create Table
-- ================================================================
-- Product
create table product
(
    id              bigserial          not null,
    integration_id  varchar(36)        not null,
    type            varchar(255)       null     default null,
    custom_text     varchar(255)       null     default null,
    application_id  bigint             null     default null,
    item_number     varchar(255)       null     default null,
    created_at      timestamp          not null default now(),
    updated_at      timestamp          null     default null,

    constraint product_pk primary key (id),
    constraint product_fk_application foreign key (application_id) references application (id)
        on delete cascade
);

create index product_integration_id_application_id_idx on product (integration_id, application_id);