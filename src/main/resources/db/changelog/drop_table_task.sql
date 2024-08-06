--liquibase formatted sql
--changeset vasily:drop-table-task
DROP TABLE IF EXISTS task;