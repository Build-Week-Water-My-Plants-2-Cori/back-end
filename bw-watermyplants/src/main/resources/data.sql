INSERT INTO USERS(USERID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, PASSWORD, PHONE, PRIMARYEMAIL, USERNAME)
    VALUES (1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '$2y$12$YePD/QxewCWcA5SDOwVE3e6bNi9TTnM.WncIKFt40PQr9.G6bOXS.', '123-456-7890', 'admin@local.com', 'admin'),
           (2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '$2y$12$YePD/QxewCWcA5SDOwVE3e6bNi9TTnM.WncIKFt40PQr9.G6bOXS.', '789-456-1230', 'billy@local.com', 'billy');

INSERT INTO PLANTS(PLANTID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_DATE, FREQUENCY, NICKNAME, PHOTO, SPECIES, USERID)
    VALUES (1, 'SYSTEM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Daily', 'Sunshine', 'front porch', 'Sunflower', 1),
            (2, 'SYSTEM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Once a week', 'Moonbeam', 'Kitchen Sink', 'Japanese Knotweed', 2),
            (3, 'SYSTEM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Weekly', 'Pretty', 'back porch', 'Rose', 1),
            (4, 'SYSTEM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Often', 'Audrey', 'Basement', 'VenusFlytrap', 2);




    /* Restarts Ids */
    alter sequence hibernate_sequence restart with 20;
