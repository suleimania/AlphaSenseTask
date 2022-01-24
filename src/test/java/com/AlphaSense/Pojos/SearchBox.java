package com.AlphaSense.Pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchBox {

    private List<Object> topics = null;
    private SearchResults searchResults;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Object> getTopics() {
        return topics;
    }

    public void setTopics(List<Object> topics) {
        this.topics = topics;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
