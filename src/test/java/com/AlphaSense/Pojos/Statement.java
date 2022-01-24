package com.AlphaSense.Pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statement{

    private String accessionNumber;
    private List<String> collapsedStatements = null;
    private String content;
    private boolean context;
    private int page;
    private boolean recurring;
    private int snippetCount;
    private int snippetOffset;
    private String statementId;
    private int statementIndex;
    private int statementIndexOffset;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public List<String> getCollapsedStatements() {
        return collapsedStatements;
    }

    public void setCollapsedStatements(List<String> collapsedStatements) {
        this.collapsedStatements = collapsedStatements;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isContext() {
        return context;
    }

    public void setContext(boolean context) {
        this.context = context;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public int getSnippetCount() {
        return snippetCount;
    }

    public void setSnippetCount(int snippetCount) {
        this.snippetCount = snippetCount;
    }

    public int getSnippetOffset() {
        return snippetOffset;
    }

    public void setSnippetOffset(int snippetOffset) {
        this.snippetOffset = snippetOffset;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public int getStatementIndex() {
        return statementIndex;
    }

    public void setStatementIndex(int statementIndex) {
        this.statementIndex = statementIndex;
    }

    public int getStatementIndexOffset() {
        return statementIndexOffset;
    }

    public void setStatementIndexOffset(int statementIndexOffset) {
        this.statementIndexOffset = statementIndexOffset;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
