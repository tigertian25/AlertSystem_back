-- begin ALERTSYSTEM_PROCESS
create table ALERTSYSTEM_PROCESS (
    ID integer,
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ALERTSYSTEM_PROCESS
-- begin ALERTSYSTEM_ALERT_TYPE
create table ALERTSYSTEM_ALERT_TYPE (
    ID integer,
    --
    FROM_PROCESS_ID integer,
    TO_PROCESS_ID integer,
    ALLOWED_DURATION integer,
    SINGLE_MAX_DURATION integer not null,
    TOTAL_MAX_DURATION integer not null,
    --
    primary key (ID)
)^
-- end ALERTSYSTEM_ALERT_TYPE
-- begin ALERTSYSTEM_ALERT_SNOOZE
create table ALERTSYSTEM_ALERT_SNOOZE (
    ID integer,
    --
    ALERT_TYPE_ID integer,
    SAMPLE_ORDER_ID integer not null,
    DURATION integer not null,
    CREATE_TIME datetime not null,
    --
    primary key (ID)
)^
-- end ALERTSYSTEM_ALERT_SNOOZE
