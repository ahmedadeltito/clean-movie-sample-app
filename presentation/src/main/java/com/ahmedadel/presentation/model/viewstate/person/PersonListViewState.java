package com.ahmedadel.presentation.model.viewstate.person;

import com.ahmedadel.presentation.model.PersonUIModel;
import com.ahmedadel.presentation.model.viewstate.NetworkState;

import java.util.List;

public class PersonListViewState {

    private NetworkState networkState;
    private List<PersonUIModel> persons;

    public NetworkState getNetworkState() {
        return networkState;
    }

    public void setNetworkState(NetworkState networkState) {
        this.networkState = networkState;
    }

    public List<PersonUIModel> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonUIModel> persons) {
        this.persons = persons;
    }
}
