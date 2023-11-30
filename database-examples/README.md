pgadmin http://localhost:5050/

Create Table

    CREATE TABLE public.students
    (
        id bigint NOT NULL,
        name "char",
        PRIMARY KEY (id)
    );

    ALTER TABLE IF EXISTS public.students
        OWNER to postgres;