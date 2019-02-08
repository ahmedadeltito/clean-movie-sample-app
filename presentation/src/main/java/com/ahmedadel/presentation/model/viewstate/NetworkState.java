package com.ahmedadel.presentation.model.viewstate;

public class NetworkState {

    private ViewStatus viewStatus;
    private String message;

    private NetworkState(ViewStatus viewStatus, String message) {
        this.viewStatus = viewStatus;
        this.message = message;
    }

    public ViewStatus getViewStatus() {
        return viewStatus;
    }

    public String getMessage() {
        return message;
    }

    public static NetworkState LOADING = new NetworkState(ViewStatus.RUNNING, "running");
    public static NetworkState LOADED = new NetworkState(ViewStatus.SUCCESS, "success");

    public static NetworkState error(String message) {
        return new NetworkState(ViewStatus.FAILED, message);
    }

}
