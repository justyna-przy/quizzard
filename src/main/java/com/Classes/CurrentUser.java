package com.Classes;

/*
  The CurrentUser class represents the user that is logged in rn.
  holds info like the username and email of the logged-in user.
 */
public class CurrentUser {

    // The username of the current logged-in user here below.
    private String username;

    private String email;

    /*
     This is my getter method to get the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the current logged-in user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email address of the current logged-in user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the current logged-in user.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
