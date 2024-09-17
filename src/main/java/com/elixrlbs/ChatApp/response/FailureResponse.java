package com.elixrlbs.ChatApp.response;

import java.util.List;

/**
 * Response class for failure or exception purpose
 */
public class FailureResponse {

    private List<String> error;

    public FailureResponse(List<String> error) {
        this.error = error;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }
}
