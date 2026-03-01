
DROP TABLE IF EXISTS career_suggestions CASCADE;
DROP TABLE IF EXISTS user_profiles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TYPE IF EXISTS user_role;

CREATE TYPE user_role AS ENUM ('ADMIN', 'MENTOR', 'STUDENT');

CREATE TABLE users (
    id           BIGSERIAL PRIMARY KEY,
    full_name    VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    role         user_role    NOT NULL,
    created_at   TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);

CREATE TABLE user_profiles (
    user_id       BIGINT       PRIMARY KEY,
    skills        TEXT,
    experience    TEXT,
    education     TEXT,
    career_goal   TEXT,
    created_at    TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_user_profiles_user
        FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE career_suggestions (
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT      NOT NULL,
    advice_text  TEXT        NOT NULL,
    suggestion_date DATE     NOT NULL DEFAULT CURRENT_DATE,
    created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_suggestions_user
        FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_user_profiles_user_id
    ON user_profiles (user_id);

CREATE INDEX idx_career_suggestions_user_id
    ON career_suggestions (user_id);

