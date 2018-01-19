package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.search;

import com.mrc.vidiohuoshandemo.util.OnNetLinsenter;

public class SearchPersenter {
    private ISearchModel model;
    private ISearchView view;

    SearchPersenter(ISearchView view) {
        this.view = view;
        model=new SearchModel();
    }
    public void showSearch(){
       model.searchData(new OnNetLinsenter<SearchBean>() {
           @Override
           public void callBack(SearchBean searchBean) {
               view.searchShow(searchBean);
           }
       });

    }
}
