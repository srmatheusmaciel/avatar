CREATE TABLE IF NOT EXISTS profile_photo (
    customer_id VARCHAR(36) NOT NULL,
    id VARCHAR(36) NOT NULL,
    original_photo VARCHAR(200),
    generated_photo VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (customer_id, id)
);

INSERT INTO profile_photo (customer_id, id, original_photo, generated_photo) VALUES
("customer-1", "0604f0d7-1c4a-4a4a-9b4a-1c4a4a4a4a4a", "customer-1-original-photo-1-path", "customer-1-generated-photo-1-path"),
("customer-1", "0604f0d7-1c4a-4a4a-9b4a-1c4a4a4a4a4b", "customer-1-original-photo-2-path", "customer-1-generated-photo-2-path"),
("customer-2", "0604f0d7-1c4a-4a4a-9b4a-1c4a4a4a4a4c", "customer-2-original-photo-1-path", "customer-2-generated-photo-1-path");