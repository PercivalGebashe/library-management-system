CREATE TABLE organizations (
    id VARCHAR(26) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    address TEXT NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_organization_id ON organizations(id);
