package com.horizon.utility;

public enum resources {
    login("/user/login"),
    inspection("/playlists/00FuEH5sS2bxWfoXYimQky");

    private String resource;

    public String getResource() {
        return resource;
    }

    resources(String resource)
    {
        this.resource = resource;
    }


}
