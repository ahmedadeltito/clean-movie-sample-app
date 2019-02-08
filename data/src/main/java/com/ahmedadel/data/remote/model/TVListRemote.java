package com.ahmedadel.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVListRemote {

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<TVRemote> tvs;

    @SerializedName("total_results")
    private int totalResults;

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTVs(List<TVRemote> tvs) {
        this.tvs = tvs;
    }

    public List<TVRemote> getTVs() {
        return tvs;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalResults() {
        return totalResults;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return
                "TVListRemote{" +
                        "page = '" + page + '\'' +
                        ",total_pages = '" + totalPages + '\'' +
                        ",TVs = '" + tvs + '\'' +
                        ",total_results = '" + totalResults + '\'' +
                        "}";
    }
}