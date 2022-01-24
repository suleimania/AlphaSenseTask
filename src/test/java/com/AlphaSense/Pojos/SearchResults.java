package com.AlphaSense.Pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResults {

    private Object cursorToken;
    private int originalStatementCount;
    private List<Statement> statements = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getCursorToken() {
        return cursorToken;
    }

    public void setCursorToken(Object cursorToken) {
        this.cursorToken = cursorToken;
    }

    public int getOriginalStatementCount() {
        return originalStatementCount;
    }

    public void setOriginalStatementCount(int originalStatementCount) {
        this.originalStatementCount = originalStatementCount;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
