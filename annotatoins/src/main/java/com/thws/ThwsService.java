package com.thws;

import java.time.ZonedDateTime;

public class ThwsService {

    ZonedDateTime created;

    public ThwsService() {

        created = ZonedDateTime.now();
    }

    public ZonedDateTime getCreatedDate() {
        return created;
    }

}
