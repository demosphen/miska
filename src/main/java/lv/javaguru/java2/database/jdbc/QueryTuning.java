package lv.javaguru.java2.database.jdbc;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

// TODO: this has to user prepared statements, not string concatination
public class QueryTuning {
    private int queryOffset;
    private int queryLimit;
    private List<ImmutablePair<String, Boolean>> sortOrder = new ArrayList<ImmutablePair<String, Boolean>>();

    public void setQueryOffset(int offset) {
        this.queryOffset = Math.max(offset, 0);
    }

    public void setQueryLimit(int limit) {
        this.queryLimit = limit;
    }

    public void setPagedQuery(int page) {
        setQueryOffset(this.queryLimit * (page - 1));
    }

    public void resetSortOrder() {
        sortOrder.clear();
    }

    public void addSortOrderAsc(String column) {
        addSortOrder(column, false);
    }

    public void addSortOrder(String column, Boolean direction) {
        sortOrder.add(new ImmutablePair<String, Boolean>(column, direction));
    }

    public String tuneQuery(String sql) {
        return sql + getOrderByPhrase() + getPaginationPhrase();
    }

    private String getPaginationPhrase() {
        if (queryLimit == 0) {
            if (queryOffset == 0)
                return "";
            else
                return " LIMIT " + queryOffset + "," + Integer.MAX_VALUE;
        } else {
            if (queryOffset == 0)
                return " LIMIT " + queryLimit;
            else
                return " LIMIT " + queryOffset + "," + queryLimit;
        }
    }

    private String getOrderByPhrase() {
        if (sortOrder.isEmpty())
            return "";
        String orderByPhrase = " ORDER BY ";
        for (Pair<String, Boolean> sortColumn : sortOrder) {
            orderByPhrase += sortColumn.getKey() + " " + (sortColumn.getValue() ? "DESC" : "ASC") + " ,";
        }
        return orderByPhrase.substring(0, orderByPhrase.length() - 1);
    }


}
