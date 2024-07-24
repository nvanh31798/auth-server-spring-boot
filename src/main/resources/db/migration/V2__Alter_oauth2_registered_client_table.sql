ALTER TABLE oauth2_registered_client
    ADD COLUMN post_logout_redirect_uris VARCHAR(1000);
