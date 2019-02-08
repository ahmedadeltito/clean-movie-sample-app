package com.ahmedadel.presentation.model.viewstate.tv;

import com.ahmedadel.presentation.model.TVUIModel;
import com.ahmedadel.presentation.model.viewstate.NetworkState;

import java.util.List;

public class TVListViewState {

    private NetworkState networkState;
    private List<TVUIModel> tvs;

    public NetworkState getNetworkState() {
        return networkState;
    }

    public void setNetworkState(NetworkState networkState) {
        this.networkState = networkState;
    }

    public List<TVUIModel> getTvs() {
        return tvs;
    }

    public void setTvs(List<TVUIModel> tvs) {
        this.tvs = tvs;
    }
}
