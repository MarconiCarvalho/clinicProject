package com.project.clinic.models.user;

public enum UserType {
    ADMIN("admin"),
    FRONTDESK("frontdesk"),
    SPECIALIST("specialist");

    private String type;

    UserType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
