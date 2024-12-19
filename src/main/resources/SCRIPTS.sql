create table public.exercises
(
    id     uuid default uuid_generate_v4() not null
        constraint exercise_pkey
            primary key,
    name   varchar(255),
    reps   integer,
    sets   integer,
    weight integer
);

create table public.workout_exercise
(
    id          uuid default uuid_generate_v4() not null
        primary key,
    workout_id  uuid                            not null,
    exercise_id uuid                            not null
);

create table public.workouts
(
    id   uuid default uuid_generate_v4() not null
        constraint workout_pkey
            primary key,
    is_active boolean not null default false,
    date timestamp(6),
    name varchar(255)
);
