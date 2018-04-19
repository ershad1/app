INSERT INTO role (id, label) VALUES (1, 'SUPER_ADMIN');
INSERT INTO role (id, label) VALUES (2, 'ADMIN');
INSERT INTO role (id, label) VALUES (3, 'MANAGER');
INSERT INTO role (id, label) VALUES (4, 'USER');

-- INSERT INTO privilege (id, label) VALUES (1, 'ROLE_ADMIN');
-- INSERT INTO privilege (id, label) VALUES (2, 'ROLE_MANAGER');
-- INSERT INTO privilege (id, label) VALUES (3, 'ROLE_USER');

INSERT INTO organization_type (id, version, full_name, created_date, modified_date, status) VALUES (1, 0, 'SUPPLIER', 0, 0, 'ACTIVE');
INSERT INTO organization_type (id, version, full_name, created_date, modified_date, status) VALUES (2, 0, 'BUYER', 0, 0, 'ACTIVE');

INSERT INTO country (id, uuid, version, iso, iso3, fips, full_name, continent, currency_code, currency_name, phone_prefix, postal_code, languages, geo_name_id, created_date, modified_date, status, selected) VALUES (50, '0e6f3cfc-6844-4e65-ae7f-d2d2add41249', 0, 'BD', 'BGD', 'BG', 'Bangladesh', 'AS', 'BDT', 'Taka', '880', '^(d{4})$', 'bn-BD,en', '1210997', 1471642399, 1471642399, 'ACTIVE', 1);

INSERT INTO app_language (id, uuid, version, full_name, code, created_date, modified_date, status) VALUES (15, 'c102b335-276f-4617-8726-df66edf9fe16', 0, 'Bangla', 'bn', 1471642399, 1471642399, 'ACTIVE');
INSERT INTO app_language (id, uuid, version, full_name, code, created_date, modified_date, status) VALUES (1, '088f7952-55e5-4b6c-af0e-5867a15d76f1', 0, 'English', 'en', 1471642399, 1471642399, 'ACTIVE');


INSERT INTO address (created_by, created_date, modified_by, modified_date, status, uuid, version, address_one, address_two, district, division, sub_district, country_id) VALUES (NULL, 0, '0', 0, 'ACTIVE', NULL, 0, 'Test', NULL, 'Dhaka', 'Dhaka', 'Gulshan', 50);

INSERT INTO organization (created_by, created_date, modified_by, modified_date, status, uuid, version, full_name, address_id, organization_type_id, app_language_id) VALUES (NULL, 0, NULL, 0, 'ACTIVE', NULL, 0, 'Market Care Link', 1, 1, 15);
INSERT INTO organization (created_by, created_date, modified_by, modified_date, status, uuid, version, full_name, address_id, organization_type_id, app_language_id) VALUES (NULL, 0, NULL, 0, 'ACTIVE', NULL, 0, 'Banglalink', 1, 2, 15);

INSERT INTO branch (created_by, created_date, modified_by, modified_date, status, uuid, version, full_name, address_id, organization_id) VALUES (NULL, 0, NULL, 0, 'ACTIVE', NULL, 0, 'Head Office', 1, 1);

INSERT INTO user (id, full_name, username, password, email, role_id, app_language_id) VALUES (1, 'superadmin', 'superadmin', '$2a$10$3sdTFgvQ1P3O./Qq7dDjye4t7lz5Ij80zoLNqVogU7kfJRMS/PPNa', 'test1@user.com', 1, 15);
INSERT INTO user (id, full_name, username, password, email, role_id, app_language_id) VALUES (2, 'admin', 'admin', '$2a$10$3sdTFgvQ1P3O./Qq7dDjye4t7lz5Ij80zoLNqVogU7kfJRMS/PPNa', 'test1@user.com', 2, 15);
INSERT INTO user (id, full_name, username, password, email, role_id, address_id, organization_id, app_language_id, region_id) VALUES (3, 'manager', 'manager', '$2a$10$3sdTFgvQ1P3O./Qq7dDjye4t7lz5Ij80zoLNqVogU7kfJRMS/PPNa', 'test2@user.com', 3, 1, 1, 15, 1);
INSERT INTO user (id, full_name, username, password, email, role_id, address_id, organization_id, app_language_id, region_id) VALUES (4, 'user', 'user', '$2a$10$3sdTFgvQ1P3O./Qq7dDjye4t7lz5Ij80zoLNqVogU7kfJRMS/PPNa', 'test3@user.com', 4, 1, 1, 15, 1);

