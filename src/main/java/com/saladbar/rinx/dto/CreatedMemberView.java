package com.saladbar.rinx.dto;

import java.sql.Date;

public interface CreatedMemberView {

    String getFirstName();
    String getLastName();
    String getEmail();
    Date getDateJoined();

}
