package com.steven.hicks.beans;

public abstract class ItemList
{
    int itemsPerPage;
    int total;
    int page;

    public int getItemsPerPage()
    {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage)
    {
        this.itemsPerPage = itemsPerPage;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
}
